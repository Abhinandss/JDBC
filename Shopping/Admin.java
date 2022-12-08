package shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.cj.protocol.Resultset;

public class Admin {
	public void adminlogin() throws SQLException {
		java.sql.Connection con=null;
		Scanner sc=new Scanner(System.in);
//		class.forName("com.mysql.jdbcDriver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Abhinandss@98");
		System.out.print("enter your username");
	    String str2=sc.next();
	    System.out.print("enter your password");
	    String str3=sc.next();
	    Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select *from admin");
	     int flag=0;
	     while(rs.next()) {
	    	 if(str2.equals(rs.getString(1)) && str3.equals(rs.getString(2))) {
	    		 System.out.print("Successfully verified...");
	    		 flag=1;	
	    		 int n=1;
	    		 while(n!=0) {
	    			 System.out.println("1.Display\n2.Update\n3.Log out\nenter your choice");
		    		 int choice=sc.nextInt();
	    			 switch(choice){
		    		 case 1:
		    			 String query="select *from grocery";
		    			 Statement st1=con.createStatement();
		    			ResultSet grc=st1.executeQuery(query);
		    			while(grc.next()) {
		    				System.out.println("Prod_id: "+grc.getInt(1)+"\t\t"+"Prod_name: "+grc.getString(2)+"\t\t"+"Quantity: "+grc.getInt(3)+"\t\t"+"Price: "+grc.getInt(4));
		    			}
		    				break;
		    				
		    				case 2:
		    					System.out.print("1.Add product\t2.Delete product\t3.Update product\tenter your choice");
		    					int choice1=sc.nextInt();
		    					switch(choice1) {
		    					case 1:
		    						System.out.print("enter the product id");
		    						int prd_id=sc.nextInt();
		    						System.out.print("enter the product name");
		    						String prd_name=sc.next();
		    						System.out.print("enter the product quantity");
		    						int qty=sc.nextInt();
		    						System.out.print("enter the product price");
		    						int price=sc.nextInt();
		    						String query1="insert into grocery values(?,?,?,?)";
		    						PreparedStatement pst=con.prepareStatement("insert into grocery values(?,?,?,?)");
		    						pst.setInt(1,prd_id);
		    						pst.setString(2,prd_name);
		    						pst.setInt(3,qty);
		    						pst.setInt(4,price);
		    						pst.execute();
		    						break;
		    					case 2:
		    						System.out.print("enter the product id");
		    						int id=sc.nextInt();
		    						Statement st2=con.createStatement();
		    						PreparedStatement pt=con.prepareStatement("delete from grocery where prd_id=?");
		    						pt.setInt(1,id);
		    						pt.execute();
		    						break;
		    					case 3:
		    						System.out.print("enter the product id you wish to update");
		    						int id1=sc.nextInt();
			    					System.out.print("1.Product name\t2.Quantity\t3.Price\nupdate your fields");
			    					String prd_name1=sc.next();
			    					int qty1=sc.nextInt();
			    					int price1=sc.nextInt();
			    					PreparedStatement pst4=con.prepareStatement("update grocery set prd_name=?,qty=?,price=? where prd_id=?");
			    					pst4.setString(1,prd_name1);
		    						pst4.setInt(2,qty1);
		    						pst4.setInt(3,price1);
		    						pst4.setInt(4, id1);
		    						pst4.execute();
			    					
			    					break;
		    					}
		    					break;
		    				case 3:
		    					n=0;
		    					return;
		    		 }
		    	 }}
	    		 }
	    		
	    	 if(flag==0)
	    		 System.out.print("invalid username or password");
	    	 
	}
}
