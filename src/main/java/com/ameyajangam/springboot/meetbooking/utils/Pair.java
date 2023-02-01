package com.ameyajangam.springboot.meetbooking.utils;

import java.time.LocalDateTime;

public class Pair {
    private final LocalDateTime first;
    private final LocalDateTime second;

    public Pair(LocalDateTime first, LocalDateTime second) {
        this.first = first;
        this.second = second;
    }

    public LocalDateTime getFirst() {
        return first;
    }

    public LocalDateTime getSecond() {
        return second;
    }


}
