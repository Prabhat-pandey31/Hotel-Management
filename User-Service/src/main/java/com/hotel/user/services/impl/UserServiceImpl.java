package com.hotel.user.services.impl;

import com.hotel.user.entities.User;
import com.hotel.user.entities.Booking; // Import Booking entity
import com.hotel.user.repository.UserRepository;
import com.hotel.user.repository.BookingRepository; // If you're directly querying bookings
import com.hotel.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; // For calling Booking Service

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate; // To call Booking Service

    // If you're directly using bookings from your own repository
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful for user: " + user.getEmail();
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        // Define your booking service URL
        String bookingServiceUrl = "http://booking-service/bookings/user/" + userId;
        // Fetch bookings for the user
        Booking[] bookings = restTemplate.getForObject(bookingServiceUrl, Booking[].class);
        return List.of(bookings);
    }
}
