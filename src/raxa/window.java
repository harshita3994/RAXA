import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet.*;
import java.lang.*;
import sun.jdbc.odbc.*;
import java.lang.*;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class window extends JFrame implements ActionListener
{
   public int row1, column1,i,j;
  
   public int a,b,e,f,g1,h;
   
	Container c;
	JTextField t1;
    JButton b1,b2;
    JLabel un,l1,l2;
    JTextArea t3,t4;
   public window(int row1, int column1,int i, int j)
   {

a=row1;
b=column1;
g1=i;
h=j;
        c = this.getContentPane();     //get the container object
        c.setLayout(new FlowLayout());  //seting layout
        JPanel ContentPane;             //declaring contentpane
	    JPanel p2=new JPanel();
	    p2.setLayout(new FlowLayout());
	   
        un=new JLabel("z notation window");
	    
        b1=new JButton("submit");
        p2.add(un);
        
        p2.add(b1);	    
	    b1.addActionListener(this);
        
	    l1=new JLabel("operations");
	    p2.add(l1);
	    t3=new JTextArea(10,15);
	    p2.add(new JScrollPane(t3));  //the panel is automatically scrollable
		l2=new JLabel("variables");
		p2.add(l2);
		t4=new JTextArea(10,15);
		p2.add(new JScrollPane(t4));
	    c.add(p2);
	     
	    setLocation(200,200);
        setSize(500,500);
	    setVisible(true);
        show();
        addWindowListener(new WindowAdapter() 
{
public void windowClosing(WindowEvent we) 
{
	
class2 g=new class2(a,b,g1,h);
              g.setSize(500,500);
              g.setVisible(true);
              
              
}
});
    }
   
    public void actionPerformed(ActionEvent ae)
    {
    	{
           if(ae.getSource()==b1)
           {

	    try
	    {
	       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    //database exception handling
	    }
	    catch(Exception e)
	    {
	       System.out.println("db error");
	    }
	}
        Connection con,con1; //connection establishment
        Statement stmt,stmt1;    //statement execution 
        ResultSet rs,rs1;    //storing the result of query
        String s1,s2;
        String s=ae.getActionCommand();
        try
        {
		         new JdbcOdbcDriver();
                 con=DriverManager.getConnection("jdbc:odbc:prabu");//driver connection
                 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//scrollable values should be sensitive and updatable
                 rs=stmt.executeQuery("select * from oper");
		         rs.beforeFirst(); //moving the pointer to starting position
		         if(s.equals("submit"))
		         {
		         boolean b=false;
                 String sx,sy,temp21="";
                 System.out.println("operations:"+"\n");
                 while(rs.next())
                         {
                        b=true;
		                sx=rs.getString("word");
		                temp21=sx+"\n"+temp21;
		                
		                 } 
         			System.out.println(temp21);
                    t3.setText(temp21); 
                    t3.setEditable(false);
                 }
                         
         } catch(Exception e)
              {}
        try
        {
		         new JdbcOdbcDriver();
                 con1=DriverManager.getConnection("jdbc:odbc:prabu");
                 stmt1=con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 rs1=stmt1.executeQuery("select * from tempvar");
		         rs1.beforeFirst();
		         if(s.equals("submit"))
		         {
		         boolean b1=false;
                 String sx,sy,temp22="";
                 System.out.println("variables:"+"\n");
                 while(rs1.next())
                         {
                           b1=true;
		                   sy=rs1.getString("word1");
		                   temp22=sy+"\n"+temp22;
		                   
		                 } 
         			System.out.println(temp22);
                    t4.setText(temp22); 
                    t4.setEditable(false);
         }
                         
         } catch(Exception e)
              {}      
              }
           
            }       
        }