package entity;

import java.sql.Date;

public class Booking {
	private int id ;
	private String customerName;
	private int roomId;
	private Date checkIn;
	private Date checkOut;
	
	public Booking() {
		super();
	}

	public Booking(String customerName, int roomId, Date checkIn, Date checkOut) {
		super();
		this.customerName = customerName;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Booking(int id, String customerName, int roomId, Date checkIn, Date checkOut) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.roomId = roomId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerName=" + customerName + ", roomId=" + roomId + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + "]";
	}
	
	

}
