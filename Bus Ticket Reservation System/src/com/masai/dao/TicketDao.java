package com.masai.dao;

import java.sql.Connection;

import com.masai.utility.DButil;

public class TicketDao {
	
	public static String insertBusDetails(String BusName,String source, String destination,
			String BusType, int Seats, String ArrivalTime, String DepartureTime)
	{
		String message = "Not inserted !";
		
		try (Connection conn = DButil.provideConnection()) {
			
			conn.prepareStatement("insert into busdetails(BusName,Source,Destination, "
					+ "BusType, Seats, ArrivalTime, DepartureTime) values ");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return message;
	}

}
