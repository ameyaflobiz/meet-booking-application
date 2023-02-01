package com.ameyajangam.springboot.meetbooking.controller;

import com.ameyajangam.springboot.meetbooking.dto.BookingRequest;
import com.ameyajangam.springboot.meetbooking.dto.CheckAvailabilityRequest;
import com.ameyajangam.springboot.meetbooking.dto.CheckAvailabilityResponse;
import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.model.User;
import com.ameyajangam.springboot.meetbooking.service.BookingService;
import com.ameyajangam.springboot.meetbooking.service.MeetingRoomService;
import com.ameyajangam.springboot.meetbooking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BookingsController {


    // creating a logger
    private static final Logger logger = LoggerFactory.getLogger(BookingsController.class);

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private MeetingRoomService meetingRoomService;

    @GetMapping("/bookings")
    @ResponseBody
    public List<Booking> viewBookings(){
        logger.info("VIEWING BOOKINGS...");
        List<Booking> bookings = bookingService.viewBookings();

        return bookings;

    };

    @PostMapping("/bookings/book")
    @ResponseBody
    public Booking bookMeeting(@RequestBody BookingRequest bookingRequest){

        System.out.println(bookingRequest.toString());
          User user = userService.findUserByEmail(bookingRequest.getBookerEmail());
          MeetingRoom room = meetingRoomService.findMeetingRoomByRoomNumber(bookingRequest.getRoomCode());

          Booking booking = bookingService.bookMeeting(
                                    bookingRequest.getTitle(),
                                    bookingRequest.getStartTime(),
                                    bookingRequest.getEndTime(),
                                    room,
                                    user,
                                    bookingRequest.getParticipantsList()
                                  );

          return booking;
    };

    @GetMapping("/bookings/check_availability")
    public ResponseEntity<CheckAvailabilityResponse> checkAvailability(@RequestBody CheckAvailabilityRequest checkAvailabilityRequest){
        MeetingRoom room = meetingRoomService.findMeetingRoomByRoomNumber(checkAvailabilityRequest.getRoomNumber());
//        System.out.println("woww" + room.toString());
        CheckAvailabilityResponse response = bookingService.checkAvailability(room,
                                         checkAvailabilityRequest.getStartTime(),
                                         checkAvailabilityRequest.getEndTime());

        System.out.println(response.toString());

        return new ResponseEntity<CheckAvailabilityResponse>(response, HttpStatus.OK);
    }

}
