package com.service;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.*;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public boolean updateUserProfile(User user) {
        return userRepository.updateUserProfile(user);
    }

    @Override
    public boolean removeUser(long id) {
        return userRepository.removeUser(id);
    }

    @Override
    public Set<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void setRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
