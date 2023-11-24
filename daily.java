package project;

import java.sql.*;
import java.util.Scanner;

public class daily {
public static void main(String[] args) 
{
	String url ="jdbc:mysql://localhost:3306?user=root&password=12345";
	String insert ="insert into tejm33.student values(?,?,?,?)";
	String delete = "delete from tejm33.student where rollNo=?";
	String update ="update tejm33.student set sname =? where rollNo=?";
	String select ="select * from tejm33.student where rollNo=? ";
	try {
	while (true) {
		System.out.println("Enter 1 for insert ");
		System.out.println("Enter 2 for delete");
		System.out.println("Enter 3 for update");
		System.out.println("Enter 4 for select");
		Scanner sc =new Scanner(System.in);
		int key = sc.nextInt();
		Connection connect = DriverManager.getConnection(url);
	
		switch (key) {
		case 1:{	
			     PreparedStatement ps = connect.prepareStatement(insert);
		            System.out.println("Enter roll no :");
		    		int rn =sc.nextInt();
		    		ps.setInt(1,rn);
		    		System.out.println("Enter the name :");
		    		String name = sc.next();
		    		ps.setString(2, name);
		    		System.out.println("Enter the percentage :");
		    		double pr = sc.nextDouble();
		    		ps.setDouble(3,pr);
		    		System.out.println("Enter the Stream :");
		    		String branch = sc.next();
		    		ps.setString(4, branch);
		    		ps.executeUpdate();
		    		System.out.println("inserted successfully..!!!");
		    		connect.close();
		       }
			break;
		case 2:{
			    PreparedStatement ps = connect.prepareStatement(delete);
			    System.out.println("Enter the rollnumber ");
			   int rn = sc.nextInt();
			   ps.setInt(1, rn);
			   ps.executeUpdate();
			   System.out.println("Delete successfully");
			   connect.close();
		       }
			break;
		case 3:{
          PreparedStatement ps = connect.prepareStatement(update);
          
          System.out.println("Enter the name ");
          String name =sc.next();
          ps.setString(1,name);
          System.out.println("Enter the roll number ");
          int rn =  sc.nextInt();
          ps.setInt(2,rn);
          ps.executeUpdate();
          System.out.println("Update successfully");
          connect.close();
		}
		break;
		case 4 :{
			PreparedStatement stmt = connect.prepareStatement(select);
			System.out.println("Enter the roll number ");
			int rn = sc.nextInt();
			stmt.setInt(1, rn);
			ResultSet rm = stmt.executeQuery();
			int count=0;
			while(rm.next()) {
				int rn1 =rm.getInt("rollNo");
				String name =rm.getString("sname");
				double per = rm.getDouble("percentage");
				System.out.println("roll no = "+rn1);
				System.out.println("name = "+name);
				System.out.println("percentage = "+per);
				System.out.println("stream = "+ rm.getString("strean"));
				System.out.println(".......................");
				count++;
			}
			if(count==0)
			{
				System.out.println("no records found..!!!");
			}
			connect.close();
		  }
		}
		System.out.println("Enter the 1 for continue");
		int check =sc.nextInt();
		if (check==1) {
			continue;
		}
		else
		{
			break;
		}
	}
	}
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


