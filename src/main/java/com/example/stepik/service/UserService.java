package com.example.stepik.service;

import com.example.stepik.model.User;
import com.example.stepik.repository.UserRepository;
import org.springframework.stereotype.Component;

public interface UserService {
    public String saveUser(User user);
    public Iterable<User> getUserAll();
    public User getCurrentUser();
}
