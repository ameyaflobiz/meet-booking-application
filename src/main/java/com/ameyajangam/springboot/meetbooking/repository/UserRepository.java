package com.ameyajangam.springboot.meetbooking.repository;

import com.ameyajangam.springboot.meetbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
