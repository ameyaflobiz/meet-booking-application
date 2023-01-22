package com.ameyajangam.springboot.meetbooking.controller;

import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;
    @GetMapping("/meeting_rooms/meeting_history")
    public void getMeetingHistory(){

    }

    @PostMapping("/meeting_rooms/create")
    public MeetingRoom createRoom(@RequestBody MeetingRoom room) {
     MeetingRoom meetRoom = meetingRoomService.createMeetingRoom(room.getRoomNumber(), room.getRoomCapacity(), room.getRoomType());
     return meetRoom;
    }

}
