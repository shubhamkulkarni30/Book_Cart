package model;

import static model.DAOProvider.DRIVER;
import static model.DAOProvider.PASSWORD;
import static model.DAOProvider.URL;
import static model.DAOProvider.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connectDB() throws SQLException, ClassNotFoundException
	{
		Class.forName(DRIVER);
		Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

}
