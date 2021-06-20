package com.ticketcookingsystem.ticketbooksystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketcookingsystem.ticketbooksystem.meta.User;
import com.ticketcookingsystem.ticketbooksystem.repository.BookingRepository;
import com.ticketcookingsystem.ticketbooksystem.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookingRepository bookingRepo;

	public void saveUserBooking(Integer userId, Integer bookingId){
		User user = new User();
		user.setId(userId);
		user.setBooking(bookingRepo.getById(bookingId));
		userRepo.save(user);
	}
	
}
