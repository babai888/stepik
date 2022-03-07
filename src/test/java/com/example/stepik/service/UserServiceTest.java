package com.example.stepik.service;

import com.example.stepik.model.User;
import com.example.stepik.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUser_Exists() {
        User admin = userService.getUserByLogin("admin");
        assertThat(admin).isNotNull();
        assertThat(admin.getLogin()).isEqualTo("admin");
    }
    @Test
    public void getUser_NotExists() {
        User alex = userService.getUserByLogin("alex");
        assertThat(alex).isNull();
    }
}
