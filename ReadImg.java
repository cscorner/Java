import java.sql.*;
import java.io.*;
import java.util.Scanner;
class ReadImg
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs","root","cscorner");
			Statement st=con.createStatement();
			System.out.println("Enter rollno:");
			Scanner sc=new Scanner(System.in);
			int roll=sc.nextInt();
			ResultSet rs=st.executeQuery("select photo from studinfo where rollno="+roll);
			byte img[]=new byte[6500];
			while(rs.next() )
			{ 
				img=rs.getBytes("photo");
			}
			FileOutputStream fos = new FileOutputStream("e://"+roll+".jpg");
			fos.write(img);
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 
	} 
}