package model;

import java.sql.SQLException;
import java.util.List;

public interface DAOProvider {

	public static String DRIVER = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/chinmay";
	public static String USER = "root";
	public static String PASSWORD = "curry30";
	
	
	public boolean validateUser(User u) throws SQLException;
	public List<String> getBookCat() throws SQLException;
	public List<Books> getBooks(String []bc) throws SQLException;
	public float getTotal( int []bid) throws SQLException;
	
}
