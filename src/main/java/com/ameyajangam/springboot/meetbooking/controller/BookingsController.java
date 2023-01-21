package com.ameyajangam.springboot.meetbooking.controller;

import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingsController {


    // creating a logger
    private static final Logger logger = LoggerFactory.getLogger(BookingsController.class);

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    @ResponseBody
    public List<Booking> viewBookings(){
        logger.info("VIEWING BOOKINGS...");
        List<Booking> bookings = bookingService.viewBookings();

        return bookings;

    };

    @PostMapping("/bookings/book")
    public void bookMeeting(){

    };

    @GetMapping("/bookings/check_availability")
    public void checkAvailability(){

    }

}
