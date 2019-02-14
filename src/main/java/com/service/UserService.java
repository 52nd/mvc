package com.service;

import com.model.User;

import java.util.Set;

public interface UserService {

    boolean addUser(User user);

    User getUserById(long id);

    User getUserByUsername(String username);

    boolean updateUserProfile(User user);

    boolean removeUser(long id);

    Set<User> getAllUsers();

}
