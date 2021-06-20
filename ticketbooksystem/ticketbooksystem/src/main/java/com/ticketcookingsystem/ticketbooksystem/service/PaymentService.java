package com.ticketcookingsystem.ticketbooksystem.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.meta.Payment;
import com.ticketcookingsystem.ticketbooksystem.meta.Seat;
import com.ticketcookingsystem.ticketbooksystem.repository.PaymentRepository;
import com.ticketcookingsystem.ticketbooksystem.utils.BookingSession;
import com.ticketcookingsystem.ticketbooksystem.utils.SeatUtil;
import com.ticketcookingsystem.ticketbooksystem.utils.TBSConstants;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SeatService seatService;
	
	public Boolean doPayment(Integer userId, Integer showId){
		Random rd = new Random();
		boolean status = rd.nextBoolean();
		Boolean response = false;
		List<Integer> lockedSeats = SeatUtil.getLockedSeats(showId, userId);
		
		for(int retry=0; retry<= TBSConstants.paymentRetryCount; retry++) {
			if(BookingSession.isSessionExpired(userId)) {
				//TODO exception session expired
				SeatUtil.releaseLockedSeats(showId, userId);
				return false;
			}
			
			if(status) {
				Integer paymentId = savePayment();
				Integer bookingId = bookingService.saveBooking(userId, showId, paymentId, seatService.getSeatDetails(lockedSeats));
				userService.saveUserBooking(userId, bookingId);
				
				seatService.bookSeatsinDB(lockedSeats);
				response = true;
				break;
			} else {
				status = rd.nextBoolean();
			}
		}
		
		//Release Seats
		SeatUtil.releaseLockedSeats(showId, userId);
		
		if(!response) {
			seatService.releaseSeatsinDB(lockedSeats);
		}
		
		return response;
	}
	
	private Integer savePayment() {
		Payment payment = new Payment();
		payment.setAmount(650);
		payment.setStatus(true);
		payment = paymentRepo.save(payment);
		return payment.getId();
	}
}
