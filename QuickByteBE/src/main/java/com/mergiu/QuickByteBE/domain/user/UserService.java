package com.mergiu.QuickByteBE.domain.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByPhoneNumber(user.getPhoneNumber());

        if (userOptional.isPresent())
            throw new IllegalStateException("Phone number taken");

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists)
            throw new IllegalStateException("User with id " + userId + " does not exist");

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String phoneNumber) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist"));

        if (firstName != null &&
                !firstName.isEmpty() &&
                !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }

        if (lastName != null &&
                !lastName.isEmpty() &&
                !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }

        if (phoneNumber != null &&
                !phoneNumber.isEmpty() &&
                !Objects.equals(user.getPhoneNumber(), phoneNumber)) {
            Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);

            if (userOptional.isPresent()) {
                throw new IllegalStateException("Phone number taken");
            }

            user.setPhoneNumber(phoneNumber);
        }

        userRepository.save(user);
    }
}
