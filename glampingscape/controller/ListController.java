/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package glampingscape.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import glampingscape.dao.glampingscapeDAO;

/**
 *
 * @author User
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private glampingscapeDAO dao;
    
    public ListController(){
        super();
        dao = new glampingscapeDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("glampingscape", glampingscapeDAO.getAllglampingscape());
		RequestDispatcher view = request.getRequestDispatcher("listglampingscape.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
