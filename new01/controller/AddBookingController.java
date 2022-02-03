package booking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import campbooking.dao.BookingDAO;
import campbooking.model.Booking;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//TODO Auto-generated method stub
		
		Booking bk = new Booking();

		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int numOfCust = Integer.parseInt(request.getParameter("numOfAdults")) + Integer.parseInt(request.getParameter("numOfChild"));
		int campId = Integer.parseInt(request.getParameter("roomType"));
		
		boolean available = dao.checkRoom(checkin, campId);
		
		if(available) {
			int numOfDays = Integer.parseInt(checkout.substring(3,5)) - Integer.parseInt(checkin.substring(3,5));
			bk.setCheckIn(checkin);
			bk.setCheckOut(checkout);
			bk.setNumOfCust(numOfCust);
			bk.setNumOfDays(numOfDays);
			bk.setCampID(campId);
			dao.addBooking(bk);
			
			RequestDispatcher view = request.getRequestDispatcher("Payment.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("error", "Room is not available");
			RequestDispatcher view = request.getRequestDispatcher("rooms.jsp");
			view.include(request, response);
		}
		
		
	}

}
