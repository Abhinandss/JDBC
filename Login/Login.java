package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbcDriver");
//	try {
//		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Abhinandss@98");
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","Abhinandss@98");
	 Scanner sc=new Scanner(System.in);
	 System.out.println("enter the Username");
	 String s=sc.next();
	 System.out.println("enter the Password");
	 String s1=sc.next();
	 Statement stmnt=con.createStatement();
	 ResultSet rslt=stmnt.executeQuery("select *from available");
	 int flag=0;
	 while(rslt.next()) {
		 if(s.equals(rslt.getString(2))&& s1.equals(rslt.getString(3))) 
			 flag=1;
		 }
	 if(flag==1)
		 System.out.println("Successfully Verified");
	
	 else
		
		 System.out.println("Invalid username or password");
	 }
	 
	 
}
