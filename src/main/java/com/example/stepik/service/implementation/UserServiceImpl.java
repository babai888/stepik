package com.example.stepik.service.implementation;

import com.example.stepik.model.User;
import com.example.stepik.repository.UserRepository;
import com.example.stepik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public String saveUser(User user) {
        System.out.println(userRepository.isUser(user.getLogin()));
        if(userRepository.isUser(user.getLogin()).isEmpty()) {
            userRepository.save(user);
            return "OK";
        }
        return "user " + user.getLogin() + " exists";
    }

    @Override
    public Iterable<User> getUserAll() {
        return userRepository.findAll();
    }
}
