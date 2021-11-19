package com.bootstrap.bootstrap.service;

import com.bootstrap.bootstrap.dao.RoleDao;
import com.bootstrap.bootstrap.dao.UserDao;
import com.bootstrap.bootstrap.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

/**
 * @author Ali Veliev 10.11.2021
 */

@Service
public class UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public User readUser(Long id) {
        return userDao.readUser(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    public boolean isAllowed(Long id, Principal principal) {
        return userDao.isAllowed(id, principal);
    }
}
