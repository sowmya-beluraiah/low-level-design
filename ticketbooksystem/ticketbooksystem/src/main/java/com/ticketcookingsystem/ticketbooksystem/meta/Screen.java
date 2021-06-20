package com.ticketcookingsystem.ticketbooksystem.meta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="screens")
@Data
public class Screen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@OneToMany(mappedBy="screen")
	private List<Show> shows;
	
	@ManyToOne
	@JoinColumn(name="theatre_id", nullable=false)
	//@Column(name="theatre_id")
	private Theatre theatre;
}
