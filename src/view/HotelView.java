package view;

import java.sql.Date;
import java.util.Scanner;

public class HotelView {
	
	private static Scanner sc = new Scanner(System.in);
	
	public int showMenu() {
		System.out.println();
		System.out.println("===== Hotel Reservation System =====");
		System.out.println();
		System.out.println("1. Add room");
		System.out.println("2. Book room");
		System.out.println("3. Cancel Booking");
		System.out.println("4. Check availability");
		System.out.println("5. Show all rooms ");
		System.out.println("6. Show all bookings ");
		System.out.println("7. Exit");
		System.out.println("Enter your choice : ");
		return sc.nextInt();
	}

	public int getRoomId() {
		System.out.println("Enter room id : ");
		return sc.nextInt();
	}

	public int getRoomNumber() {
		System.out.println("Enter room number : ");
		return sc.nextInt();
	}

	public String getRoomType() {
		sc.nextLine();
		System.out.println("Enter room Type : ");
		return sc.nextLine();
	}

	public double getRoomPrice() {
		System.out.println("Enter room price : ");
		return sc.nextDouble();
	}

	public String getRoomStatus() {
		sc.nextLine();
		System.out.println("Enter room status : ");
		return sc.nextLine();
	}

	//for booking 

	public int getBookingId() {
		System.out.println("Enter Book id ");
		return sc.nextInt();
	}

	public String getCustomerName() {
		sc.nextLine();
		System.out.println("Enter Customer name ");
		return sc.nextLine();
	}

	public Date getCheckIn() {
		sc.nextLine();
		System.out.println("Enter check-in date ");
		return Date.valueOf(sc.nextLine());
	}

	public Date getCheckOut() {
		System.out.println("Enter check-out date ");
		return Date.valueOf(sc.nextLine());
	}

}
