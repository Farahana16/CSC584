package payment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import payment.db.ConnectionManager;
import payment.model.Payment;

public class PaymentDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id, secCode;
	private String payType,cardNum,name,expDate;
	
	//add Payment
	public void addPayment(Payment bean) {
		id = bean.getId();
		payType = bean.getPayType();
		cardNum = bean.getCardNum();
		name = bean.getName();
		expDate = bean.getExpDate();
		secCode = bean.getSecCode();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO payment(payType,cardNum,name,expDate,secCode)VALUES(?,?,?,?,?)");
			ps.setString(1, payType);
			ps.setString(2, cardNum);
			ps.setString(3, name);
			ps.setString(4, expDate);
			ps.setInt(5, secCode);
			
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
				
				c.setId(rs.getInt("id"));
				c.setPayType(rs.getString("payType"));
				c.setCardNum(rs.getString("cardNum"));
				c.setName(rs.getString("name"));
				c.setExpDate(rs.getString("expDate"));
				c.setSecCode(rs.getInt("secCode"));
				
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
		ps = con.prepareStatement("SELECT * FROM payment where id = ?");
		ps.setInt(1, id);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
			c.setId(rs.getInt("id"));
			c.setPayType(rs.getString("payType"));
			c.setCardNum(rs.getString("cardNum"));
			c.setName(rs.getString("name"));
			c.setExpDate(rs.getString("expDate"));
			c.setSecCode(rs.getInt("secCode"));
		}
		
		//close connection
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
		
	}
	
	//delete payment
	public void deletePayment(int id) {
		
		try {
			
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM payment where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//update payment
	public void updatePayment(Payment bean) {
		id = bean.getId();
		payType = bean.getPayType();
		cardNum = bean.getCardNum();
		name = bean.getName();
		expDate = bean.getExpDate();
		secCode = bean.getSecCode();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("UPDATE payment set id=?,payType=?, cardNum=?, name=?, expDate=?, secCode=?");
			
			ps.setInt(1, id);
			ps.setString(2, payType);
			ps.setString(3, cardNum);
			ps.setString(4, name);
			ps.setString(5, expDate);
			ps.setInt(6, secCode);
			
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