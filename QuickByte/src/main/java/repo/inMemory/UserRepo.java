package repo.inMemory;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private final List<User> users = new ArrayList<>();
    private long nextUserID = 1;

    /**
     * Create a new user and add it to the repository
     */
    public User createUser(String name, Long addressID, String phoneNumber) {
        User newUser = new User(nextUserID, name, addressID, phoneNumber);
        users.add(newUser);
        nextUserID++;
        return newUser;
    }

    /**
     * Retrieve a user by ID | NULL if not found
     */
    public User getUserByID(Long userID) {
        return users.stream()
                .filter(user -> user.userID().equals(userID))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Update an existing user and return the updated user
     */
    public User updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.userID().equals(updatedUser.userID())) {
                users.set(i, updatedUser);
                return updatedUser;
            }
        }

        return null; // User not found
    }

    /**
     * Delete a user by ID
     */
    public boolean deleteUser(Long userID) {
        return users.removeIf(user -> user.userID().equals(userID));
    }
}
