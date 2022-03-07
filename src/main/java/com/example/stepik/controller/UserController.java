package com.example.stepik.controller;

import com.example.stepik.model.User;
import com.example.stepik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    private UserController (UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/users")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @GetMapping("/users")
    public Iterable<User> getAll () {
        return userService.getUserAll();
    }
    @GetMapping("/users/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
