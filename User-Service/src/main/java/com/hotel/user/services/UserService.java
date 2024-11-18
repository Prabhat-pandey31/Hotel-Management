package com.hotel.user.services;

import com.hotel.user.entities.User;
import com.hotel.user.entities.Booking; // Import Booking entity

import java.util.List;

public interface UserService {
    User register(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    String login(String email, String password);
    List<Booking> getUserBookings(Long userId); // Method to get user's bookings
}
