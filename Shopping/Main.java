package shopping;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Connection con=new Connection();
//		con.Connect();
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Abhinandss@98");
		Scanner sc=new Scanner(System.in);
		System.out.print("1.Agent Login\n2.Admin Login\n3.exit\nenter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			Agent ag=new Agent();
			ag.agentlogin();
			break;
		case 2:
			Admin ad=new Admin();
			ad.adminlogin();
			break;
		case 3:
			return;
		}
	}

}
