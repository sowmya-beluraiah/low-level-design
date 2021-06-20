package com.ticketcookingsystem.ticketbooksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketcookingsystem.ticketbooksystem.meta.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	@Query(value="select id from Seat s where s.show.id = :showId and status='AVAILABLE'")
	public List<Integer> findAvailableSeats(Integer showId);
	
	@Query(value="select status from Seat s where s.show.id = :showId and s.id>= :from and s.id <= :to")
	public List<String> findSeatStatus(Integer showId, Integer from, Integer to);
	
	@Query(value="update Seat s set s.status='TEMPORARILY_UNAVAILABLE' where s.id >= :from and s.id <= :to")
	public void lockSeatsinDB(Integer from, Integer to);
	
	@Query(value="update Seat s set s.status='AVAILABLE' where s.id in :seats")
	public void releaseSeatsinDB(List<Integer> seats);
	
	@Query(value="update Seat s set s.status='UNAVAILABLE' where s.id in :seats")
	public void bookSeatsinDB(List<Integer> seats);
	
	@Query(value="select s from Seat s where s.id in :seats")
	public List<Seat> findByIdList(List<Integer> seats);
}
