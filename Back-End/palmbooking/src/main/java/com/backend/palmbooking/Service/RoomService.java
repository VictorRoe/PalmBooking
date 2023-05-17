package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Room;
import com.backend.palmbooking.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoom() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomByID(Long id) {
        return roomRepository.findById(id);
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public Room editRoom(Room room) {
        Optional<Room> editRoom = roomRepository.findById(room.getId());

        if (editRoom.isPresent()) {
            return roomRepository.save(room);
        } else {
            System.out.println("No se encontro el producto");
        }
        return room;
    }

    public void deleteRoomByID(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            roomRepository.deleteById(id);
        }
    }
}
