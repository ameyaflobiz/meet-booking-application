package com.ameyajangam.springboot.meetbooking.service;

import com.ameyajangam.springboot.meetbooking.constant.RoomType;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;

public interface MeetingRoomService {

    public MeetingRoom createMeetingRoom(int roomNumber, int roomCapacity, RoomType roomType);
    public MeetingRoom findMeetingRoomByRoomNumber(int roomNumber);
}
