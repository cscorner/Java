import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PreparedStamentDemo {
	public static void main(String[] args) {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs2021","root","cscorner@1234");
			System.out.println("Connection Created....");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter roll no:");
			int rno=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter marks:");
			int marks=sc.nextInt();
			String query="insert into student values(?,?,?)";//parameter placeholder
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,rno);
			ps.setString(2, name);
			ps.setInt(3, marks);
			int i=ps.executeUpdate();
			System.out.println(i+" record inserted successfully....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}



