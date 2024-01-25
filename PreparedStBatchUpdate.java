import java.sql.*;
import java.util.*;

class PreparedStBatchUpdate
{
    	public static void main(String[] args)
      	{
		
		try
	       	{		  	
	      		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:sydsn");
			String query="insert into account Values(?,?,?,?)";
		
			PreparedStatement ps=con.prepareStatement(query);
		
			con.setAutoCommit(false);
			ps.setInt(1,198);
			ps.setString(2,"John");
			ps.setDouble (3,67890);
			ps.setString(4,"saving");
			ps.addBatch();

			ps.setInt(1,199);
			ps.setString(2,"Joyce");
			ps.setDouble (3,56789);
			ps.setString(4,"saving");
			ps.addBatch();
			
			int[] count = ps.executeBatch();
      			con.commit();			
			ps.close();			
			con.close();
			System.out.println("Done!");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

    		

}

