package com.hotel.booking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hotel.booking.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId); // To get bookings for a user
}


