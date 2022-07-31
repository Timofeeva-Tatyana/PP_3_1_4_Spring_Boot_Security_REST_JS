package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.service.UserService;

@RestController
@RequestMapping("/principalUser")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getPrincipalUser() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }
}
