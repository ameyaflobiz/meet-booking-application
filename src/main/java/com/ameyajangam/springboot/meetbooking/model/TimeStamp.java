package com.ameyajangam.springboot.meetbooking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class TimeStamp {

    @Id
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    private Booking booking;
}
