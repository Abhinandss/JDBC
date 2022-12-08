package shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	public void Connect() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbcDriver");
	java.sql.Connection con=null;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Abhinandss@98");
   }

	public PreparedStatement prepareStatement(String insertQuery) {
		// TODO Auto-generated method stub
		return null;
	}
}