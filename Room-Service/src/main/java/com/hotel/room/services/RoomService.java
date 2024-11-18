package com.hotel.room.services;



import java.util.List;

import com.hotel.room.entities.Room;

public interface RoomService {
    Room createRoom(Room room);
    Room findRoomById(Long roomId);
    List<Room> getAllRooms();
    Room updateRoom(Long roomId, Room room);
    void deleteRoom(Long roomId);
}

