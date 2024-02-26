package br.com.pyetro.user.services;

import br.com.pyetro.user.entities.User;
import br.com.pyetro.user.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User createUser(User user) {
        LOGGER.info("New user created: " + user.getName() + " (ID: " + user.getId() + ")");
        return userRepository.save(user);
    }
    public Iterable<User> findAll() {
        LOGGER.info("Users " + userRepository.count());
        return userRepository.findAll();
    }
    public Optional<User> findUserById(User user){
        LOGGER.info("finding user by Id " + user.getId());
        return userRepository.findById(user.getId());
    }

    public Optional<User> findRandomUser() {
        LOGGER.info("Finding random user");
        return userRepository.findRandomUser();
    }

    public User updateUser(User user){
        try {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if(existingUser.isPresent()){
                User userUpdate = existingUser.get();
                userUpdate.setName(user.getName());
                userUpdate.setAge(user.getAge());
                userUpdate.setEmail(user.getEmail());
                userRepository.save(userUpdate);
                LOGGER.info("ser updated successfully:  " + user.getId());
            } else {
                throw new RuntimeException("User not found by Id: " + user.getId());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to update user with ID  " + e.getMessage(), e);
            throw new RuntimeException("Error updating user:  " + e.getMessage());
        }

        return user;
    }

    public void deleteUserById(User user){
        try {
            userRepository.deleteById(user.getId());
            LOGGER.info("User deleted successfully: " + user.getId());
        } catch (Exception e) {
            LOGGER.error("Failed to delete user with ID " + user.getId() + ": " + e.getMessage(), e);
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
}
