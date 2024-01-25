import java.sql.*;
import java.util.*;
class ExecuteQuery
{
    	public static void main(String[] args)
      	{
	     	try
	       	{
System.out.println("Enter name of table:");
Scanner sc= new Scanner(System.in);  	         		String tbl = sc.nextLine();      		Class.forName("com.mysql.jdbc.Driver");
	      		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","cscorner");
	      		Statement st = con.createStatement();
    ResultSet rs= st.executeQuery("select * from "+tbl);
            ResultSetMetaData md = rs.getMetaData();
	int col=md.getColumnCount();
	String str="";
			for(int i=1;i<=col;i++)
			{
				str+=md.getColumnName(i)+"   ";	
			}
   	        	
	 		str+="\n";	
		 	
			while(rs.next())
		 	{
				for(int i=1;i<=col;i++)
				{
					str+=rs.getString(i)+"\t";	
				}
				str+="\n";	
				
			}
			System.out.println(str);

		}
		catch(Exception ex){}

	  }

    	

}

