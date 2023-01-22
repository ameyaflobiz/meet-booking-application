package com.ameyajangam.springboot.meetbooking.service.implementations;


import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.model.TimeStamp;
import com.ameyajangam.springboot.meetbooking.model.User;
import com.ameyajangam.springboot.meetbooking.repository.BookingRepository;
import com.ameyajangam.springboot.meetbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Override
    public List<Booking> viewBookings() {
        List<Booking> bookings = repository.findAll();
        return bookings;
    }

    @Override
    public Booking bookMeeting(String title, LocalDateTime startTime, LocalDateTime endTime, MeetingRoom room, User user, List<String> participantsList) {
        TimeStamp timeStamp = TimeStamp.builder().startTime(startTime).endTime(endTime).build();
        List<User> userList = new ArrayList<>();
        Booking booking = Booking.builder().title(title).bookedBy(user).meetingRoom(room).timeStamp(timeStamp).participantsList(userList).build();
        repository.save(booking);

        return booking;
    }

    @Override
    public String checkAvailability(int meetingRoomNumber, LocalDate startTime) {
        return null;
    }
}
