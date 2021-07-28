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

import model.DAOImplementer;

/**
 * Servlet implementation class PriceServ
 */
@WebServlet("/PriceServ")
public class PriceServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOImplementer di=new DAOImplementer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String []id=(request.getParameterValues("bid"));
		
		int []bid=new int[id.length];
		for(int i=0;i<id.length;i++)
			bid[i]=Integer.parseInt(id[i]);
		try {
			
			float total=di.getTotal(bid);
			request.setAttribute("total", total);
			RequestDispatcher rd=request.getRequestDispatcher("Pay.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}