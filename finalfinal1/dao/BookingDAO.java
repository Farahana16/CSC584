package booking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import booking.db.ConnectionManager;
import booking.model.*;

public class BookingDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private int bookingID;
	private String bookingDate;
	private String bookingTime;
	private String checkIn;
	private String checkOut;
	private int numOfCust;
	private int numOfDays;
	private int custID;
	private int campID;
	
	//check room
	public boolean checkRoom(String checkIn, int campID) {
		this.checkIn = checkIn;
		this.campID = campID;
		boolean available = true;
		
		try {
			con= ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT * FROM booking WHERE checkInDate = ? AND campID = ?");
			ps.setString(1, checkIn);
			ps.setInt(2, campID);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				available = false;
			}
			
			con.close();
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		return available;
	} 
	
	//add Booking
	public void addBooking(Booking bean) {
		checkIn = bean.getCheckIn();
		checkOut = bean.getCheckOut();
		numOfCust = bean.getNumOfCust();
		numOfDays = bean.getNumOfDays();
		custID = bean.getCustID();
		campID = bean.getCampID();
		
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			// create statement
			ps = con.prepareStatement("INSERT INTO booking(bookingDate, checkInDate, checkOutDate, numOfCust, numOfDays, custID, campID) VALUES(SYSDATE(),?,?,?,?,?,?)");
			ps.setString(1, checkIn);
			ps.setString(2, checkOut);
			ps.setInt(3, numOfCust);
			ps.setInt(4, numOfDays);
			ps.setInt(5, custID);
			ps.setInt(6, campID);
			
			//exequte query
			ps.executeUpdate();
			System.out.print("Succesfully inserted");
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all custService
	public static List<Booking> getAllBookingById(int custid){
		List<Booking> bookings = new ArrayList<Booking>();
		
		try {
			con= ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT * FROM booking b join camp c  on (b.campID = c.campID) WHERE custID = ?");
			ps.setInt(1, custid);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Booking bk = new Booking();
				
				bk.setBookingID(rs.getInt("bookingID"));
				bk.setBookingDate(rs.getDate("bookingDate"));
				bk.setCheckIn(rs.getString("checkInDate"));
				bk.setCheckOut(rs.getString("checkOutDate"));
				bk.setNumOfCust(rs.getInt("numOfCust"));
				bk.setNumOfDays(rs.getInt("numOfDays"));
				bk.setCustID(rs.getInt("custid"));
				bk.setCampID(rs.getInt("campID"));
				bk.setCampType(rs.getString("campType"));
				bk.setCampLocation(rs.getString("campLocation"));
				bk.setCampLimitGuest(rs.getInt("campLimitGuest"));
				
				bookings.add(bk);
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}
	
	//get all custService
		public static List<Booking> getAllBooking(){
			List<Booking> bookings = new ArrayList<Booking>();
			
			try {
				con = ConnectionManager.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM booking b join camp c  on (b.campID = c.campID) ORDER BY bookingID";
				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Booking bk = new Booking();
					
					bk.setBookingID(rs.getInt("bookingID"));
					bk.setBookingDate(rs.getDate("bookingDate"));
					bk.setCheckIn(rs.getString("checkInDate"));
					bk.setCheckOut(rs.getString("checkOutDate"));
					bk.setNumOfCust(rs.getInt("numOfCust"));
					bk.setNumOfDays(rs.getInt("numOfDays"));
					bk.setCustID(rs.getInt("custID"));
					bk.setCampID(rs.getInt("campID"));
					bk.setCampType(rs.getString("campType"));
					bk.setCampLocation(rs.getString("campLocation"));
					bk.setCampLimitGuest(rs.getInt("campLimitGuest"));
					
					bookings.add(bk);
				}
				
				//close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return bookings;
		}
	
	//get all by id
	public static Booking getBookingById(int bookingID) {
		Booking bk = new Booking();
		
		try {
			con= ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT * FROM booking WHERE bookingID = ?");
			ps.setInt(1, bookingID);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				bk.setBookingID(bookingID);
				bk.setBookingDate(rs.getDate("bookingDate"));
				bk.setCheckIn(rs.getString("checkInDate"));
				bk.setCheckOut(rs.getString("checkOutDate"));
				bk.setNumOfCust(rs.getInt("numOfCust"));
				bk.setNumOfDays(rs.getInt("numOfDays"));
				bk.setCustID(rs.getInt("custid"));
				bk.setCampID(rs.getInt("campID"));
			}
			//close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bk;
	}

	//delete custService
	public void deleteBooking(int bookingID) {
		try {
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM booking WHERE bookingID = ?");
			ps.setInt(1, bookingID);
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}