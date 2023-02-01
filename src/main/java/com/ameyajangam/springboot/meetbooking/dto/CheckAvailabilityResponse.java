package com.ameyajangam.springboot.meetbooking.dto;

import com.ameyajangam.springboot.meetbooking.utils.Pair;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CheckAvailabilityResponse {
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("slot_suggestions")
    private List<Pair> slotSuggestions;
}
