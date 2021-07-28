package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Books;
import model.DAOImplementer;

/**
 * Servlet implementation class BookServ
 */
@WebServlet("/BookServ")
public class BookServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOImplementer di=new DAOImplementer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public BookServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		String bc[]=request.getParameterValues("bcat");
		
		
		try {
			List<Books> l=di.getBooks(bc);
			//System.out.println(l);
			request.setAttribute("books", l);
			RequestDispatcher rd=request.getRequestDispatcher("Show.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
