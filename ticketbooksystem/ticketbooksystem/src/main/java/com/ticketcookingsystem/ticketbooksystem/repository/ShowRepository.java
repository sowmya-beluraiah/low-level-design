package com.ticketcookingsystem.ticketbooksystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketcookingsystem.ticketbooksystem.meta.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{
	@Query(value="select s from Show s where s.screen.id = :screenId")
	public List<Show> findByScreenId(Integer screenId);
}
