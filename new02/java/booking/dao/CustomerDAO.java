package booking.dao;

import java.security.*;
import java.sql.*;
import java.util.*;
import booking.db.ConnectionManager;
import booking.model.Customer;


public class CustomerDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String custemail, custpwd, custname, custusername;
	static int custid;
	static int custphonenum;
	
	//login
	/*public static Customer login(Customer bean) {
		//get email and password
		custemail = bean.getCustemail();
		custpwd = bean.getCustpwd();

		try {
			//call getConnection() method //3. create statement  //4. execute query
			con = ConnectionManager.getConnection();
			//3. create statement
			stmt = con.createStatement();
		    //4. execute query
			//rs = stmt.executeQuery(query);
			//boolean more = rs.next();
			String query = "select * from customer where custEmail='" + custemail + "'AND custPwd='" + custpwd + "'";
			
			ResultSet rs=stmt.executeQuery(query); 
			//processing resultset - iterate
			if(rs.next()){
				int custid = rs.getInt("custid");
				String custemail = rs.getString("custemail");
				bean.setCustid(custid);
				bean.setCustemail(custemail);
			}
			else {
				bean.setValid(false);
			} 
			con.close(); 
		}
		catch(Exception e){ 
			System.out.println(e); 
		} 
			
			// if user exists set the isValid variable to true
			/*if (more) {
				int custid = rs.getInt("custid");
				String custemail = rs.getString("custemail");
				bean.setCustid(custid);
				bean.setCustemail(custemail);

			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}*/

		//return bean;
	//}*/
	
	//add new user (register)
		/*public void add(Customer bean) throws NoSuchAlgorithmException{
			//get email,name and password
			custemail = bean.getCustemail();
			custpwd = bean.getCustpwd();
			custname = bean.getCustname();
			custusername= bean.getCustusername();
			custphonenum = bean.getCustphonenum();
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(custpwd.getBytes());

			byte byteData[] = md.digest();

			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			String custpwd = sb.toString();

			try {
				
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("INSERT INTO customer(custName,custUsername,custEmail,custPhonenum,custPwd)VALUES(?,?,?,?,?)");
				ps.setString(1, custname);
				ps.setString(2, custusername);
				ps.setString(3, custemail);
				ps.setString(4, custpwd);
				ps.setInt(5, custphonenum);
				
				//execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");
				
				//close connection
				con.close();
				}catch(Exception e){
					e.printStackTrace();
				}

		}*/
	
	
		//method to get user
		public static Customer getCustomer(Customer bean)  {   
			//get email
			custemail = bean.getCustemail();
			String searchQuery = "select * from customer where custEmail='" + custemail + "'";
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
					String custemail = rs.getString("custemail");
					bean.setCustemail(custemail);
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
					c.setCustid(rs.getInt("custid"));
					c.setCustemail(rs.getString("custemail"));				
					c.setCustpwd(rs.getString("custpwd"));

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
				ps=con.prepareStatement("select * from customer where custID=?");
				ps.setInt(1, custID);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {
					us.setCustid(rs.getInt("custid"));
					us.setCustemail(rs.getString("custemail"));
					us.setCustpwd(rs.getString("custpwd"));
					us.setCustname(rs.getString("custname"));
					us.setCustusername(rs.getString("custusername"));
					us.setCustphonenum(rs.getInt("custphonenum"));

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
					cust.setCustid(rs.getInt("custid"));
					cust.setCustemail(rs.getString("custemail"));
					c.add(cust);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return c;
		}
		

		//from ProfileDAO

		//get all shawls
		public static List<Customer> getAllCustomers(){
			List<Customer> customers = new ArrayList<Customer>();
			
			try {
				con = ConnectionManager.getConnection();
				
				stmt = con.createStatement();
				String sql = "SELECT * FROM customer ORDER BY custID";
				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Customer s = new Customer();
					
					s.setCustid(rs.getInt("custid"));
					s.setCustname(rs.getString("custname"));			
					s.setCustusername(rs.getString("custusername"));
					s.setCustemail(rs.getString("custemail"));
					s.setCustpwd(rs.getString("custpwd"));
					s.setCustphonenum(rs.getInt("custphonenum"));
					
					customers.add(s);
				}
				
				//close connection
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return customers;
		}

		
		//get shawl by id
		public static Customer getProfileById(int custid) {
			Customer s = new Customer();
			
			try {
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT * FROM customer where custID = ?");
			ps.setInt(1, custid);
			
			
			rs = ps.executeQuery();
			if(rs.next()) {
				s.setCustid(rs.getInt("custid"));
				s.setCustname(rs.getString("custname"));			
				s.setCustusername(rs.getString("custusername"));
				s.setCustemail(rs.getString("custemail"));
				s.setCustpwd(rs.getString("custpwd"));
				s.setCustphonenum(rs.getInt("custphonenum"));
			}
			
			//close connection
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return s;
		}
		
		
		//delete shawl
		public void deleteCustomer(int custid) {
			
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				ps=con.prepareStatement("delete from customer where custID=?");
				ps.setInt(1, custid);
				//4. execute query
				ps.executeUpdate();
				//5. close connection
				con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			
			}
		}
		
		
		//update shawl
		public void updateCustomer(Customer bean) {
			
			custid = bean.getCustid();
			custname = bean.getCustname();
			custusername= bean.getCustusername();
			custemail = bean.getCustemail();
			custpwd = bean.getCustpwd();
			custphonenum = bean.getCustphonenum();
			
				String searchQuery = "UPDATE customer SET custid= '" + custid + "', custname ='" + custname + "', custusername='" + custusername + "', custemail='" + custemail + "',custphonenum='"+custphonenum+"',custpwd='"+custpwd+"' WHERE custid= '" + custid + "'";
				try {                           
					//call getConnection() method 
					con = ConnectionManager.getConnection();
					//3. create statement 
					stmt = con.createStatement();
					//4. execute query
					stmt.executeUpdate(searchQuery);
					//5. close connection
					con.close();
				
				}catch(Exception e) {
					e.printStackTrace();
				
				}
			}
		
		//add shawl
				public void addCustomer(Customer bean) {
					custname = bean.getCustname();
					custusername= bean.getCustusername();
					custemail = bean.getCustemail();
					custpwd = bean.getCustpwd();
					custphonenum = bean.getCustphonenum();
					
					try {
						//call getConnection() method
						con = ConnectionManager.getConnection();
						
						//create statement
						ps = con.prepareStatement("INSERT INTO customer(custName,custUsername,custEmail,custPhoneNum,custPwd)VALUES(?,?,?,?,?)");
						ps.setString(1, custname);
						ps.setString(2, custusername);
						ps.setString(3, custemail);
						ps.setInt(4, custphonenum);
						ps.setString(5, custpwd);
						
						//execute query
						ps.executeUpdate();
						System.out.println("Successfully inserted");
						
						//close connection
						con.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					
				}
}
