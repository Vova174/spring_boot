package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void delete(User user);
    User getId(Long id);
    List<User> findAll();
}
