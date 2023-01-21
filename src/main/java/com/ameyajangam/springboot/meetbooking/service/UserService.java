package com.ameyajangam.springboot.meetbooking.service;

import com.ameyajangam.springboot.meetbooking.model.User;

public interface UserService {

    public User createUser(String name,
                           String phoneNumber,
                           String email);
}
