package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalExcepction;
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

    public Room getRoomByID(Long id) throws GlobalExcepction {
        Optional<Room> searchRoom = roomRepository.findById(id);
        if (searchRoom.isPresent()){
            return searchRoom.get();
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public Room editRoom(Room room) throws GlobalExcepction {
        Optional<Room> editRoom = roomRepository.findById(room.getId());
        if (editRoom.isPresent()) {
            return roomRepository.save(room);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }

    }

    public void deleteRoomByID(Long id) throws GlobalExcepction {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            roomRepository.deleteById(id);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }
}
