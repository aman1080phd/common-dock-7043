package com.masai.runner;

import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;

public class Main {
	
	public static void main(String[] args) {
		
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
			
			System.out.println("1. Insert Bus Details");
			
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
			
			System.out.println();
			System.out.println("Enter your choice: ");
			int bookorNot = sc.nextInt();
			
			if(bookorNot==1)
			{
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
}
