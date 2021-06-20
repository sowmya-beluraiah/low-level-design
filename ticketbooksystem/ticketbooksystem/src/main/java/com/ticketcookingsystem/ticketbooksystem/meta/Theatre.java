package com.ticketcookingsystem.ticketbooksystem.meta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="theatres")
public class Theatre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column(name="theatre_name")
	String theatreName;
	
	@OneToMany(mappedBy="theatre")
    private List<Screen> screens;
	
	@OneToMany(mappedBy="theatreshow")
    private List<Show> shows;
}
