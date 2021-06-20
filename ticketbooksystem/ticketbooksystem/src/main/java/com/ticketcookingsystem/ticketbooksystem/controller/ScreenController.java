package com.ticketcookingsystem.ticketbooksystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.dto.ScreenResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.service.ScreenService;

@RestController
@RequestMapping("path=/screen")
public class ScreenController {
	@Autowired
	ScreenService screenService;
	
	@GetMapping("path=/list")
	public ResponseEntity<List<ScreenResponseDTO>> listAllScreens(@RequestParam Integer theatreid) {
		List<ScreenResponseDTO> response = new ArrayList<>();
		response = screenService.listAllScreens(theatreid);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	

}
