package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.dao.RoleDao;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }
}
