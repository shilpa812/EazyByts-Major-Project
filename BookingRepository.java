package com.fitness.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

