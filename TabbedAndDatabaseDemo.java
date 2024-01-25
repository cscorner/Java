import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

public class TabbedAndDatabaseDemo extends JFrame
{
    	JTabbedPane tabpane;
     	
    	TabbedAndDatabaseDemo()
      	{
       		tabpane=new JTabbedPane();
        	getContentPane().add(tabpane);
        	tabpane.addTab("Entry of Data",new EntryData());
        	//tabpane.addTab("Records",new Database());       
       		pack();
        	setTitle(" DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] a)
  	{
		new TabbedAndDatabaseDemo();
  	}
}

class EntryData extends JPanel implements ActionListener
{
	JLabel acc_no,acc_bal,acc_type;    
    	JTextField textno, textbal,texttpe;     
    	JTextArea textarea;
    	JButton button,exit,first,next,last,prev,del,upd;
	ResultSet rs;
	Statement st;
	 Connection cn ;
    	EntryData()
      	{
           	setLayout(new GridLayout(7,2));
    	  	acc_no=new JLabel("No.");
		acc_bal=new JLabel("Balance");
		acc_type=new JLabel("Type");

		textno=new JTextField();
		textbal=new JTextField();
		texttpe=new JTextField();

		button = new JButton("submit");
		exit = new JButton("exit");
		first= new JButton("First");
		next= new JButton("next");
		last= new JButton("Last");
		prev= new JButton("Prev");
		del= new JButton("Delete");
		del.addActionListener(this);
		upd= new JButton("Update");
		upd.addActionListener(this);

		button.addActionListener(this);
		exit.addActionListener(this);
		first.addActionListener(this);
		next.addActionListener(this);
		last.addActionListener(this);
		prev.addActionListener(this);

		add(acc_no);
		add(textno);
		add(acc_bal);
		add(textbal);
		add(acc_type);
		add(texttpe);
		add(button);
		add(exit);
		add(first);
		add(next);
		add(last);
		add(prev);
		add(del);
		add(upd);

		try
	      	{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn = DriverManager.getConnection("jdbc:odbc:sydsn");
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * from account");	
		}
	     	catch(Exception ex){System.out.println(ex);}

	 }
	public void actionPerformed(ActionEvent ae)
	{
		String sql="SELECT * from account";
		
	     	try
	      	{
					 if(ae.getSource()==del)
{
	try
	{
									  		
st = cn.createStatement();
String str=JOptionPane.showInputDialog(this,"Enter     accno:");				
int ano=	Integer.parseInt(str);

st.executeUpdate("delete from account 	where accno="+ano);
JOptionPane.showMessageDialog(this,"Record deleted","FriendsDatabase",JOptionPane.ERROR_MESSAGE);
		
	 }
catch(Exception ex) 
{
System.out.println(ex);
}


}
 
		   	
		  	else if(ae.getSource()==button)
	  	    	{
			  		st = cn.createStatement();
	     				int m = st.executeUpdate("insert into account values("+Integer.parseInt(textno.getText())+","+textbal.getText()+",'"+texttpe.getText()+"');");
         				JOptionPane.showMessageDialog(this,"Record Entered","FriendsDatabase",JOptionPane.ERROR_MESSAGE);
			 		textno.setText("");
			 		textbal.setText("");
			 		texttpe.setText("");
	        	}
			else if(ae.getSource()==exit)
				System.exit(0);
			else if(ae.getSource()==first)
			{
				rs.first();
				textno.setText(rs.getString("accno"));
			 	textbal.setText(rs.getString(2));
			 	texttpe.setText(rs.getString(3));
			}
			else if(ae.getSource()==next)
			{
				rs.next();
				textno.setText(rs.getString("accno"));
			 	textbal.setText(rs.getString("balance"));
			 	texttpe.setText(rs.getString("acctype"));
			}
			else if(ae.getSource()==last)
			{
				rs.last();
				textno.setText(rs.getString("accno"));
			 	textbal.setText(rs.getString("balance"));
			 	texttpe.setText(rs.getString("acctype"));
			}
			else if(ae.getSource()==prev)
			{
				rs.previous();
				textno.setText(rs.getString("accno"));
			 	textbal.setText(rs.getString("balance"));
			 	texttpe.setText(rs.getString("acctype"));
			}
	     	 }catch(Exception ex){System.out.println(ex);}
	 }
   }

/*
	 public class Database extends JPanel
  	{
		Database()
     		{
 		  try
	   	{
	    		 textarea=new JTextArea(5,30);
         			add(textarea);
         			String text="";
         			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        			 Connection cn = DriverManager.getConnection("jdbc:odbc:mydsn");
         			Statement st = cn.createStatement();
         			ResultSet rs = st.executeQuery("select * from account");
         			ResultSetMetaData r = rs.getMetaData();
         			int numColumns = r.getColumnCount();
          			 for(int i=1;i<=numColumns;++i)
              			{
 			   	 if(i<numColumns)
 			     	{
				 	  text+=r.getColumnName(i)+"|"+"\t";
			     	}
			   	else
			   	{
			     	text+=r.getColumnName(i);
			  	 }

		     	}
     			 text+="\n";

        		while(rs.next())
          		{
		    	for(int i=1;i<=numColumns;++i)
		     	{
		 	 	 if(i<numColumns)
		  	 	 {
					text+=rs.getString(i)+"\t";
			   	}
			 	 else
			   	{
			   	  text+=rs.getString(i).trim();
			   	  text+="\n";
			   	}
			}
	      	 textarea.setText(text);
	    	 }
      	 }//try
	catch(Exception e){}
     	}//constructor
 	 }//Database

 
*/

