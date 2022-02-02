package profile.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import profile.dao.ProfileDAO;
import profile.model.Profile;

/**
 * Servlet implementation class UpdateProfileController
 */
@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileController() {
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
		
		request.setAttribute("p", ProfileDAO.getProfileById(custid));
		RequestDispatcher view = request.getRequestDispatcher("profileUpdate.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Profile p = new Profile();
		p.setCustid(Integer.parseInt(request.getParameter("custid")));
		p.setCustname(request.getParameter("custname"));
		p.setCustemail(request.getParameter("custemail"));
		p.setCustusername(request.getParameter("custusername"));
		p.setCustpwd(request.getParameter("custpwd"));
		p.setCustphonenum(Integer.parseInt(request.getParameter("custphonenum")));
		
		dao.updateProfile(p);
		
		request.setAttribute("profiles", ProfileDAO.getAllProfiles());
		RequestDispatcher view = request.getRequestDispatcher("ListProfile.jsp");
		view.forward(request, response);
	}

}
