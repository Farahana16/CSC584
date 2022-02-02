package profile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import profile.dao.ProfileDAO;

/**
 * Servlet implementation class DeleteProfileController
 */
@WebServlet("/DeleteProfileController")
public class DeleteProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProfileController() {
        super();
        dao = new ProfileDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int custid = Integer.parseInt(request.getParameter("custid"));
		dao.deleteProfile(custid);
		
		request.setAttribute("profiles", ProfileDAO.getAllProfiles());
		RequestDispatcher view = request.getRequestDispatcher("ListProfile.jsp");
		view.forward(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
