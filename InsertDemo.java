import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class InsertDemo {
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
			String query="insert into student values("+rno+",'"+name+"',"+marks+")";
			Statement st=con.createStatement();
			int i=st.executeUpdate(query);
			System.out.println(i+" record inserted successfully....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
