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
@WebServlet("/AddController")
public class AddController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private glampingscapeDAO dao;
    
    public AddController(){
        super();
        dao = new glampingscapeDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		glampingscape g = new glampingscape();
		dao.addglampingscape(g);
		
		request.setAttribute("glamping", glampingscapeDAO.getAllglampingscape());
		RequestDispatcher view = request.getRequestDispatcher("glampingscape.jsp");
		view.forward(request, response);
	}
}
