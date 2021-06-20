package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.dto.TheatreResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.meta.Theatre;
import com.ticketcookingsystem.ticketbooksystem.repository.TheatreRepository;

@Service
public class TheatreService {
	@Autowired
	TheatreRepository theatreRepo;
	
	public List<TheatreResponseDTO> listAllTheatres(){
		List<Theatre> temp = theatreRepo.findAll();
		List<TheatreResponseDTO> resposeDTO = new ArrayList<>();
		
		for(Theatre t : temp) {
			resposeDTO.add(new TheatreResponseDTO(t.getId(), t.getTheatreName()));
		}
		
		return resposeDTO;
	}
}
