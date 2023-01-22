package com.ameyajangam.springboot.meetbooking.service.implementations;

import com.ameyajangam.springboot.meetbooking.constant.RoomType;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.repository.MeetingRoomRepository;
import com.ameyajangam.springboot.meetbooking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    private MeetingRoomRepository repository;

    @Override
    public MeetingRoom createMeetingRoom(int roomNumber, int roomCapacity, RoomType roomType) {
        MeetingRoom room = MeetingRoom.builder().roomNumber(roomNumber).roomCapacity(roomCapacity).roomType(roomType).build();
        repository.save(room);
        return room;
    }

    @Override
    public MeetingRoom findMeetingRoomByRoomNumber(int roomNumber) {
        MeetingRoom room = repository.findByRoomNumber(roomNumber);
        return room;
    }

}
