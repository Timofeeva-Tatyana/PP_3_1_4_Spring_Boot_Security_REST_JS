package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.dao.RoleDao;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.dao.UserDao;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        if (user.getRoles().size() == 0){
            user.addRole(roleDao.findRoleByName("USER"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User updatedUser) {
        if (updatedUser.getRoles().size() == 0) {
            updatedUser.addRole(roleDao.findRoleByName("USER"));
        }
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userDao.updateUser(updatedUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByUserName(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
