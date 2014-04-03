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

public class requirement extends JFrame implements ActionListener
{
   public int row1, column1;
   public int i=0,j=0;

	Container c;
	JTextField t1;
    JButton b1,b2;
    JLabel un;
   public requirement()
   {
        c = this.getContentPane();
        c.setLayout(new FlowLayout());
         JPanel ContentPane;
	    JPanel p1=new JPanel();
      
	    p1.setLayout(new FlowLayout());
        un=new JLabel("Enter the specification statement");
	    t1=new JTextField(40);
        b1=new JButton("submit");
        b2=new JButton("ok");
        p1.add(un);
        p1.add(t1);
        p1.add(b1);
	    p1.add(b2);
	    b1.addActionListener(this);
        b2.addActionListener(this);
	    b2.setVisible(false);
	    c.add(p1);
	    setLocation(200,200);
        setSize(800,300);
	    setVisible(true);
        show();
    }
    public static void main(String args[])
    {
        requirement g=new requirement();
        g.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s,z,val,f,s1,sx;
        Connection con,con1,con2,con3,con4,con5,con6,con7,con8,con9,con10,con11,con12; //connection object
        Statement stmt,stmt1,stmt2,stmt3,stmt4,stmt5,stmt6,stmt7,stmt8,stmt9,stmt10,stmt11,stmt12; //statement execution
        ResultSet rs,rs1,rs2; //storing the output of the query
	    z=e.getActionCommand();
	    s=e.getActionCommand();
	    if(z.equals("submit"))
         {
		
		       try{
									
						new JdbcOdbcDriver(); //driver initialization
                        con12=DriverManager.getConnection("jdbc:odbc:prabu");
                        stmt12=con12.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						stmt12.executeQuery("CREATE TABLE matrix(row NUMBER PRIMARY KEY)");
				  }catch(Exception e1)
						{}	
		
				try
				{
				
				
					new JdbcOdbcDriver();
                    con2=DriverManager.getConnection("jdbc:odbc:prabu");
                    stmt2=con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					stmt2.executeQuery("drop table temp");
				}
				catch(Exception h)
					{}
				try{
					
					new JdbcOdbcDriver();
					con6=DriverManager.getConnection("jdbc:odbc:prabu");
					stmt6=con6.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					stmt6.executeQuery("drop table oper");
					}
				
				catch(Exception ee)
				{}
				try{
					new JdbcOdbcDriver();
					con10=DriverManager.getConnection("jdbc:odbc:prabu");
					stmt10=con10.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					stmt10.executeQuery("drop table tempvar");
					}
				
				catch(Exception eee)
				{}
        		s=t1.getText();
        		StringTokenizer st=new StringTokenizer(s," , . ;"); //seperating words from specification
        		 
         		while(st.hasMoreTokens())
                {
                	val=st.nextToken();
	                System.out.println(val);
	
					try
                      {
                        
                         new JdbcOdbcDriver();
                         con3=DriverManager.getConnection("jdbc:odbc:prabu","","");
                         stmt3=con3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					     stmt3.executeQuery("CREATE TABLE temp(word CHAR(100))");
				
                      }
                      catch(Exception l)
                          {}

                      try
                         {
                        
                                 new JdbcOdbcDriver();
                                 con1=DriverManager.getConnection("jdbc:odbc:prabu");
                                 stmt=con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 				 stmt.executeUpdate("INSERT INTO temp VALUES('"+val+"')");
                                 
                          }
                          catch(Exception l)
                          {}
                		try
                		 {
                		new JdbcOdbcDriver();
                 	    con=DriverManager.getConnection("jdbc:odbc:prabu");
                 	    stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 	    rs=stmt1.executeQuery("select * from operations");
                 		rs.beforeFirst();
                 

                     if(z.equals("submit"))
                 	{
	                 
                 		 boolean b=false;
		                 String sx1,sy;
		                 
                 
                 		while(rs.next())
                         {

		       
                         		sx1=rs.getString("operations");
	                 if(sx1.equals(val))
					
						    {
                                b=true;
			                    try{
								
										new JdbcOdbcDriver();
                                 		con4=DriverManager.getConnection("jdbc:odbc:prabu");
                                 		stmt4=con4.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
										stmt4.executeQuery("CREATE TABLE oper(word CHAR(100), constraint wrd PRIMARY KEY (word))");
									 }
								catch(Exception e1)
										{}
			
								try{
										new JdbcOdbcDriver();
										con5=DriverManager.getConnection("jdbc:odbc:prabu");
										stmt5=con5.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					 					stmt5.executeUpdate("INSERT  INTO oper VALUES('"+val+"')");
					 					j++;
					 				}
					 				catch(Exception e2)
					 				{}
							}
						}
					}
						}
                 	catch(Exception g)
                 	{}
                 	
                		try{
                		
                		new JdbcOdbcDriver();
                 	    con7=DriverManager.getConnection("jdbc:odbc:prabu");
                 	    stmt7=con7.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 	    rs1=stmt7.executeQuery("select * from variables");
                 		rs1.beforeFirst();
                 
		 		
	                 if(z.equals("submit"))
                 	{
	                        
                 		 boolean b=false;
		                 String sx1,sy;
		               
                 	
                 		while(rs1.next())
                         {

		                   
                         	 sy=rs1.getString("variables");
	                         if(sy.equals(val))
					
							{
                                    b=true;
									
								try{
									
										new JdbcOdbcDriver();
                                 		con8=DriverManager.getConnection("jdbc:odbc:prabu");
                                 		stmt8=con8.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
										stmt8.executeQuery("CREATE TABLE tempvar(word1 CHAR(100) PRIMARY KEY)");
									 }catch(Exception e1)
										{}
			
								try{
										new JdbcOdbcDriver();
										con9=DriverManager.getConnection("jdbc:odbc:prabu");
										stmt9=con9.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					 					stmt9.executeUpdate("INSERT  INTO tempvar VALUES('"+val+"')");
					 					i++;
					 				
					 				}
					 				catch(Exception e2)
					 				{}
					 		
					 			
					 				
					 				
					 		}
						}
						
					}
						}
                 	catch(Exception h)
                 	{System.out.println("-->"+i+""+j);} 
                 	
	
			}
			System.out.println("the number operations:"+j); //The operations list is stored
			System.out.println("the number variables:"+i); //The variable list
			
		 	 column1 = (int)i;
		     row1 =(int) Math.pow(i,j); //Runs combinations generated
		    if(i==1)
		    {
		    column1=(int)i;
		    row1=(int) Math.pow(j,i);
		    }
		  else if(i==j)
		    {
		    	column1=(int)i;
		    	row1=(int)i*j;
		    }
		    else if(i>=4 || j>=4)
		    {
		    	column1=(int)i;
		    	row1=(int)j*i;
		    }
		    else if(i>j)
		    {
		    	column1=(int)i;
		    row1=(int) Math.pow(j,i);
		    }
		    else if(i<j)
		    {
		    	column1=(int)i;
		    row1=(int) Math.pow(j,i);
		    }
		 	 System.out.println(row1);	
			 System.out.println(column1);
			 
			 
			 
			                 setVisible(false);
			                 
                             window g = new window(row1, column1,i,j);
                             
                             g.setVisible(true);
                             g.setSize(500,500);
                              	    
       
	}
	}
	}
	
