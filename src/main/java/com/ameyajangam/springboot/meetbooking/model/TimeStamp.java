package com.ameyajangam.springboot.meetbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeStamp {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    private Booking booking;
}
