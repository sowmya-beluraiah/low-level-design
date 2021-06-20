package com.ticketcookingsystem.ticketbooksystem.utils;

import java.sql.Timestamp;
import java.util.Map;

public class BookingSession {
	public static Map<Integer,Timestamp> session;
	
	public static void startSession(Integer userId, Timestamp time) {
		session.put(userId, time);
	}
	
	public static boolean isSessionExpired(Integer userId) {
		return false;
	}
}
