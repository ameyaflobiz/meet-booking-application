package com.ameyajangam.springboot.meetbooking.repository;

import com.ameyajangam.springboot.meetbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

}
