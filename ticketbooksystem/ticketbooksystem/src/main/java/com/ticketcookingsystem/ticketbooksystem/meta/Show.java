package com.ticketcookingsystem.ticketbooksystem.meta;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column(name="movie_name")
	String movieName;
	
	@Column(name="start_time")
	Timestamp startTime;
	
	@Column(name="duration")
	Double duration;
	
	@OneToMany(mappedBy="show")
	List<Seat> seats;
	
	@ManyToOne
	@JoinColumn(name="screen_id")
	private Screen screen;
	
	@ManyToOne
	@JoinColumn(name="theatre_id")
	private Theatre theatreshow;
	
	@Transient
	private List<Seat> lockedSeats;
}
