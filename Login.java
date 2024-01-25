import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField t1;
	JPasswordField pf;
	JButton b;

	public Login()
	{
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		l1=new JLabel("Enter  Name:");
		l2=new JLabel("Enter password:");
		t1=new JTextField(20);
		pf=new JPasswordField(20);

		b=new JButton("Login");
		b.addActionListener(this);
		cp.add(l1);
		cp.add(t1);
		cp.add(l2);
		cp.add(pf);
		cp.add(b);
		
		setSize(300,300);
		setTitle("Login");	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1,s2;
		s1=t1.getText();
		s2=pf.getText();
	     	try
	       	{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:sydsn");
	      		Statement st = con.createStatement();
    ResultSet rs= st.executeQuery("select * from login where uname='"+s1+"' and password='"+s2+"'");
if(rs.next())
	JOptionPane.showMessageDialog(this,"Login success..!!");
else
	JOptionPane.showMessageDialog(this,"Login Failed..!!");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	
	}
	public static void main(String args[])
	{
		 new Login();
	}
}