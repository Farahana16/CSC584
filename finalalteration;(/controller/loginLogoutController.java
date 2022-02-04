package booking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.dao.CustomerDAO;
import booking.model.Customer;

/**
 * Servlet implementation class loginLogoutController
 */
@WebServlet("/loginLogoutController")
public class loginLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginLogoutController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//get current session
			HttpSession session = request.getSession(true);
			//set current session to null
			session.setAttribute("sessionEmail", null);
			//destroy session
			session.invalidate();
			//redirect to login page
			response.sendRedirect("signIn.jsp");
			}catch(Throwable ex) {
				System.out.println(ex);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Customer c = new Customer();
			//retrieve and set email and password
			c.setCustemail(request.getParameter("custemail"));
			c.setCustpwd(request.getParameter("custpwd"));
			
			//c = CustomerDAO.login(c);
			//set user session if user is valid
			if(c.isValid()) {
				session = request.getSession(true);
				session.setAttribute("sessionId", c.getCustid());
				System.out.println(c.getCustid());
				session.setAttribute("sessionEmail", c.getCustemail());

			}
			//redirect to invalid login.jsp if user isnt valid
			else {
				response.sendRedirect("invalidLogin.jsp");
			}
		}
		catch(Throwable ex) {
			System.out.println(ex);
		}
	}

}
