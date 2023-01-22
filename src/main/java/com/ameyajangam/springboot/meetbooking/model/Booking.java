package com.ameyajangam.springboot.meetbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String title;

    @ManyToOne
    private User bookedBy;

    @ManyToMany
    private List<User> participantsList;

    @JsonBackReference
    @ManyToOne
    private MeetingRoom meetingRoom;

    @OneToOne(cascade = CascadeType.ALL)
    private TimeStamp timeStamp;

}
