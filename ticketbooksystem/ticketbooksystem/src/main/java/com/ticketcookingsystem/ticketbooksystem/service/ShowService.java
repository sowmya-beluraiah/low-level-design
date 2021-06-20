package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.dto.ShowResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.meta.Seat;
import com.ticketcookingsystem.ticketbooksystem.meta.Show;
import com.ticketcookingsystem.ticketbooksystem.repository.SeatRepository;
import com.ticketcookingsystem.ticketbooksystem.repository.ShowRepository;
import com.ticketcookingsystem.ticketbooksystem.utils.SeatUtil;

@Service
public class ShowService {
	@Autowired
	ShowRepository showRepo;
	
	@Autowired
	SeatRepository seatRepo;
	
	public List<ShowResponseDTO> listAllShows(Integer screenId){
		List<Show> temp = showRepo.findByScreenId(screenId);
		List<ShowResponseDTO> resposeDTO = new ArrayList<>();
		
		for(Show s : temp) {
			//s.getScreen().getTheatre().getTheatreName();
			resposeDTO.add(new ShowResponseDTO(s.getId(), s.getMovieName(), s.getStartTime(), s.getDuration()));
		}
		
		return resposeDTO;
	}
	
	public List<Integer> showAvailableSeats(Integer showId){
		return seatRepo.findAvailableSeats(showId);
	}
	
}
