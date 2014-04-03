import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
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


class class2 extends JFrame 
{
	public int e,f,m,n;
JScrollPane jScrollPane1 = new JScrollPane();
JTable editableTable1; //truth table declaration
public class2() 
{
}
	
	
public class2(int a,int b,int g,int h)  //rows and columns values passed as parameter
{
int x=a;
int y=b;
int val[]=new int[y];
	
	System.out.println("operations"+g+" variables"+h);
try 
{ 
editableTable1= new JTable(x,y); //table declaration


int temp1=0;
if(y==1)                          //number of operation is one
{
	for(int p=0;p<y;p++)
	{
		for(int q=0;q<x;q++)
		{
			
			editableTable1.setValueAt(q,q,p);
			
		}
		
	}
}
if(x>=y)                         //number of operations is equals to  variables
{

for(int j=0;j<x;j++)
	{
		int temp=j;
		for(int k=y-1;k>=0 ;k--)
		{
			val[k]=temp%y;
			temp=temp/y;
			System.out.print(val[k]+"--");
			editableTable1.setValueAt(val[k],j,k); //setting values in the cells
			
		}
		
				}
		
}	
if(g>h)                           //number of operations is less than  variables
{
	for(int r=0;r<x;r++)
	{
		int temp2=r;
		for(int s=y-1;s>=0;s--)
		{
			val[s]=temp2%h;
			temp2=temp2/h;
			System.out.print(val[s]+"--");
			editableTable1.setValueAt(val[s],r,s);
		}
	}
}
if(g<h)                          //number of operations is greater than variables
{
	for(int u=0;u<x;u++)
	{
		int temp3=u;
		for(int v=y-1;v>=0;v--)
		{
			val[v]=temp3%h;
			temp3=temp3/h;
			System.out.print(val[v]+"--");
			editableTable1.setValueAt(val[v],u,v);
		}
	}
}
	 e=x;
     f=y;
     m=g;
     n=h;
	
	



DefaultCellEditor defCellEditor = new DefaultCellEditor(new JTextField());   //placing textfield in cell
defCellEditor.addCellEditorListener(new TableCellListener());
this.getContentPane().setLayout(null);
jScrollPane1.setBounds(new Rectangle(25, 19, 330, 180));
this.getContentPane().add(jScrollPane1, null);
jScrollPane1.getViewport().add(editableTable1, null);
DefaultTableModel tableModel =  new DefaultTableModel();


    

addWindowListener(new WindowAdapter() 
{
public void windowClosing(WindowEvent we) 
{
class4 gf=new class4(e,f,m,n);
              gf.setSize(500,500);
              gf.setVisible(true); 
              
}
});
} catch(Exception e) 
{
System.out.println("Exception in Class1:"+e);
}
}

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


