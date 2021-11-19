package com.bootstrap.bootstrap.dao;

import com.bootstrap.bootstrap.model.User;

import java.security.Principal;
import java.util.List;

/**
 * @author Ali Veliev 08.11.2021
 */

public interface UserDao {
    void createUser(User user);
    User readUser(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByName(String name);
    List<User> allUsers();
    boolean isAllowed(Long id, Principal principal);
}
