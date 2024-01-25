import java.sql.*;
import java.util.*;
class ExecuteUpdate
{
    	public static void main(String[] args)
      	{	try
	       	{		  	    		
Class.forName("com.mysql.jdbc.Driver");
	      		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","cscorner");
Statement st = con.createStatement();
System.out.println("Enter account no:");
Scanner sc= new Scanner(System.in);  	    
int no=sc.nextInt();
String query="update account set accname='smith',balance=60000 where accno="+no;
 int i=st.executeUpdate(query);
System.out.println(i+" record(s) updated successfully");
 st.close();
con.close();
	}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}

