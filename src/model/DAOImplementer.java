package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImplementer implements DAOProvider {
	
	static Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;

	static
	{
		
			try {
				con=DBConnection.connectDB();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Override
	public boolean validateUser(User u) throws SQLException {
		
		pst=con.prepareStatement("select * from User where Username=? and Password=?");
		pst.setString(1, u.getUsername());
		pst.setString(2, u.getPassword());
		rs=pst.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}

	@Override
	public List<String> getBookCat() throws SQLException {
		
		List<String> l=new ArrayList<String>();
		st=con.createStatement();
		rs=st.executeQuery("select distinct(Bcategory) from Book");
		while(rs.next())
		{
			l.add(rs.getString(1));
		}
		return l;
	}

	@Override
	public List<Books> getBooks(String[] bc) throws SQLException {
		List<Books> l=new ArrayList<Books>();
		pst=con.prepareStatement("select * from Book where Bcategory=?");
		for(String i:bc)
		{
			pst.setString(1, i);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Books b=new Books();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setBauthor(rs.getString(3));
				b.setBcat(rs.getString(4));
				b.setBprice(rs.getFloat(5));
				l.add(b);	
			}
		}
		
		return l;
	}

	@Override
	public float getTotal(int[] bid) throws SQLException {

		float total=0;
		pst=con.prepareStatement("select Bprice from Book where Bid=?");
		for(int i:bid)
		{
			pst.setInt(1, i);
			rs=pst.executeQuery();
			while(rs.next())
			{
				total=total+rs.getInt(1);
			}
		}
		return total;
	}
	

}
