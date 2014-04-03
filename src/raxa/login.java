import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import java.lang.*;
import sun.jdbc.odbc.*;

public class login extends JFrame implements ActionListener
{
Container c;
JTextField t1;
JPasswordField t2;
JButton b1;
public FlowLayout layout;
        public login()     //constructor
        {
        c=this.getContentPane();
	    layout=new FlowLayout();
        c.setLayout(layout);
       /* Color bgColor= JColorChooser.showDialog(this,"Choose Background Color",getBackground());
        if (bgColor != null)
        c.setBackground(bgColor);*/
        JLabel username=new JLabel("User name");
        t1=new JTextField(10);
        JLabel password=new JLabel("password");
        t2=new JPasswordField(10);
        c.add(username);
        c.add(t1);
        c.add(password);
        c.add(t2);
	    b1=new JButton("OK");
	    b1.addActionListener(this);	
        c.add(b1);
    	setSize(200,200);
        setVisible(true);
        }
	
public static void main(String args[])
    {
	login g=new login();
    }

public void actionPerformed(ActionEvent ae)
        {

         if(ae.getSource()==b1)
          
          {

	    try
	    {
	       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    }
	    catch(Exception e)
	    {
	       System.out.println("db error");
	    }
	}
        Connection con;
        Statement stmt;
        ResultSet rs;
        String s1;
       
        String s=ae.getActionCommand();
        try
        {
		 new JdbcOdbcDriver();
                 con=DriverManager.getConnection("jdbc:odbc:prabu");
                 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 rs=stmt.executeQuery("select * from login");
		         rs.beforeFirst();
                 if(s.equals("OK"))                                                                                    
                 {
                 
                 boolean b=false;
                 String sx,sy;
                 
                 while(rs.next())
                         {

		                 s1=t1.getText();
                         char s2[]=t2.getPassword();
                         sx=rs.getString("username");
                         sy=rs.getString("password");
                         if(sx.equals(s1) && sy.equals(s2))
                                 {
                                    b=true;                                    
				                    setVisible(false);
                              	    JFrame frame = new JFrame("PROBLEM REQUIREMENT");
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame.getContentPane().add(new requirement());
                                    frame.setSize(700,700);
                                    frame.show();     
                                    break;
                                 }
                           }
                 if(!b)
                     {
                         JOptionPane.showMessageDialog(null,"Not found");
                     }
        
                 } //if close
        }
        catch(Exception t)
        {}
      }
        
}       
       

  
         

               




