package repo.inMemory;

import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepo {
    private final List<User> users = new ArrayList<>();
    private int nextUserID = 1;

    /**
     * Create a new user and add it to the repository
     */
    public User createUser(int addressID, String firstName, String lastName, String phoneNumber) {
        User newUser = new User(nextUserID, addressID, firstName, lastName, phoneNumber);
        users.add(newUser);
        nextUserID++;
        return newUser;
    }

    /**
     * Retrieve a user by ID | Optional.empty() if not found
     */
    public Optional<User> getUserByID(int userID) {
        return users.stream()
                .filter(user -> Objects.equals(userID, user.userID()))
                .findFirst();
    }

    /**
     * Retrieve all users
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Update an existing user
     */
    public boolean updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User existingUser = users.get(i);
            if (Objects.equals(existingUser.userID(), updatedUser.userID())) {
                users.set(i, updatedUser);
                return true; // Update successful
            }
        }
        return false; // User not found
    }

    /**
     * Delete a user by ID
     */
    public boolean deleteUser(int userID) {
        return users.removeIf(user -> Objects.equals(userID, user.userID()));
    }
}
