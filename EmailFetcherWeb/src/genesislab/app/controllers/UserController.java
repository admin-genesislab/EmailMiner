package genesislab.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import genesislab.app.dao.UserDAO;
import genesislab.app.dao.UserDAOImpl;
@WebServlet("/UserController")
public class UserController extends HttpServlet
{
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_EMPLOYEE = "/listUser.jsp";
 
 	String forward;
 
 	UserDAO userDAO;
	
	public UserController()
	{
		super();
		userDAO = new UserDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		String action=request.getParameter("action");
		System.out.println("action: " + action + "\n");
		
		if(action.equals("list"))
 		{
			forward = "";
 		}
		else if(action.equals("login"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("username: " + username + "\npassword: " + password);
			boolean validity = userDAO.checkUser(username, password);
			System.out.println(validity);
			if (validity)
				forward = "/index.jsp";
			else
				forward = "/login.jsp";
			
		}
		else if(action.equals("registerUser"))
		{
			
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		//RequestDispatcher view = request.getRequestDispatcher("index.jsp");
 		//view.forward(request, response);
	}
}
