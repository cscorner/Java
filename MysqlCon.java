import java.sql.*;  
class MysqlCon
{  
	public static void main(String args[])
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunita","root","cscorner");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from stud");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			con.close();  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}	  
}  