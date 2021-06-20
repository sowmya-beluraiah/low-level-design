package com.ticketcookingsystem.ticketbooksystem.meta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="seats")
@Data
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column(name ="status", columnDefinition ="varchar(255) default 'AVAILABLE'")
	String status;
	
	@ManyToOne
	@JoinColumn(name="show_id", nullable=false)
	private Show show;

}
