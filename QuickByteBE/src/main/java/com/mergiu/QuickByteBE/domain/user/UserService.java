package com.mergiu.QuickByteBE.domain.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserObserver {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<SimpleUser> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(SimpleUser simpleUser) {
        Optional<SimpleUser> userOptional = userRepository.findByPhoneNumber(simpleUser.getPhoneNumber());

        if (userOptional.isPresent())
            throw new IllegalStateException("Phone number taken");

        userRepository.save(simpleUser);
        onUserCreated(simpleUser);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists)
            throw new IllegalStateException("User with id " + userId + " does not exist");

        userRepository.deleteById(userId);
        onUserDeleted(userId);
    }

    public void updateUser(Long userId, String firstName, String lastName, String phoneNumber) {
        SimpleUser simpleUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if (firstName != null &&
                !firstName.isEmpty() &&
                !Objects.equals(simpleUser.getFirstName(), firstName)) {
            simpleUser.setFirstName(firstName);
        }

        if (lastName != null &&
                !lastName.isEmpty() &&
                !Objects.equals(simpleUser.getLastName(), lastName)) {
            simpleUser.setLastName(lastName);
        }

        if (phoneNumber != null &&
                !phoneNumber.isEmpty() &&
                !Objects.equals(simpleUser.getPhoneNumber(), phoneNumber)) {
            Optional<SimpleUser> userOptional = userRepository.findByPhoneNumber(phoneNumber);

            if (userOptional.isPresent()) {
                throw new IllegalStateException("Phone number taken");
            }

            simpleUser.setPhoneNumber(phoneNumber);
        }

        userRepository.save(simpleUser);
        onUserUpdated(simpleUser);
    }

    @Override
    public void onUserCreated(SimpleUser simpleUser) {
        System.out.println("User created: " + simpleUser);
    }

    @Override
    public void onUserUpdated(SimpleUser simpleUser) {
        System.out.println("User updated: " + simpleUser);
    }

    @Override
    public void onUserDeleted(Long userId) {
        System.out.println("User deleted with ID: " + userId);
    }

    public void makeUserAdmin(Long userId) {
        SimpleUser simpleUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        UserRoleDecorator adminUser = new UserRoleDecorator(simpleUser, "Admin");

        userRepository.save(adminUser);
        onUserUpdated(adminUser);
    }
}
