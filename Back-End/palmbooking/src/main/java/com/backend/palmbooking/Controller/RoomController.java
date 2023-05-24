package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalException;
import com.backend.palmbooking.Model.Room;
import com.backend.palmbooking.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @GetMapping
    public List<Room> getRoom() {
        return roomService.getRoom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomByID(@PathVariable Long id) throws GlobalException {
        Room room = roomService.getRoomByID(id);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(room);
        }
    }

    @PostMapping
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @PutMapping
    public ResponseEntity<Room> editRoom(@RequestBody Room room) throws GlobalException {
        Room searchRoom = roomService.getRoomByID(room.getId());
        if (searchRoom == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(roomService.editRoom(room));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomByID(@PathVariable Long id) throws GlobalException {
        Room searchRoom = roomService.getRoomByID(id);
        if (searchRoom == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        roomService.deleteRoomByID(id);
        return ResponseEntity.noContent().build();
    }
}
