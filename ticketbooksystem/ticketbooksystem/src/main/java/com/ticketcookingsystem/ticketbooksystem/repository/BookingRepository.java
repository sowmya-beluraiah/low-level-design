package com.ticketcookingsystem.ticketbooksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketcookingsystem.ticketbooksystem.meta.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	@Query(value="select b from Booking b where b.user.id = :userId")
	public List<Booking> findByUserId(Integer userId);
}
