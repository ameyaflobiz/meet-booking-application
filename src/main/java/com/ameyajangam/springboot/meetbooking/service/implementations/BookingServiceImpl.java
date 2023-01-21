package com.ameyajangam.springboot.meetbooking.service.implementations;


import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public List<Booking> viewBookings() {
        List<Booking> bookings = new ArrayList<>();
        return bookings;
    }

    @Override
    public void bookMeeting(LocalDate startTime, LocalDate endTime, int roomCode, String bookerEmail, List<String> participantsList) {

    }

    @Override
    public String checkAvailability(int meetingRoomNumber, LocalDate startTime) {
        return null;
    }
}
