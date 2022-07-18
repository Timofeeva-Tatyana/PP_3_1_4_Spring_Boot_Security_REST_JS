package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service;

import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User findUserById(long id);

    void updateUser(User user);

    void deleteUser(long id);
}
