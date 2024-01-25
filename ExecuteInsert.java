import java.sql.*;
class ExecuteInsert
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
			String query="insert into account values(1,'SYCS',25500,'Saving')";
	       		int i=st.executeUpdate(query);

			System.out.println(i+" record(s) inserted successfully");
              		st.close();
			con.close();

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

    		

}

