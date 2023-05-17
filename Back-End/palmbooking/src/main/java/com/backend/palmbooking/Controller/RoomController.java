package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Room;
import com.backend.palmbooking.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public Optional<Room> getRoomByID(@PathVariable Long id){
        return roomService.getRoomByID(id);
    }

    @PostMapping
    public void addRoom(@RequestBody Room room){
        roomService.addRoom(room);
    }

    @PutMapping
    public ResponseEntity<Void> editRoom(@RequestBody Room room) {
        Optional<Room> searchRoom = roomService.getRoomByID(room.getId());

        if (searchRoom.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        roomService.editRoom(room);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomByID(@PathVariable Long id) {
        Optional<Room> searchRoom = roomService.getRoomByID(id);

        if (searchRoom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        roomService.deleteRoomByID(id);
        return ResponseEntity.status(204).build();
    }
}
