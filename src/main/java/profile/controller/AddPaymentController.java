package camping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import camping.dao.PaymentDAO;
import camping.model.Payment;

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
		
		c.setPaymentid(Integer.parseInt(request.getParameter("paymentid")));
		c.setPaymentType(request.getParameter("paymentType"));
		c.setPaymentTotal(Double.parseDouble(request.getParameter("paymentTotal")));
		
		dao.addPayment (c);
		
		request.setAttribute("payment", PaymentDAO.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("ListPayment.jsp");
		view.forward(request, response);
	}

}