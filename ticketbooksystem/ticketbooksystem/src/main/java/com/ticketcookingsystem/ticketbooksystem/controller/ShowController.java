package com.ticketcookingsystem.ticketbooksystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.dto.ShowResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.service.ShowService;

@RestController
@RequestMapping("path=/show")
public class ShowController {
	@Autowired
	ShowService showService;
	
	@GetMapping("path=/list")
	public ResponseEntity<List<ShowResponseDTO>> listAllShows(@RequestParam Integer screenId) {
		List<ShowResponseDTO> response = new ArrayList<>();
		response = showService.listAllShows(screenId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("path=/{showId}/showAvailableSeats")
	@ResponseBody
	public List<Integer> showAvailableSeats(@PathVariable Integer showId) {
		List<Integer> response = new ArrayList<>();
		response = showService.showAvailableSeats(showId);
		return response;
	}
}
