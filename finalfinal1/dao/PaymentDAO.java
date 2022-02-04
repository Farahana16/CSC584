package booking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import booking.db.ConnectionManager;
import booking.model.Payment;

public class PaymentDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int paymentID,bookingID;
	private String paymentType;
	
	//add Payment
	public void addPayment(Payment bean) {
		paymentID = bean.getPaymentID();
		paymentType = bean.getPaymentType();
		bookingID = bean.getBookingID();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO payment(paymentType,bookingID)VALUES(?,?)");
			ps.setString(1 ,paymentType);
			ps.setInt(2, bookingID);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	//get all ticket
	public static List<Payment> getAllPayment(){
		List<Payment> Payment = new ArrayList<Payment>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM payment ORDER BY paymentID";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Payment c = new Payment();
				
				c.setPaymentID(rs.getInt("paymentID"));
				c.setPaymentType(rs.getString("paymentType"));
				
				Payment.add(c);
			}
			
			//close connection
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Payment;
		
	}
	
	//get all by id
	public static Payment getPaymentById(int paymentID) {
		
		Payment c = new Payment();
		
		try {
		con = ConnectionManager.getConnection();
		
		//create statement
		ps = con.prepareStatement("SELECT * FROM payment where paymentID = ?");
		ps.setInt(1, paymentID);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
			c.setPaymentID(rs.getInt("paymentID"));
			c.setPaymentType(rs.getString("paymentType"));
		
		//close connection
		con.close();
		}}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
	
	//delete payment
	public void deletePayment(int paymentID) {
		
		try {
			
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM payment where paymentID = ?");
			ps.setInt(1, paymentID);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//update payment
	public void updatePayment(Payment bean) {
		paymentID = bean.getPaymentID();
		paymentType = bean.getPaymentType();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("UPDATE payment set paymentID=?,paymentType=?");
			
			ps.setInt(1, paymentID);
			ps.setString(2, paymentType);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully updated");
			
			//close connection
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
}