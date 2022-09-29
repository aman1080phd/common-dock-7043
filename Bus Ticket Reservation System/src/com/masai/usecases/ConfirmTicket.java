package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.TicketDao;
import com.masai.dao.TicketDaoImpl;

public class ConfirmTicket {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BusNo: ");
		int busno = sc.nextInt();
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		
	    TicketDao dao = new TicketDaoImpl();
	    
	    
	    String result = dao.ticketCancel(busno, name);
	    
//	    String result = dao.confirmTicket("Agra", "Mathura", "Aman", 20);
	    
	    System.out.println();
	    
	    System.out.println(result);
	    
	    
		
		
		
	}

}
