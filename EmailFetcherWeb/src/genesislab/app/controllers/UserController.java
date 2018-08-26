package genesislab.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import genesislab.app.dao.UserDAO;
import genesislab.app.dao.UserDAOImpl;

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
		
		if(action.equals("list"))
 		{
 
 		}
		else if(action.equals("login"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean validity = userDAO.checkUser(username, password);
			if (validity)
				forward = "home";
			else
				forward = "login";
		}
		else if(action.equals("registerUser"))
		{
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
 		view.forward(request, response);
	}
}
