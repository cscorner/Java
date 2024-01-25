import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs2021","root","cscorner@1234");
			System.out.println("Connection Created....");
			String query="create table student(rollno int,name varchar(30),marks int)";
			Statement st=con.createStatement();
			st.execute(query);
			System.out.println("Table Created....");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
