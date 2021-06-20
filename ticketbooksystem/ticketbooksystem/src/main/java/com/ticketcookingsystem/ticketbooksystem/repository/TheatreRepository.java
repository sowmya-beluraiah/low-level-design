package com.ticketcookingsystem.ticketbooksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketcookingsystem.ticketbooksystem.meta.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

}
