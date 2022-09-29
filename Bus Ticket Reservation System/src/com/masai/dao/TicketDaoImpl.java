package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	@Override
	public String confirmTicket(String source, String destination, String name, int age) {
		
		String message = "Seat Not Available !";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select seats,busno from busdetails "
					+ "where source = ? and destination = ?");
			
			ps.setString(1, source);
			ps.setString(2, destination);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int x = rs.getInt("Seats");
				
				if(x>0)
				{
					PreparedStatement ps2 = conn.prepareStatement("Update busdetails set Seats = Seats-1 where source = ?");
					
					ps2.setString(1, source);
					
					ps2.executeUpdate();
					
					PreparedStatement ps3 = conn.prepareStatement("insert into customerdetails values(?,?,?)");
					
					ps3.setInt(1, rs.getInt("busno"));
					ps3.setString(2, name);
					ps3.setInt(3, age);
					
					
					ps3.executeUpdate();
					
					PreparedStatement ps4  = conn.prepareStatement("select * from customerdetails where name = ?");
					
					ps4.setString(1, name);
					
					ResultSet rs2 = ps4.executeQuery();
					
					if(rs2.next())
					{
						System.out.println();
						System.out.println("BusNo: "+ rs2.getInt("busno"));
						System.out.println("Passenger Name: "+rs2.getString("Name"));
						System.out.println("Passenger Age: "+rs2.getInt("Age"));						
					}
					message = "Ticked confirmed !";
				}
				
			}
			else 
			{
				message = "Please Enter Valid Location !";
			}
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		
		
		
		
		
		return message;
	}

	@Override
	public String ticketCancel(int busno, String name) {
		
		String message = "Ticket Canellation Unsucessful !";
		
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from customerdetails where name = ? and busno = ?");
			
			ps.setString(1, name);
			ps.setInt(2, busno);
			
			int x= ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement("Update busdetails set seats = seats+1 where busno = ?");
			
			ps2.setInt(1, busno);
			
			ps2.executeUpdate();
			
			if(x>0)
			{
				message = "Ticket Cancellation Sucessful !";
			}
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public String adminLogin(String username, String password) {
		
		String message = "Wrong Credentials!";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from adminlogin where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println();
				System.out.println("Welcome "+rs.getString("username")+"!");
				message = "";
			}
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}

}
