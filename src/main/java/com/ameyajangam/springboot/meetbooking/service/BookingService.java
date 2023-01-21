package com.ameyajangam.springboot.meetbooking.service;

import com.ameyajangam.springboot.meetbooking.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public List<Booking> viewBookings();

    public void bookMeeting(LocalDate startTime, LocalDate endTime, int roomCode,
                            String bookerEmail, List<String>participantsList);

    public String checkAvailability(int meetingRoomNumber, LocalDate startTime);

}
