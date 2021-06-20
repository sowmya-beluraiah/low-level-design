package com.ticketcookingsystem.ticketbooksystem.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketcookingsystem.ticketbooksystem.service.SeatService;

public class SeatUtil {
	
	//<showId, <userId, List<Seats>>>
	private static Map<Integer, Map<Integer, List<Integer>>> lockedSeats;
	
	public static boolean lockSeats(Integer showId, Integer userId, Integer from , Integer to) {
		if(!lockedSeats.containsKey(showId) ||
				!lockedSeats.get(showId).containsKey(userId)) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			map.put(userId, new ArrayList<>());
			lockedSeats.put(showId, map);
		}
		
		List<Integer> seats = lockedSeats.get(showId).get(userId);
		for(int seatNo=from; seatNo<=to; seatNo++) {
			if(seats.contains(seatNo)) {
				//TODO exception on already seat locked
				return false;
			}
		}
		
		for(int seatNo=from; seatNo<=to; seatNo++) {
			seats.add(seatNo);
		}
		lockedSeats.get(showId).put(userId, seats);
		
		
		return true;
	}

	public static void releaseLockedSeats(Integer showId, Integer userId) {
		if(lockedSeats.containsKey(showId) ||
				lockedSeats.get(showId).containsKey(userId)) {
			lockedSeats.get(showId).remove(userId);
		}	
	}
	
	public static List<Integer> getLockedSeats(Integer showId, Integer userId) {
		List<Integer> res = new ArrayList<>();
		
		if(lockedSeats.containsKey(showId) ||
				lockedSeats.get(showId).containsKey(userId)) {
			res = lockedSeats.get(showId).get(userId);
		}
		
		return res;
	}
}
