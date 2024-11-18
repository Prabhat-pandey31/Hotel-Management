package com.hotel.room.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.room.entities.Room;
import com.hotel.room.repository.RoomRepository;
import com.hotel.room.services.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room findRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Room existingRoom = findRoomById(roomId);
        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setRoomPrice(room.getRoomPrice());
        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}

