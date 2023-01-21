package com.ameyajangam.springboot.meetbooking.model;

import com.ameyajangam.springboot.meetbooking.constant.RoomType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Data
@Entity
public class MeetingRoom {

    @Id
    private UUID id;

    @Column(name = "room_number")
    @JsonProperty(value = "room_number")
    private int roomNumber;

    @Column(name = "room_capacity")
    @JsonProperty(value = "room_capacity")
    private int roomCapacity;

    @Column(name = "room_type")
    @JsonProperty(value = "room_type")
    private RoomType roomType;

    @OneToOne
    private TimeStamp timeStamp;

    @OneToMany(mappedBy = "meetingRoom")
    private List<Booking> bookings;
}
