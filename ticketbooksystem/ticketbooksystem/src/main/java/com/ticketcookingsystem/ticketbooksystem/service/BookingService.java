package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.dto.BookingResponseDTO;
import com.ticketcookingsystem.ticketbooksystem.meta.Booking;
import com.ticketcookingsystem.ticketbooksystem.meta.Seat;
import com.ticketcookingsystem.ticketbooksystem.meta.Show;
import com.ticketcookingsystem.ticketbooksystem.repository.BookingRepository;
import com.ticketcookingsystem.ticketbooksystem.repository.PaymentRepository;
import com.ticketcookingsystem.ticketbooksystem.repository.ShowRepository;
import com.ticketcookingsystem.ticketbooksystem.repository.UserRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	ShowRepository showRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ShowService showService;
	
	public Integer saveBooking(Integer userId, Integer showId, Integer paymentId, List<Seat> seats){
		Booking booking = new Booking();
		Show show = showRepo.getById(showId);
		
		booking.setTheatre(show.getTheatreshow());
		booking.setScreen(show.getScreen());
		booking.setShow(show);
		booking.setUser(userRepo.getById(userId));
		booking.setPayment(paymentRepo.getById(paymentId));
		booking.setSeats_booked(seats);

		booking = bookingRepo.save(booking);
		return booking.getId();
	}
	
	public List<BookingResponseDTO> getDetails(Integer userId) {
		List<BookingResponseDTO> result = new ArrayList<>();
		List<Booking> response = bookingRepo.findByUserId(userId);
		for(Booking b : response) {
			BookingResponseDTO dto = new BookingResponseDTO();
			dto.setId(b.getId());
			dto.setTheatreName(b.getTheatre().getTheatreName());
			dto.setScreenId(b.getScreen().getId());
			dto.setMovieName(b.getShow().getMovieName());
			dto.setStartTime(b.getShow().getStartTime());
			dto.setDuration(b.getShow().getDuration());
			//dto.setPaymentStatus(b.getPayment().getStatus());
			List<Integer> seatsResp = new ArrayList<>();
			for(Seat s : b.getSeats_booked()) {
				seatsResp.add(s.getId());
			}
			dto.setSeats(seatsResp);
			
			result.add(dto);			
		}
		
		return result;
	}
}
