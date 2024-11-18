package com.hotel.room.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.room.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

