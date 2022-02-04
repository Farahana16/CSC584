package booking.controller;

import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import booking.dao.CustomerDAO;
import booking.dao.BookingDAO;
import booking.dao.PaymentDAO;
import booking.model.Booking;

/**
 * Servlet implementation class AddBookingController
 *
 */
@WebServlet("/AddBookingController")
public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookingController() {
		super();
		dao = new BookingDAO();
		//TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid = Integer.parseInt(request.getParameter("custid"));
		
		request.setAttribute("c", CustomerDAO.getCustomerById(custid));
		RequestDispatcher view = request.getRequestDispatcher("BookForm.jsp");
		view.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Booking bk = new Booking();
		int custid = Integer.parseInt(request.getParameter("custid"));
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int numOfCust = Integer.parseInt(request.getParameter("numOfAdults")) + Integer.parseInt(request.getParameter("numOfChild"));
		int campId = Integer.parseInt(request.getParameter("roomType"));
		
		boolean available = dao.checkRoom(checkin, campId);
		
		if(available) {
			int numOfDays = (Integer.parseInt(checkout.substring(8,10)) - Integer.parseInt(checkin.substring(8,10)));
			bk.setCheckIn(checkin);
			bk.setCheckOut(checkout);
			bk.setNumOfCust(numOfCust);
			bk.setNumOfDays(numOfDays);
			bk.setCampID(campId);
			bk.setCustID(custid);
			dao.addBooking(bk);
			
			request.setAttribute("bookings", BookingDAO.getAllBookingById(custid));
			RequestDispatcher view = request.getRequestDispatcher("ListBooking.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("error", "Room is not available");
			RequestDispatcher view = request.getRequestDispatcher("rooms.jsp");
			view.include(request, response);
		}
		
		
	}

}