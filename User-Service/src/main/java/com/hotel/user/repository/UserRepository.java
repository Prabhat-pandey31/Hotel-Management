package com.hotel.user.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.user.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

