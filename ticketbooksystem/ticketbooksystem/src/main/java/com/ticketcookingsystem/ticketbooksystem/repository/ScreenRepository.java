package com.ticketcookingsystem.ticketbooksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketcookingsystem.ticketbooksystem.meta.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer>{
	@Query(value = "select s from Screen s where s.theatre.id = :theatreId order by s.id asc")
	public List<Screen> findByTheatreId(Integer theatreId);

}
