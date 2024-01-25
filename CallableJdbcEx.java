import java.sql.*;
class CallableJdbcEx
{
public static void main(String[] args)
{
try
{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sycs2021","root","cscorner@1234");  
Statement st=con.createStatement();
String query="create procedure proc2() begin select * from student; end";
st.executeUpdate(query);
CallableStatement cs = con.prepareCall("{call proc2}");
ResultSet rs=cs.executeQuery();
while(rs.next())
{
	System.out.println("No:"+rs.getString(1)+"\nName:"+rs.getString(2)+"\nMarks:"+rs.getString("marks"));
}
con.close();
}
catch(Exception e)
{
System.out.println(e);
e.printStackTrace();
}
}
}