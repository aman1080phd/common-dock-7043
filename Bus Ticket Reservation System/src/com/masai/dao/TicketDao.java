package com.masai.dao;

public interface TicketDao {
	
	public String insertBusDetails(String BusName,String source, String destination,
			String BusType, int Seats, String ArrivalTime, String DepartureTime);
}
