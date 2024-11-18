package com.hotel.user.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Reference to the User ID
    private Long roomId; // Reference to the Room ID (if applicable)

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
