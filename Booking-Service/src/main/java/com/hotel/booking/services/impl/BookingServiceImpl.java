package com.hotel.booking.services.impl;

import com.hotel.booking.entities.Booking;
import com.hotel.booking.entities.Room; // For fetching room data if needed
import com.hotel.booking.entities.User; // For fetching user data if needed
import com.hotel.booking.repository.BookingRepository;
import com.hotel.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_URL = "http://localhost:8080/auth/users/";
    private final String ROOM_SERVICE_URL = "http://localhost:8081/rooms/";

    @Override
    public Booking createBooking(Booking booking) {
        // Optionally validate room and user data here if needed
        // Fetch user details from User Service
        User user = restTemplate.getForObject(USER_SERVICE_URL + booking.getUserId(), User.class);
        // Fetch room details from Room Service (if needed)
        Room room = restTemplate.getForObject(ROOM_SERVICE_URL + booking.getRoomId(), Room.class);

        // You can add additional logic here, such as checking room availability

        return bookingRepository.save(booking); // Save booking to the database
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        // This method utilizes the BookingRepository to find bookings by user ID
        return bookingRepository.findByUserId(userId); 
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
