package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.dao;

import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    void saveRole(Role role);

    Role findRoleById(Long id);

    Role findRoleByName(String name);
}
