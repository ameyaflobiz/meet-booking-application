package com.ameyajangam.springboot.meetbooking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MeetingRoomController {

    @GetMapping("/meeting_rooms/meeting_history")
    public void getMeetingHistory(){

    }
}
