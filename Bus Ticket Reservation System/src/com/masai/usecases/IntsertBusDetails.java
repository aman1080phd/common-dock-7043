package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;

public class IntsertBusDetails {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		
		TicketDao dao = new TicketDaoImpl();
		
		String result = dao.insertBusDetails(busname, source, destination, bustype, seats, arrivalTime, departureTime);
		
		System.out.println(result);
		
		
		
	}
	

}
