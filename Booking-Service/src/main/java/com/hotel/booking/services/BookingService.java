package com.hotel.booking.services;





import com.hotel.booking.entities.Booking;
import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getBookingsByUserId(Long userId);
    void deleteBooking(Long bookingId);
}


