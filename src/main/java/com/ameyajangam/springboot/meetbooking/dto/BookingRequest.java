package com.ameyajangam.springboot.meetbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class BookingRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime endTime;

    @JsonProperty("room_code")
    private int roomCode;

    @JsonProperty("booker_email")
    private String bookerEmail;

    @JsonProperty("participants_list")
    private List<String> participantsList;



}
