package com.repository;

import com.model.User;

import java.util.Set;

public interface UserRepository {

    boolean addUser(User user);

    boolean updateUserProfile(User user);

    User getUserById(long id);

    User getUserByUsername(String username);

    boolean removeUser(long id);

    Set<User> getAllUsers();

}
