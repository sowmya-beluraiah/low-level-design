package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.dto.ScreenResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.meta.Screen;
import com.ticketcookingsystem.ticketbooksystem.repository.ScreenRepository;

@Service
public class ScreenService {
	@Autowired
	ScreenRepository screenRepo;
	
	public List<ScreenResponseDTO> listAllScreens(Integer theatreid){
		List<Screen> temp = screenRepo.findByTheatreId(theatreid);
		List<ScreenResponseDTO> resposeDTO = new ArrayList<>();
		
		for(Screen s : temp) {
			resposeDTO.add(new ScreenResponseDTO(s.getId()));
		}
		
		return resposeDTO;
	}
}
