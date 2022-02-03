package booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booking.dao.CustomerDAO;
import booking.model.Customer;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		
		//retrieve input and set name, u/name, phone, email, p/w
		c.setCustName(request.getParameter("custName"));
		c.setCustUsername(request.getParameter("cutsUsername"));
		c.setCustPhonenum(Integer.parseInt(request.getParameter("custPhonenum")));
		c.setCustEmail(request.getParameter("custEmail"));		
		c.setCustPwd(request.getParameter("custPwd"));
				
		c = CustomerDAO.getCustomer(c);
		//check if user exists
		if(!c.isValid()){
		   	try {
		       		//if user not exist, add/register the user
					dao.add(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       	//redirect to login page
		       	response.sendRedirect("signIn.jsp");
		 }         
	}

}
