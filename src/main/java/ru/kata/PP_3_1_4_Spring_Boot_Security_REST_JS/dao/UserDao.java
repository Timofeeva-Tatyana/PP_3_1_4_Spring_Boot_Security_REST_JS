package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.dao;

import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    User findUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
    User findByUserName(String email);
}
