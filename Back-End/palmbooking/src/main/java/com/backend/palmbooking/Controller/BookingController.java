package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Booking;
import com.backend.palmbooking.Repository.BookingRepository;
import com.backend.palmbooking.Service.BookingService;
import com.backend.palmbooking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private ProductService productService;

    @PostMapping("product/{product_id}")
    public Booking createBooking(@PathVariable("product_id") Long productID,
                                 @RequestBody Booking booking){
        return bookingService.addreservation(productID,booking);
    }

    @GetMapping
    public List<Booking> getReservation(){
        return bookingService.getAllReservation();
    }
}
