package campbooking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import campbooking.dao.BookingDAO;

/**
 * Servlet implementation class ListBookingController
 *
 */
@WebServlet("/ListBookingController")
public class ListBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookingController() {
		super();
		dao = new BookingDAO();
		//TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//TODO Auto-generated method stub
		int custID = session.getAttribute("SES_ID");
		request.setAttribute("bookings", BookingDAO.getBookingById(custID));
		RequestDispatcher view = request.getRequestDispatcher("ListBooking.jsp");
		view.forward(request, response); 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//TODO Auto-generated method stub
		
		int custID = session.getAttribute("SES_ID");
		request.setAttribute("bookings", BookingDAO.getBookingById(custID));
		RequestDispatcher view = request.getRequestDispatcher("ListBooking.jsp");
		view.forward(request, response); 
	}

}
