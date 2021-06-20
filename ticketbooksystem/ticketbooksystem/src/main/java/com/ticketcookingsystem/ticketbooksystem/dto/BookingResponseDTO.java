package com.ticketcookingsystem.ticketbooksystem.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingResponseDTO {
	int id;
	String theatreName;
	int screenId;
	String movieName;
	Timestamp startTime;
	Double duration;
	String paymentStatus;
	List<Integer> seats;
}
