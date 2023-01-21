package com.ameyajangam.springboot.meetbooking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Booking {
    @Id
    private UUID id;

    private String title;

    @ManyToOne
    private User bookedBy;

    @ManyToMany
    private List<User> participantsList;

    @ManyToOne
    private MeetingRoom meetingRoom;

    @OneToOne
    private TimeStamp timeStamp;

}
