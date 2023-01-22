package com.ameyajangam.springboot.meetbooking.repository;

import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, UUID> {
    public MeetingRoom findByRoomNumber(int roomNumber);
}
