package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.exception_handling.NoSuchUserException;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.Role;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service.RoleService;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public List <User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/roles")
    public List <Role> getAllRoles() {
        return roleService.getAllRoles();
    }

//    @GetMapping("/user")
//    public User getPrincipalUser() {
//        User thisUser = (User) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
//        return thisUser;
//    }

    @GetMapping("/admin/{id}")
    public User getUsers(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with ID = " +
                    id + " in Database");
        }
        return user;
    }

    @PostMapping("/admin")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/admin")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with ID = " +
                    id + " in Database");
        }
        userService.deleteUser(id);
        return "User with ID " + id + " was deleted.";
    }

}
