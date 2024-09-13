package com.hampcode.service.impl;

import com.hampcode.model.entity.User;
import com.hampcode.repository.UserRepository;
import com.hampcode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Transactional
    @Override
    public User create(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(Integer id, User user) {
        User us = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        us.setName(user.getName());
        us.setUsername(user.getUsername());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            us.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        us.setEmail(user.getEmail());
        us.setHeight(user.getHeight());
        us.setWeight(user.getWeight());
        us.setAge(user.getAge());
        us.setAllergies(user.getAllergies());
        us.setGoal(user.getGoal());
        us.setDietType(user.getDietType());
        return userRepository.save(us);
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        User user = findByUsername(username);
        return passwordEncoder.matches(password, user.getPassword());
    }
}