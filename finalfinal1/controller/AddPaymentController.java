package booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import booking.dao.BookingDAO;
import booking.dao.CustomerDAO;
import booking.dao.PaymentDAO;
import booking.model.Payment;

/**
 * Servlet implementation class AddPaymentController
 */
@WebServlet("/AddPaymentController")
public class AddPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaymentDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentController() {
        super();
        dao = new PaymentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingID = Integer.parseInt(request.getParameter("bookingID"));
		
		request.setAttribute("c", PaymentDAO.getPaymentById(bookingID));
		RequestDispatcher view = request.getRequestDispatcher("Payment.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Payment c = new Payment();
		c.setPaymentType(request.getParameter("paymentType"));
		c.setBookingID(Integer.parseInt(request.getParameter("bookingID")));
		
		dao.addPayment (c);
		
		request.setAttribute("payment", PaymentDAO.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("rooms.jsp");
		view.forward(request, response);
	}

}