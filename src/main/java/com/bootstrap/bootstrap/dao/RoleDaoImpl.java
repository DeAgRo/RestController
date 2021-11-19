package com.bootstrap.bootstrap.dao;

import com.bootstrap.bootstrap.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ali Veliev 09.11.2021
 */

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Set<Role> setRole(Long index) {
        Set<Role> rolesSet = new HashSet<>();
        if (index == 1) {
            rolesSet.add(getRole((long)1));
        } else if (index == 2) {
            rolesSet.add(getRole((long)2));
        } else if (index == 3) {
            rolesSet.add(getRole((long)1));
            rolesSet.add(getRole((long)2));
        }
        return rolesSet;
    }
}
