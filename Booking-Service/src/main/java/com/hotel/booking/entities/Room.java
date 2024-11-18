package com.hotel.booking.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;
    private Double roomPrice;
    private String description; // A brief description of the room
}
