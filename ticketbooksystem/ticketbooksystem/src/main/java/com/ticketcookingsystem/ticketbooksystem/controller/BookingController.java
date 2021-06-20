package com.ticketcookingsystem.ticketbooksystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.dto.BookingResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.service.BookingService;

@RestController
@RequestMapping("path=/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping("path=/getDetails")
	public ResponseEntity<List<BookingResponseDTO>> getDetails(@RequestParam Integer userId) {
		List<BookingResponseDTO> response = bookingService.getDetails(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
