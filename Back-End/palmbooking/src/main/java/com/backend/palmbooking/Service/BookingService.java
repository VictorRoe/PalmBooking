package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Booking;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ProductService productService;

    public Booking addreservation(Long productID, Booking booking){
        Product product = productService.getProductByID(productID);
        booking.setProduct(product);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllReservation(){
        return bookingRepository.findAll();
    }

}
