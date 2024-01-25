import java.sql.*;

public class BatchUpdate
{
	public static void main(String[] args)
      	{	try
	       	{		
 	    		lass.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","cscorner");  
			Statement st = con.createStatement();      
			 con.setAutoCommit(false);
//		      	printRows( st );
  
      			String query="insert into account values(111,'King Khan',25500,'Saving')";
      			st.addBatch(query);
      			query = "insert into account values(112,'Hrithik',55500,'Saving')";
      			st.addBatch(query);
			query ="update account set accname='Queen Khan',balance=60000 where accno=1";
			st.addBatch(query);;

      			int[] count = st.executeBatch();

      			con.commit();


      			st.close();
      			con.close();
   	}
	catch(Exception e)
	{
    
      		e.printStackTrace();
   	} 
	System.out.println("Goodbye!");
	}
}

