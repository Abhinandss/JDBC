package shopping;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agent {
 public void agentlogin() throws SQLException{
	 java.sql.Connection con=null;
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Abhinandss@98");
	 Scanner sc=new Scanner(System.in);
     System.out.print("enter your username");
     String str=sc.next();
     System.out.print("enter your password");
     String str1=sc.next();
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select *from agent");
     int flag=0;
     while(rs.next()) {
    	 if(str.equals(rs.getString(1)) && str1.equals(rs.getString(2))) {
    		 System.out.print("Successfully verified...");
    		 flag=1;
    		 break;
    	 }
     }
     if(flag==0) {
    	 System.out.print("Invalid username or password");
     }
   }
}
