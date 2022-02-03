package booking.model;

import java.util.Date;

public class Booking extends Camp {
	private int bookingID;
	private Date bookingDate;
	private String checkIn;
	private String checkOut;
	private int numOfCust;
	private int numOfDays;
	private int custID;
	
	public Booking() {
		super();
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumOfCust() {
		return numOfCust;
	}

	public void setNumOfCust(int numOfCust) {
		this.numOfCust = numOfCust;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}	
}
