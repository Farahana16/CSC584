package cb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cb.dao.CustomerDAO;
import cb.model.Customer;

/**
 * Servlet implementation class UpdateProfileController
 */
@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int custid = Integer.parseInt(request.getParameter("custid"));
		
		request.setAttribute("p", CustomerDAO.getProfileById(custid));
		RequestDispatcher view = request.getRequestDispatcher("profileUpdate.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer p = new Customer();
		p.setCustID(Integer.parseInt(request.getParameter("custID")));
		p.setCustName(request.getParameter("custName"));
		p.setCustEmail(request.getParameter("custEmail"));
		p.setCustUsername(request.getParameter("custUsername"));
		p.setCustPwd(request.getParameter("custPwd"));
		p.setCustPhonenum(Integer.parseInt(request.getParameter("custPhonenum")));
		
		dao.updateCustomer(p);
		
		request.setAttribute("profiles", CustomerDAO.getAllCustomers());
		RequestDispatcher view = request.getRequestDispatcher("ListProfile.jsp");
		view.forward(request, response);
	}

}
