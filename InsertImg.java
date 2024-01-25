import java.sql.*;  
import java.io.*;
class InsertImg
{  
	public static void main(String args[])
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs","root","cscorner");  
			File f= new File("kisi.jpg");
		      	FileInputStream fis = new FileInputStream(f);
			PreparedStatement ps=con.prepareStatement("insert into studinfo values(?,?,?)");
              		              	ps.setInt(1,301);
                                                  	ps.setString(2,"trishna");
            		              	ps.setBinaryStream(3, fis, (int) f.length());
              		              	ps.executeUpdate();
 			fis.close(); 
	                 		ps.close();
			con.close();
			System.out.println("Record Inserted");
			
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}	  
}  