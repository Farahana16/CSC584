package cb.dao;

import java.security.*;
import java.sql.*;
import java.util.*;

import cb.connection.ConnectionManager;
import cb.model.Customer;


public class CustomerDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String custEmail, custPwd, custName, custUsername;
	static int custID, custPhoneNum;
	
	//login
	public static Customer login(Customer bean) throws NoSuchAlgorithmException{
		//get email and password
		custEmail = bean.getCustEmail();
		custPwd = bean.getCustPwd();

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(custPwd.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String query = "select * from customer where custEmail='" + custEmail + "'AND custPwd='" + sb.toString() + "'";

		try {
			//call getConnection() method //3. create statement  //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
		    //4. execute query
			rs = stmt.executeQuery(query);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				int id = rs.getInt("custId");
				String email = rs.getString("custEmail");
				bean.setCustId(id);
				bean.setCustEmail(email);

			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}
	
	//add new user (register)
		public void add(Customer bean) throws NoSuchAlgorithmException{
			//get email,name and password
			custEmail = bean.getCustEmail();
			custPwd = bean.getCustPwd();

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(custPwd.getBytes());

			byte byteData[] = md.digest();

			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			String pass = sb.toString();

			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("insert into customer(custEmail,custPwd)values(?,?)");
				ps.setString(1,custEmail);
				ps.setString(2,pass);
				//4. execute query
				ps.executeUpdate();			
				
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

		}
		
		//method to get user
		public static Customer getCustomer(Customer bean)  {   
			//get email
			custEmail = bean.getCustEmail();
			String searchQuery = "select * from customer where custEmail='" + custEmail + "'";
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//execute statement
				rs = stmt.executeQuery(searchQuery);

				boolean more = rs.next();

				// if user exists set the isValid variable to true
				if (more) {
					String email = rs.getString("custEmail");
					bean.setCustEmail(email);
					bean.setValid(true);
				}
				// if user does not exist set the isValid variable to false
				else if (!more) {
					bean.setValid(false);
				}
				//5. close connection
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();		
			}
			return bean;
		}
		
		//get user by email
		public static Customer getCustomerByEmail(String custEmail) {
			Customer c = new Customer();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("select * from customer where custEmail=?");
				ps.setString(1, custEmail);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {	            
					c.setCustID(rs.getInt("custID"));
					c.setCustEmail(rs.getString("custEmail"));				
					c.setCustPwd(rs.getString("custPwd"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return c;
		}
		
		//get user by id
		public static Customer getCustomerById(int custID) {
			Customer us = new Customer();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("select * from users where custID=?");
				ps.setInt(1, custID);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {
					us.setCustID(rs.getInt("custID"));
					us.setCustEmail(rs.getString("custEmail"));
					us.setCustPwd(rs.getString("custPwd"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return us;
		}
		
		public static List<Customer> getCustomerId() {
			List<Customer> c = new ArrayList<Customer>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				rs = stmt.executeQuery("select custID, custEmail from customer");

				while (rs.next()) {
					Customer cust = new Customer();
					cust.setCustID(rs.getInt("custID"));
					cust.setCustEmail(rs.getString("custEmail"));
					c.add(cust);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return c;
		}
		

}
