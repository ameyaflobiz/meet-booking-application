package com.ameyajangam.springboot.meetbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    @JsonProperty(value = "name")
    private String name;

    @Column(name = "phone_number")
    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @JsonProperty(value = "email")
    private String email;

    @ManyToMany
    private List<Booking> bookings;
}
