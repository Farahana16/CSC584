package booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Payment c = new Payment();
		c.setPayType(request.getParameter("payType"));
		c.setCardNum(request.getParameter("cardNum"));
		c.setName(request.getParameter("name"));
		c.setExpDate(request.getParameter("expDate"));
		c.setSecCode(Integer.parseInt(request.getParameter("secCode")));
		
		dao.addPayment (c);
		
		request.setAttribute("payment", PaymentDAO.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("ListPayment.jsp");
		view.forward(request, response);
	}

}