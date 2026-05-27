package controller;

import java.sql.Date;

import DAO.HotelDAO;
import entity.Booking;
import entity.Room;
import view.HotelView;

public class HotelController {
	
	private HotelDAO model;
	private HotelView view;

	public HotelController(HotelDAO model, HotelView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void run() {
		while(true) {
			int choice = view.showMenu();
			switch(choice) {
			case 1 :{
				int roomNumber = view.getRoomNumber();
				String roomType = view.getRoomType();
				double price = view.getRoomPrice();
				//String status = view.getRoomStatus();
				Room r = new Room(roomNumber, roomType, price, "Available");
				int i = model.addroom(r);
				System.out.println(i!=0 ? "Room added successfully" : " Something went wrong ");
			}
			break;
			
			case 2 :{
				String customerName = view.getCustomerName();
				int roomId = view.getRoomId();
				Date checkIn = view.getCheckIn();
				Date checkOut = view.getCheckOut();
				Booking b = new Booking(customerName, roomId, checkIn, checkOut);
				int i = model.bookroom(b);
				System.out.println(i!=0 ? "Room Booked successfully" : "Something went wrong ");
			}
			break;
			
			case 3 :{
				int bookingId = view.getBookingId();
				int RoomId = view.getRoomId();
				
				int i = model.CancelBooking(bookingId, RoomId);
				System.out.println(i!=0 ? "Booking cancel successfully" : "Something went wrong ");
			}
			break;
			
			case 4 : {
				 model.checkAvailability();
			}
			break;
			
			case 5 :
				model.ShowAllRoom();
			break;
			
			case 6 :
				model.ShowAllBooking();
			break;
			
			case 7 :
				return ; 
				
			default : 
				System.out.println("Invalid choice");
				break;
			
			}
		}
	}

}
