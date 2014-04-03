import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;
import java.io.*;
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
public class Test extends JFrame 
{
	Container c;

    JTextArea t1;
    JLabel un,l1,l2;

public Test(int a,int b,int ur1,int vr1)
{

    c = this.getContentPane();     //get the container object
        c.setLayout(new FlowLayout());  //seting layout
        JPanel ContentPane;             //declaring contentpane
	    JPanel p1=new JPanel();
	    p1.setLayout(new FlowLayout());
	     un=new JLabel("test case window");
	      p1.add(un);
	    t1=new JTextArea(40,40);
	    p1.add(new JScrollPane(t1));
	    c.add(p1);
	    setLocation(200,200);
       
	    setVisible(true);
        show();
        
    String l[] = new String[10];
	String t[] = new String[10];
	int m,n,i=0,e1;
	int cd=ur1;
	int df=vr1;
	int c=0;
	String temp1="";
	String temp2="";
	String temp3="";
	String temp4="";
	String temp6="";
	String temp7="";
	String temp8="";
	String temp9="";
	String temp11="";
	String temp12="";
	String temp13="";
	String temp14="";
	String temp15="";
	String temp16="";
	String temp17="";
	String temp18="";
	
	
	
	
try 
{ 

int cnt=0,e;
FileWriter v=new FileWriter("c:/testcase.txt");

System.out.println("ur:"+cd+"\n"+"vr"+df);
 Connection con; //connection object
        Statement stmt; //statement execution
        ResultSet rs; //storing the output of the query

	try
                		 {
                		new JdbcOdbcDriver();
                 	    con=DriverManager.getConnection("jdbc:odbc:prabu");
                 	    stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 	    rs=stmt.executeQuery("select * from oper");
                 		rs.beforeFirst();
                 		while (rs.next())
                 		{
                 			t[i] = rs.getString("word");
                 			System.out.println("oper " +t[i]);
                 			i++;
                 		
                 		}
                 		}catch(Exception e3)
                 		{}
                 		try
                		 {
                		new JdbcOdbcDriver();
                 	    con=DriverManager.getConnection("jdbc:odbc:prabu");
                 	    stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 	    rs=stmt.executeQuery("select * from tempvar");
                 		rs.beforeFirst();
                 		while (rs.next())
                 		{
                 			l[c] = (rs.getString("word1")).trim();
                 			System.out.println("ver"+l[c]);c++;
                 			
                 		}
                 		}catch(Exception e2)
                 		{}
                 		
                 		
if(b==1)
{
	
	for(int p=0;p<a;p++)
	{
		System.out.println("test case   "+p+"  :  ");
		
		
		for(int q=0;q<b;q++)
		{
		int z=p;	

		
    	temp3="test case   "+p+"  :  "+"     The      " +l[q]+"     should be    "+t[z]+"\n";
			
			temp4=temp3+"\n"+temp4;
			System.out.println(z);
			
		   
		    e=temp3.length();
		    char buffer[] = new char[e];
		    temp3.getChars(0,temp3.length(),buffer,0);
		    for(int w=0;w<buffer.length;w++)
		    {
		    	v.write(buffer[w]);
		    }
		    
		    
		   System.out.println( "    The      " +l[q]+"     should be    "+t[z]);
		    
			t1.setText(temp4);	    
			t1.setEditable(false);
		   
			
			temp3="";
		}
		System.out.println();
		temp3="";
		
	}
	 v.close();
}
      
      
  
   if(cd>df)      
  {
  	for(int m1=0;m1<a;m1++)
  	{
  			
  			System.out.println("test case   "+m1+" : ");
  		int temp5=m1;
  		for(int n1=b-1;n1>=0;n1--)
  		{
  			temp6="  test case "+m1+"  :  "+"     The      " +l[n1]+"     should be    "+t[temp5%df]+"\n";
			temp5=temp5/df;
			temp7=temp6+"\n"+temp7;
			System.out.println( "   The      " +l[n1]+"     should be    "+t[temp5%df]);
				t1.setText(temp7);	    
			t1.setEditable(false);	
  		}
  		System.out.println();
  		}
  }
   if(cd<df)      
  {
  	for(int ab=0;ab<a;ab++)
  	{
  			
  		System.out.println("test case   "+ab+" : ");
  		int temp10=ab;
  		for(int bc=b-1;bc>=0;bc--)
  		{
  			temp8="  test case "+ab+"  :  "+"     The      " +l[bc]+"     should be    "+t[temp10%df]+"\n";
			temp10=temp10/df;
			temp9=temp8+"\n"+temp9;
			System.out.println( "    The      " +l[bc]+"     should be    "+t[temp10%df]);
				t1.setText(temp9);	    
			t1.setEditable(false);	
  		}
  		System.out.println();
  		}
  }
  else
      {
      
                 		
    for(int j=0;j<a;j++)
	{
			
		System.out.println("test case   "+j+" : ");
			int temp=j;
	
		for(int k=b-1;k>=0;k--)
		{
		
			temp1="  test case "+j+"  :  "+"     The      " +l[k]+"     should be    "+t[temp%b]+"\n";
			temp=temp/b;
			temp2=temp1+"\n"+temp2;
			System.out.println("    The      " +l[k]+"     should be    "+t[temp%b]);
		   
		    e1=temp1.length();
		    char buffer[] = new char[e1];
		    temp1.getChars(0,temp1.length(),buffer,0);
		    for(int u=0;u<buffer.length;u++)
		    {
		    	v.write(buffer[u]);
		    	v.write("\n");
		    }
		   
			t1.setText(temp2);	    
			t1.setEditable(false);
		    temp1="";
				
}	
		System.out.println();
		temp1="";
}
 v.close();
}        
}catch(Exception e43){}

}
}