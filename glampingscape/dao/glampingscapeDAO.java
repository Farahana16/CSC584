/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glampingscape.dao;

import glampingscape.model.glampingscape;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import glampingscape.db.ConnectionManager;
import glampingscape.model.glampingscape;

/**
 *
 * @author User
 */
public class glampingscapeDAO {
    static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private int id;
	private String type,subject,description,status,date;
        
        
        //add glampingscape
        public void addglampingscape(glampingscape bean) {
		type = bean.getroomType();
		description = bean.getDescription();
		date = bean.getDate();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO glampinscape(date,type,description)VALUES(?,?,?)");
			ps.setString(1, date);
			ps.setString(2, type);
			ps.setString(3, description);
		
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			}catch(Exception e)
                        {
                            e.printStackTrace();
			}
        }
        
        //get all glampingscape
	public static List<glampingscape> getAllglampingscape(){
		List<glampingscape> glampingscape = new ArrayList<glampingscape>();
		
		try {
			con = ConnectionManager.getConnection();
			
			stmt = con.createStatement();
			String sql = "SELECT * FROM glampingscape ORDER BY id";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				glampingscape g = new glampingscape();
				
				g.setId(rs.getInt("id"));
				g.setDate(rs.getString("date"));
				g.setType(rs.getString("type"));
				g.setDescription(rs.getString("description"));
				
				glampingscape.add(g);
			}
			
			//close connection
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return glampingscape;
		
	}
              //get all by id
	public static glampingscape getglampingscapeById(int id) {
		
		glampingscape g = new glampingscape();
		
		try {
		con = ConnectionManager.getConnection();
		
		//create statement
		ps = con.prepareStatement("SELECT * FROM glampingscape where id = ?");
		ps.setInt(1, id);
		
		
		rs = ps.executeQuery();
		if(rs.next()) {
			g.setId(rs.getInt("id"));
			g.setDate(rs.getString("date"));
			g.setType(rs.getString("type"));
			g.setDescription(rs.getString("description"));
		}
		
		//close connection
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return g;
		
	}  
        
        //delete glampingscape
	public void deleteglampingscape(int id) {
		
		try {
			
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM glampingscape where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//update glampingscape
	public void updateglampingscape(glampingscape bean) {
		id = bean.getId();
		type = bean.getroomType();
		description = bean.getDescription();
		date = bean.getDate();
		
		try {
			con = ConnectionManager.getConnection();
			
			ps = con.prepareStatement("UPDATE glampingscape set id=?,type=?,description=?,date=?");
			
			ps.setInt(1, id);
			ps.setString(2, type);
			ps.setString(3, description);
			ps.setString(4, date);
			
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

    
    


   

