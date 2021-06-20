package com.ticketcookingsystem.ticketbooksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.service.PaymentService;
import com.ticketcookingsystem.ticketbooksystem.utils.BookingSession;

@RestController
@RequestMapping("path=/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("path=/totalAmount")
	@ResponseBody
	public Integer totalAmount(@RequestParam Integer userId,
				@RequestParam Integer showId) {
		if(BookingSession.isSessionExpired(userId)) {
			//TODO exception session expired
			return 0;
		}
		return 650;
	}
	
	@GetMapping("path=/doPayment")
	@ResponseBody
	public String doPayment(@RequestParam Integer userId,
				@RequestParam Integer showId) {
		if(BookingSession.isSessionExpired(userId)) {
			//TODO exception session expired
			return "Session expired";
		}
		
		if(paymentService.doPayment(userId, showId)) {
			return "Payment Successful, Show Booked";
		} else {
			//TODO Exception
			return "Payment failed";
		}
	}
	
}
