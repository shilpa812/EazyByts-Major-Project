package com.fitness.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Repository.BookingRepository;
import com.fitness.entity.Booking;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    // Add this method
    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }

    // Alternatively, if you want to delete by ID, add this method:
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }
}
