package com.ameyajangam.springboot.meetbooking.controller;

import com.ameyajangam.springboot.meetbooking.dto.MeetingHistoryResponse;
import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;
    @GetMapping("/meeting_rooms/meeting_history/{roomCode}")
    public MeetingHistoryResponse getMeetingHistory(@PathVariable int roomCode){
        System.out.println(roomCode);
        MeetingRoom meetRoom = meetingRoomService.findMeetingRoomByRoomNumber(roomCode);
        List<Booking> meetings = meetRoom.getBookings();

        MeetingHistoryResponse response = MeetingHistoryResponse.builder().roomCode(roomCode).bookings(meetings).build();
        return response;
    }

    @PostMapping("/meeting_rooms/create")
    public MeetingRoom createRoom(@RequestBody MeetingRoom room) {
     MeetingRoom meetRoom = meetingRoomService.createMeetingRoom(room.getRoomNumber(), room.getRoomCapacity(), room.getRoomType());
     return meetRoom;
    }

}
