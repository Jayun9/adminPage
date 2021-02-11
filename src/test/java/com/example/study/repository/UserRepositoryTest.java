package com.example.study.repository;

import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test

    public void create() {
        User user = new User();
        user.setAccount("TestUser01");
        user.setPassword("Test01!!");
        user.setStatus("REGISTERED");
        user.setEmail("TestUser01.@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedBy("admin");
        user.setCreatedAt(LocalDateTime.now());

        User saveUser = userRepository.save(user);

        assertNotNull(saveUser);
    }

    @Test
    public void read() {
        User findUser = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");

        assertNotNull(findUser);
    }

    @Test
    @Transactional
    public void update() {
        Optional<User> selectUser = userRepository.findById(2L);
        selectUser.ifPresent(user -> {
            user.setAccount("bbbbb");
            user.setUpdatedAt(LocalDateTime.now());
            user.setUpdatedBy("update method()");

            userRepository.save(user);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(5L);

        assertTrue(user.isPresent());

        user.ifPresent(selectUser-> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(5L);

        assertFalse(deleteUser.isPresent());
    }
}
