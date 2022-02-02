package profile.dao;

import java.sql.*;
import java.util.*;
import profile.db.ConnectionManager;
import profile.model.Profile;

public class ProfileDAO {
	
		static Connection con = null;
		static PreparedStatement ps = null;
		static Statement stmt = null;
		static ResultSet rs = null;
		private int custid;
		private String custname;
		private String custusername;
		private String custemail;
		private String custpwd;
		private int custphonenum;

		//add shawl
		public void addProfile(Profile bean) {
			custname = bean.getCustname();
			custusername= bean.getCustusername();
			custemail = bean.getCustemail();
			custpwd = bean.getCustpwd();
			custphonenum = bean.getCustphonenum();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("INSERT INTO customer(custname,custusername,custemail,custphonenum,custpwd)VALUES(?,?,?,?,?)");
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
			
		}
			
		
		

		//get all shawls
		public static List<Profile> getAllProfiles(){
			List<Profile> profiles = new ArrayList<Profile>();
			
			try {
				con = ConnectionManager.getConnection();
				
				stmt = con.createStatement();
				String sql = "SELECT * FROM customer ORDER BY custid";
				
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Profile s = new Profile();
					
					s.setCustid(rs.getInt("custid"));
					s.setCustname(rs.getString("custname"));			
					s.setCustusername(rs.getString("custusername"));
					s.setCustemail(rs.getString("custemail"));
					s.setCustpwd(rs.getString("custpwd"));
					s.setCustphonenum(rs.getInt("custphonenum"));
					
					profiles.add(s);
				}
				
				//close connection
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return profiles;
		}

		
		//get shawl by id
		public static Profile getProfileById(int custid) {
			Profile s = new Profile();
			
			try {
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("SELECT * FROM customer where custid = ?");
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
		public void deleteProfile(int custid) {
			
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement 
				ps=con.prepareStatement("delete from customer where custid=?");
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
		public void updateProfile(Profile bean) {
			
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
			
		
	}
