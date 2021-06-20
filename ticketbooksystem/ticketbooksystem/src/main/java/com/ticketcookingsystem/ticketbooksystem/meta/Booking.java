package com.ticketcookingsystem.ticketbooksystem.meta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@OneToOne
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	@OneToOne
	@JoinColumn(name="screen_id")
	private Screen screen;
	
	@OneToOne
	@JoinColumn(name="show_id")
	private Show show;
	
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Transient
	List<Seat> seats_booked;
}
