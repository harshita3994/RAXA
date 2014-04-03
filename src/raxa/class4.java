import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import sun.jdbc.odbc.*;
import java.sql.*;
import java.lang.*;
class class4 extends JFrame 
{
JScrollPane jScrollPane1 = new JScrollPane();
JTable editableTable1;
public int z ,ab,vr,ur;
	 //truth table declaration
public class4() 
{}
public class4(int a,int b,int e,int f)  //rows and columns values passed as parameter
{
	String l[] = new String[10];
	String t[] = new String[20];
	int m,n,i=0;
	int c=0;
		
	
try 
{ 
editableTable1= new JTable(a,b); //table declaration
int cnt=0;
System.out.println("bvhjghjvgfuilg"+b);
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
                 			System.out.println("HI HI HI " +t[i]);
                 			i++;
                 		
                 		}
                 		}catch(Exception e1)
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
                 			l[c] = rs.getString("word1");
                 			System.out.println(l[c]);c++;
                 		}
                 		}catch(Exception e2)
                 		{}
                 		
z=a;
ab=b;
                 		
if(a>b)
{

for(int j=0;j<a;j++)
	{
		int temp=j;
		System.out.println("testcase:"+temp);
		for(int k=b-1;k>=0 ;k--)
		{
			
			editableTable1.getColumnModel().getColumn(k).setHeaderValue(l[k]);
			
			editableTable1.setValueAt(t[temp%b],j,k); //setting values in the cells
			temp=temp/b;
			 
		
	
}	
		System.out.println();
}
}


if(b==1)
{
	System.out.println("hi" + t[0]);
	System.out.println("HI" + t[1]);
	for(int p=0;p<b;p++)
	{
		for(int q=0;q<a;q++)
		{
		int z=q;	
		editableTable1.getColumnModel().getColumn(p).setHeaderValue(l[p]);
			editableTable1.setValueAt(t[z],q,p);
	
			
		}
		
	}
}


if(e>f)
{
	for(int r1=0;r1<a;r1++)
	{
		int temp21=r1;
		for(int s1=b-1;s1>=0;s1--)
		{
		
			
		editableTable1.getColumnModel().getColumn(s1).setHeaderValue(l[s1]);
		
			editableTable1.setValueAt(t[temp21%f],r1,s1);
			temp21=temp21/f;
		
	
		}
	}
}
if(e<f)
{
	for(int u1=0;u1<a;u1++)
	{
		int temp31=u1;
		for(int v1=b-1;v1>=0;v1--)
		{
		
			
		editableTable1.getColumnModel().getColumn(v1).setHeaderValue(l[v1]);
		
			editableTable1.setValueAt(t[temp31%f],u1,v1);
			temp31=temp31/f;
	
	
		}
	}
}
ur=e;
vr=f;



DefaultCellEditor defCellEditor = new DefaultCellEditor(new JTextField()); //placing textfield in cell

defCellEditor.addCellEditorListener(new TableCellListener());
this.getContentPane().setLayout(null);
jScrollPane1.setBounds(new Rectangle(25, 19, 330, 180));
this.getContentPane().add(jScrollPane1, null);
jScrollPane1.getViewport().add(editableTable1, null);


addWindowListener(new WindowAdapter() 
{
public void windowClosing(WindowEvent we) 
{
Test gf=new Test(z,ab,ur,vr);
           
              gf.setVisible(true); 
}});
 
}catch(Exception e1) 
{
System.out.println("Exception in Class1:"+e);
}}
class TableCellListener implements CellEditorListener 
{
public TableCellListener()
{}
public void editingStopped(ChangeEvent e)  
{

DefaultTableModel tableModel = (DefaultTableModel) editableTable1.getModel();//for creating a table without values in the cell
if(editableTable1.getSelectedRow() == tableModel.getRowCount() - 1) 
{
tableModel.setRowCount(tableModel.getRowCount() + 1);
}
}
public void editingCanceled(ChangeEvent e) 
{
}
}

}

