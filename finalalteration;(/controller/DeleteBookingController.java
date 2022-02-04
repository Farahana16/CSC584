package booking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import booking.dao.BookingDAO;

/**
 * Servlet implementation class DeleteBookingController
 */
@WebServlet("/DeleteBookingController")
public class DeleteBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBookingController() {
		super();
		dao = new BookingDAO();
		//TODO Auto-generated constructor stub
	} 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookingID = Integer.parseInt(request.getParameter("bookingID"));
		dao.deleteBooking(bookingID);
		
		RequestDispatcher view = request.getRequestDispatcher("ListBooking.jsp");
		view.forward(request, response);
	}
}