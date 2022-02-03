package camping.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import camping.db.ConnectionManager;
import camping.model.Payment;

public class PaymentDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int paymentid, bookingid;
	private String paymentType;
	private double paymentTotal;
	
	//add Payment
	public void addPayment(Payment bean) {
		paymentid = bean.getPaymentid();
		bookingid = bean.getBookingid();
		paymentType = bean.getPaymentType();
		paymentTotal = bean.getPaymentTotal();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO bookingcamping(bookingid,paymentType,paymentTotal)VALUES(?,?,?)");
			ps.setInt(1, bookingid);
			ps.setString(2, paymentType);
			ps.setDouble(3, paymentTotal);
			
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
			String sql = "SELECT * FROM payment ORDER BY id";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Payment c = new Payment();
				
				c.setPaymentid(rs.getInt("paymentid"));
				c.setPaymentType(rs.getString("paymentType"));
				c.setPaymentTotal(rs.getDouble("paymentTotal"));
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
	public static Payment getPaymentById(int id) {
		
		Payment c = new Payment();
		
		try {
		con = ConnectionManager.getConnection();
		
		//create statement
		ps = con.prepareStatement("SELECT * FROM campingbooking where id = ?");
		ps.setInt(1, id);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
			c.setPaymentid(rs.getInt("paymentid"));
			c.setPaymentType(rs.getString("paymentType"));
			c.setPaymentTotal(rs.getDouble("paymentTotal"));
		}
		
		//close connection
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
		
	}
	

	
}