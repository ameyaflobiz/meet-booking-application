package com.ameyajangam.springboot.meetbooking.dto;

import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingHistoryResponse {

    @JsonProperty("room_code")
    private int roomCode;
    @JsonProperty("bookings")
    private List<Booking> bookings;
}
