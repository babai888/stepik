package com.example.stepik.service;

import com.example.stepik.model.User;

public interface UserService {
    public User saveUser(User user);
    public Iterable<User> getUserAll();
    public User getCurrentUser();
    public User getUserByLogin(String login);
}
