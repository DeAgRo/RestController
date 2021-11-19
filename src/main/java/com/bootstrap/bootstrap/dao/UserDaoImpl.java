package com.bootstrap.bootstrap.dao;

import com.bootstrap.bootstrap.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.Principal;
import java.util.List;

/**
 * @author Ali Veliev 08.11.2021
 */

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;
    private final RoleDao roleDao;

    public UserDaoImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void createUser(User user) {
        user.setRoles(roleDao.setRole(user.getRoleInd()));
        entityManager.persist(user);
    }

    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
//        User user = entityManager.find(User.class, id);
//        user.setName(sUser.getName());
//        user.setSurname(sUser.getName());
//        user.setAge(sUser.getAge());
//        user.setEmail(sUser.getEmail());
//        user.setRoles(sUser.getRoles());
//        user.setPassword(sUser.getPassword());
//        user.setRoleInd(sUser.getRoleInd());
        user.setRoles(roleDao.setRole(user.getRoleInd()));
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.name = :name", User.class);
        return q.setParameter("name", name).getSingleResult();
    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public boolean isAllowed(Long id, Principal principal) {
        User user = getUserByName(principal.getName());
        return user.getId() == id || user.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().contains("ADMIN"));
    }
}
