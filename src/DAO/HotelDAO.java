package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBUtil;
import entity.Booking;
import entity.Room;

public class HotelDAO {
	
	//add room
		public int addroom(Room r) {
			int i =0;
			try {
				Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("insert into room(roomNumber,roomType,price,status) values(?,?,?,?)");
				pst.setInt(1, r.getRoomNumber());
				pst.setString(2, r.getRoomType());
				pst.setDouble(3, r.getPrice());
				pst.setString(4, r.getStatus());
				
				i = pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
		}
		
	//book room
		public int bookroom(Booking b) {

			int i = 0;

			try {

				Connection con = DBUtil.makeConnection();

				PreparedStatement pst = con.prepareStatement(
						"select * from room where id=? and status='Available'");

				pst.setInt(1, b.getRoomId());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					PreparedStatement pst1 = con.prepareStatement(
							"insert into booking(customerName , roomId , checkIn , checkOut) values(?,?,?,?)");

					pst1.setString(1, b.getCustomerName());
					pst1.setInt(2, b.getRoomId());
					pst1.setDate(3, b.getCheckIn());
					pst1.setDate(4, b.getCheckOut());

					i = pst1.executeUpdate();

					PreparedStatement pst2 = con.prepareStatement(
							"update room set status='Booked' where id=?");

					pst2.setInt(1, b.getRoomId());

					pst2.executeUpdate();

				} else {

					System.out.println("Room Already Booked");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return i;
		}
		
	//cancel booking
		public int CancelBooking(int Bookingid , int RoomId) {
			int i =0;
			try {
				Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("delete from booking where id = ? ");
				pst.setInt(1, Bookingid);
				i = pst.executeUpdate();
				
				PreparedStatement pst2 = con.prepareStatement("update room set status = 'Available' where id = ? ");
				pst2.setInt(1, RoomId);
				pst2.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return i;
		}
		
	//check availability
		public void checkAvailability() {
			try {
				Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("select * from room where status = 'Available' ");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					System.out.println("Room ID : "+rs.getInt("id") + " ," + " Room Number : "+ rs.getInt("roomNumber") + " , " + " Room Type : "+rs.getString("roomType") + " , " + " Price : "+rs.getDouble("price") + " , " + " Status : "+rs.getString("status"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	//show all room
		public void ShowAllRoom() {
			try {
				Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("select * from room");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					System.out.println("Room ID : "+rs.getInt("id") + " ," + " Room Number : "+ rs.getInt("roomNumber") + " , " + " Room Type : "+rs.getString("roomType") + " , " + " Price : "+rs.getDouble("price") + " , " + " Status : "+rs.getString("status"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	//show all booking
		public void ShowAllBooking() {
			try {
				Connection con = DBUtil.makeConnection();
				PreparedStatement pst = con.prepareStatement("select * from booking");
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					System.out.println("Book ID : "+rs.getInt("id") + " ," + " Customer Name : "+ rs.getString("customerName") + " , " + " Room Id : "+rs.getInt("roomId") + " , " + " checkIn : "+rs.getDate("checkIn") + " , " + " checkOut : "+rs.getDate("checkOut"));
				
			} 
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
