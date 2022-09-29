package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.masai.utility.DButil;

public class TicketDaoImpl implements TicketDao {
	
	@Override
	public String insertBusDetails(String BusName,String source, String destination,
			String BusType, int Seats, String ArrivalTime, String DepartureTime)
	{
		String message = "Not inserted !";
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into busdetails(BusName,Source,Destination, "
					+ "BusType, Seats, ArrivalTime, DepartureTime) values (?,?,?,?,?,?,?) ");
			
			ps.setString(1, BusName);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setString(4, BusType);
			ps.setInt(5, Seats);
			ps.setString(6, ArrivalTime);
			ps.setString(7, DepartureTime);
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				message = "Bus Details Inserted Sucessfully !";
			}
			
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		
		
		return message;
	}

}
