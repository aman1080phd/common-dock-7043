package com.masai.runner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;
import com.masai.utility.DButil;

public class Main {
	
	public static void main(String[] args) {
		
		int check = 1;
		
		while(check !=2)
		{
			System.out.println();
			System.out.println("========================================");
			System.out.println("Welcome To Bus Ticket Reservation System");
			System.out.println("========================================");
			
			Scanner sc = new Scanner(System.in);
			TicketDao dao = new TicketDaoImpl();
			
			
			System.out.println();
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println();
			
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			
			if(choice==1)
			{
				System.out.println();
				System.out.println("Enter username: ");
				String username = sc.next();
				
				System.out.println("Enter Password: ");
				String password = sc.next();
				
				
				String login = dao.adminLogin(username, password);
				
				System.out.println(login);
				
				if(login.equals("Wrong Credentials!"))
				{
					check = 1;
					continue;
				}
				
				System.out.println("1. Insert Bus Details");
				System.out.println("2. Go back");
				System.out.println("3. Exit");
				
				System.out.println();
				System.out.println("Enter your choice:");
				int insertorNot = sc.nextInt();
				
				if(insertorNot==1)
					
				{
					System.out.println("Enter BusName: ");
					String busname = sc.next();
					
					System.out.println("Enter Source: ");
					String source = sc.next();
					
					System.out.println("Enter Destination: ");
					String destination = sc.next();
					
					System.out.println("Enter BusType: ");
					String bustype = sc.next();
					
					System.out.println("Enter Seats Avilable: ");
					int seats = sc.nextInt();
					
					System.out.println("Enter ArrivalTime: ");
					String arrivalTime = sc.next();
					
					System.out.println("Enter DepartureTime: ");
					String departureTime = sc.next();
					
					
					String result = dao.insertBusDetails(busname, source, destination, bustype, seats, arrivalTime, departureTime);
					
					System.out.println(result);
					
				}
				else if(insertorNot==2)
				{
					check = 1;
				}
				else if(insertorNot==3)
				{
					check = 2;
				}
				else
				{
					System.out.println("Please Enter Correction Information Next Time!");
				}
			}
			else if(choice ==2)
			{
				System.out.println();
				System.out.println("1. Book Ticket");
				System.out.println("2. Cancel Ticket");
				System.out.println("3. Go back");
				System.out.println("4. Exit");
				
				
				System.out.println();
				System.out.println("Enter your choice: ");
				int bookorNot = sc.nextInt();
				
				if(bookorNot==1)
				{
					System.out.println();
					
					try(Connection conn =DButil.provideConnection()) {
						
						
						PreparedStatement ps = conn.prepareStatement("Select * from busdetails");
						
						ResultSet rs = ps.executeQuery();
						
						System.out.println("BUSNO SEATS SOURCE  DESTINATION");
						while(rs.next())
						{
							
							System.out.print("  "+rs.getInt("busno")+"     ");
							
							System.out.print(rs.getInt("seats")+"   ");
							
							System.out.print(rs.getString("source")+"  ");
							System.out.print(rs.getString("destination"));
							
							
							
							System.out.println();
						}
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					} 
					
					System.out.println();
					System.out.println("Enter Source Location: ");
					String source = sc.next();
					
					System.out.println("Enter Destination Location: ");
					String destination = sc.next();
					
					System.out.println("Enter Your Name: ");
					String name = sc.next();
					
					System.out.println("Enter Your Age: ");
					int age = sc.nextInt();
					
					
					String res = dao.confirmTicket(source, destination, name, age );
					
					System.out.println();
					System.out.println(res);
					check = 1;
					
					
				}
				else if(bookorNot==2)
				{
					System.out.println("Enter BusNo: ");
					int busno = sc.nextInt();
					
					System.out.println("Enter Name: ");
					String name = sc.next();
					
					
					String result = dao.ticketCancel(busno, name);
					
					
					System.out.println();
					
					System.out.println(result);
					
				}
				else if(bookorNot==3)
				{
					check = 1;
				}
				else if(bookorNot==4)
				{
					check = 2;
				}
				else
				{
					System.out.println("Please Enter Correction Information Next Time!");
				}
				
			}
			else
			{
				System.out.println("Please Enter Correction Information Next Time!");
			}
			
		}
		
	    System.out.println("============================");
	    System.out.println("Thank you for visiting us !");
	    System.out.println("============================");
		
		
	}
}
