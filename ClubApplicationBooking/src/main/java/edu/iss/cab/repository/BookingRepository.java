package edu.iss.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

}
