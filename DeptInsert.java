
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeptInsert extends JFrame implements ActionListener
{
  	
	JLabel l1,l2,l3;
	JTextField txt1,txt2,txt3;
	JButton b1,b2;

	
	public DeptInsert()
	{
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(4,2));
		l1=new JLabel("Enter no:");
		txt1=new JTextField(20);
		l2=new JLabel("Enter name:");
		txt2=new JTextField(20);
		l3=new JLabel("Enter location:");
		txt3=new JTextField(20);
		b1=new JButton("Add");
		b2=new JButton("Cleart");
		b1.addActionListener(this);
		b2.addActionListener(this);
		cp.add(l1);
		cp.add(txt1);
		cp.add(l2);
		cp.add(txt2);
		cp.add(l3);
		cp.add(txt3);
		cp.add(b1);
		cp.add(b2);
		
		
		
		setSize(300,300);
		setTitle("Login");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}   
	
	public void actionPerformed(ActionEvent ae) 
	{                                         
		if(ae.getSource()==b1)
		{
			try 
			{
		           	   	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		              		Connection con =DriverManager.getConnection("jdbc:odbc:sydsn");             		
              		              		PreparedStatement ps=con.prepareStatement("insert into dept values(?,?,?)");
              		              		ps.setString(1,txt1.getText());
                                                  		ps.setString(2,txt2.getText());
              		              		ps.setString(3,txt3.getText());
              		              		ps.executeUpdate();
                                                  		JOptionPane.showMessageDialog(this,"Row Inserted Successfully");
              		 		ps.close();
        			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
  		}
		else
		{
		        txt1.setText("");
		        txt2.setText("");
		        txt3.setText("");
    		} 	 
    	}     
	public static void main(String args[]) 
	{
		new DeptInsert();
	}
}
