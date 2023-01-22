package com.ameyajangam.springboot.meetbooking.service.implementations;


import com.ameyajangam.springboot.meetbooking.model.User;
import com.ameyajangam.springboot.meetbooking.repository.UserRepository;
import com.ameyajangam.springboot.meetbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public User createUser(String name, String phoneNumber, String email) {

        User user = User.builder().name(name).phoneNumber(phoneNumber).email(email).build();
        repository.save(user);

        return user;
    }

    @Override
    public User findUserByEmail(String email){
        System.out.println("I was here" + email);
        User user = repository.findByEmail(email);
        System.out.println("CHECKKKK" + user.toString());
        return user;
    }
}
