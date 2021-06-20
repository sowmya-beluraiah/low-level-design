package com.ticketcookingsystem.ticketbooksystem.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShowResponseDTO {
	Integer id;
	String movieName;
	Timestamp startTime;
	Double duration;
}
