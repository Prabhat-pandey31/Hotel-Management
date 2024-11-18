package com.hotel.booking.entities;

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

    private Long userId; // Reference to the User who made the booking
    private Long roomId; // Reference to the Room booked

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
