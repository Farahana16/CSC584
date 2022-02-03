/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import booking.dao.glampingscapeDAO;
import booking.model.glampingscape;
/**
 *
 * @author User
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private glampingscapeDAO dao;
    
    public UpdateController(){
        super();
        dao = new glampingscapeDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("g", glampingscapeDAO.getglampingscapeById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateglampingscape.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		glampingscape g = new glampingscape();
		dao.updateglampingscape(g);
		
		request.setAttribute("glam;pingscape", glampingscapeDAO.getAllglampingscape());
		RequestDispatcher view = request.getRequestDispatcher("listglampingscape.jsp");
		view.forward(request, response);
	}
}
