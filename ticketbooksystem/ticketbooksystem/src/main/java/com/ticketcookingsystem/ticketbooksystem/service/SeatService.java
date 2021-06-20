package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.meta.Seat;
import com.ticketcookingsystem.ticketbooksystem.repository.SeatRepository;

@Service
public class SeatService {
	@Autowired
	SeatRepository seatRepo;
	
	public Boolean checkSeats(Integer showId, Integer from, Integer to){
		List<String> status = seatRepo.findSeatStatus(showId, from, to);
		
		for(String s : status) {
			if(!s.equals("AVAILABLE")) {
				return false;
			}
		}
		return true;
	}
	
	public List<Seat> getSeatDetails(List<Integer> seatIds) {
		return seatRepo.findByIdList(seatIds);
	}
	
	public List<Integer> showAvailableSeats(Integer showId){
		return seatRepo.findAvailableSeats(showId);
	}
	
	public void lockSeatsinDB(Integer from, Integer to) {
		seatRepo.lockSeatsinDB(from, to);
	}
	
	public void releaseSeatsinDB(List<Integer> seats) {
		seatRepo.releaseSeatsinDB(seats);
	}	
	
	public void bookSeatsinDB(List<Integer> seats) {
		seatRepo.bookSeatsinDB(seats);
	}
}
