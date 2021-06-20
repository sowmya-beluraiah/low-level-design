package com.ticketcookingsystem.ticketbooksystem.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.service.SeatService;
import com.ticketcookingsystem.ticketbooksystem.utils.BookingSession;
import com.ticketcookingsystem.ticketbooksystem.utils.SeatUtil;

@RestController
@RequestMapping("path=/seat")
public class SeatController {
	@Autowired
	SeatService seatService;
	
	@GetMapping("path=/selectSeats/{userId}/{showId}")
	@ResponseBody
	public String selectSeats(@PathVariable Integer showId,
				@PathVariable Integer userId,
				@RequestParam Integer from,
				@RequestParam Integer to) {
		
		BookingSession.startSession(userId, new Timestamp(System.currentTimeMillis()));
		
		if(seatService.checkSeats(showId, from, to) &&
			SeatUtil.lockSeats(showId, userId, from, to)) {
			seatService.lockSeatsinDB(from,to);
			return "Seats Locked";
		} else {
			//TODO Exception
			return "Seats not available";
		}
	}

}
