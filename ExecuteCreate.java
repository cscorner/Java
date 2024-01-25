import java.sql.*;
class ExecuteCreate
{
    	public static void main(String[] args)
      	{
		try
	       	{
Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","cscorner");
System.out.println("Connection Created");
Statement st = con.createStatement();
System.out.println("Statement Created");
String query="create table account(accno int,accname varchar(20),balance float,acctype varchar(10))";
   st.execute(query);
System.out.println("Table created");
			st.close();
		con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}		
}

