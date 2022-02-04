/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking.model;

/**
 *
 * @author User
 */
public class glampingscape {
    private int id;
	private String date;
	private String type;
	private String subject;
	private String description;
	private String status;
        
     public glampingscape() {}
	
	//id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//date
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//subject
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	//description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//status
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public String getroomType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
