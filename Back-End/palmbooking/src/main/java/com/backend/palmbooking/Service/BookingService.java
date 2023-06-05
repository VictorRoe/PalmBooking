package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Booking;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Model.Room;
import com.backend.palmbooking.Repository.BookingRepository;
import com.backend.palmbooking.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    public Booking addreservation(Long productID, Long roomID, Booking booking){
        Product product = productService.getProductByID(productID);
        Room room = roomService.getRoomByID(roomID);
        Integer roomAvailable = room.getRoomQuantity();
        if (roomAvailable <= 0 ){
            throw new RuntimeException("Room not available");
        }

        room.setRoomQuantity(roomAvailable - 1);
        roomRepository.save(room);

        booking.setProduct(product);
        booking.setRoom(room);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllReservation(){
        return bookingRepository.findAll();
    }

}
