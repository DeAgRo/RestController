package com.bootstrap.bootstrap.dao;

import com.bootstrap.bootstrap.model.Role;

import java.util.List;
import java.util.Set;

/**
 * @author Ali Veliev 09.11.2021
 */

public interface RoleDao {
    List<Role> allRoles();
    Role getRole(Long id);
    Set<Role> setRole(Long index);
}
