package com.ticketcookingsystem.ticketbooksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketcookingsystem.ticketbooksystem.service.ShowService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	ShowService showService;

}
