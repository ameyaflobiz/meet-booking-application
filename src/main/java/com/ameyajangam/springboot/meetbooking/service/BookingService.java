package com.ameyajangam.springboot.meetbooking.service;

import com.ameyajangam.springboot.meetbooking.dto.CheckAvailabilityResponse;
import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    public List<Booking> viewBookings();

    public Booking bookMeeting(String title, LocalDateTime startTime, LocalDateTime endTime, MeetingRoom room,
                               User user, List<String>participantsList);

    public CheckAvailabilityResponse checkAvailability(MeetingRoom room, LocalDateTime startTime, LocalDateTime endTime);

}
