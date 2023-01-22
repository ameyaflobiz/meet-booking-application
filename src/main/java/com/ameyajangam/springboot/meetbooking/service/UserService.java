package com.ameyajangam.springboot.meetbooking.service;

import com.ameyajangam.springboot.meetbooking.model.User;

import java.util.Optional;

public interface UserService {

    public User createUser(String name,
                           String phoneNumber,
                           String email);

    public User findUserByEmail(String email);
}
