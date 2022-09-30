package com.masai.dao;

public interface TicketDao {
	
	public String insertBusDetails(String BusName,String source, String destination,
			String BusType, int Seats, String ArrivalTime, String DepartureTime);
	
	public String confirmTicket(String source, String destination,String name, int age);
	
	public String ticketCancel(int busno, String name);
	
	public String adminLogin(String username, String password);
	
	
}
