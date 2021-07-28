package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOImplementer;
import model.User;

/**
 * Servlet implementation class ValidateServ
 */
@WebServlet("/ValidateServ")
public class ValidateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User u=new User();
	DAOImplementer di=new DAOImplementer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		u.setUsername(un);
		u.setPassword(pwd);
		
		try {
			
			boolean s=di.validateUser(u);
			if(s)
			{
				HttpSession hs=request.getSession();
				hs.setAttribute("user", un);
				RequestDispatcher rd=request.getRequestDispatcher("GetServ");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				pw.print("Invalid login details");
				rd.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
