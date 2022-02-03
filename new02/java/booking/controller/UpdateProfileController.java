package booking.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import booking.dao.CustomerDAO;
import booking.model.Customer;

/**
 * Servlet implementation class UpdateProfileController
 */
@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileController() {
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
		
		request.setAttribute("p", CustomerDAO.getCustomerById(custid));
		RequestDispatcher view = request.getRequestDispatcher("profileUpdate.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer p = new Customer();
		p.setCustid(Integer.parseInt(request.getParameter("custid")));
		p.setCustname(request.getParameter("custname"));
		p.setCustemail(request.getParameter("custemail"));
		p.setCustusername(request.getParameter("custusername"));
		p.setCustpwd(request.getParameter("custpwd"));
		p.setCustphonenum(Integer.parseInt(request.getParameter("custphonenum")));
		
		dao.updateCustomer(p);
		
		request.setAttribute("customers", CustomerDAO.getAllCustomers());
		RequestDispatcher view = request.getRequestDispatcher("homepage.jsp");
		view.forward(request, response);
	}

}
