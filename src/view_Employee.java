import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.css.ViewCSS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
public class view_Employee implements ActionListener
{
//	JFrame frame;
//	JDesktopPane pane;
	JInternalFrame ViewEmployeeFrame;
	JPanel Panel,BPanel;
	JTable Tabel;
	JScrollPane scroll;
	int i;
	ResultSet rs;
	BorderLayout B;
	JButton BDel,BUp;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	public view_Employee() 
	{
//		frame=new JFrame("demo");
//		pane=new JDesktopPane();
		ViewEmployeeFrame =new JInternalFrame("demo");
		Panel=new JPanel();
		BPanel=new JPanel();
		B=new BorderLayout();
		Panel.setLayout(B);
		BDel=new JButton("Delete");
		BUp=new JButton("Update");
		gbc=new GridBagConstraints();
		gbl=new GridBagLayout();
		
		BPanel.setLayout(gbl);
		
		BDel.setMargin(new Insets(10,25,10,25));
		BUp.setMargin(new Insets(10,25,10,25));
		BDel.addActionListener(this);
		BUp.addActionListener(this);
		
		gbc.gridx=0;
		gbc.gridy=0;
		BPanel.add(BDel,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		BPanel.add(BUp,gbc);
		
		Make_tabel();
		Panel.add(BPanel,BorderLayout.SOUTH);
//		pane.setLayout(null);
//		Panel.setLayout(null);
//		scroll.setBounds(0, 0, 800,800);
//		scroll.setPreferredSize(new Dimension(100,100));
//		Panel.add(scroll);	
//		ViewClientFrame.add(Panel);
		ViewEmployeeFrame.add(Panel);
		ViewEmployeeFrame.setLocation(400,100);
		ViewEmployeeFrame.setSize(800,800);
		ViewEmployeeFrame.setResizable(true);
		ViewEmployeeFrame.setMaximizable(true);
		ViewEmployeeFrame.setIconifiable(true);
		ViewEmployeeFrame.setClosable(true);
		ViewEmployeeFrame.setVisible(true);
		ViewEmployeeFrame.setFocusable(true);
		
		
//		pane.add(ViewClientFrame);
//		frame.add(pane);
//		frame.setSize(800, 800);
//		frame.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		
	//		new view_Employee(); 
	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==BDel)
		{
			int row=Tabel.getSelectedRow();
			String str=(String)Tabel.getModel().getValueAt(row,0);
			//System.out.println(str);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("delete from Employee_details where Emp_id="+str);
				int i=ps.executeUpdate();
			}
			catch(Exception ee)
			{
				System.out.println("1 "+ee);
			}
			Make_tabel();
			
		}
		
		if(evt.getSource()==BUp)
		{
			int row=Tabel.getSelectedRow();
			if(row>=0)
			{
				String str=(String)Tabel.getModel().getValueAt(row,0);
				update_Employee obj;
				obj=new update_Employee(str);
				ViewEmployeeFrame.getParent().add(obj.UpdateEmployeeFrame);
				obj.UpdateEmployeeFrame.moveToFront(); 
				ViewEmployeeFrame.dispose();
			}
			
		}
		
		
	}
	
	void Make_tabel()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Employee_details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				i=Integer.parseInt(rs.getString(1));
			}
			Panel.remove(scroll);		
			scroll.remove(Tabel);
			Panel.invalidate();
			ViewEmployeeFrame.invalidate();
		
		}
		catch(Exception ee)
		{
			//System.out.println(ee);
		}
		Tabel =new JTable(i,8);
		Tabel.getTableHeader().setFont(new Font("Tohma",Font.PLAIN,20));
		scroll=new JScrollPane(Tabel);
		
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Employee ID");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Name");
		Tabel.getColumnModel().getColumn(2).setHeaderValue("Address");
		Tabel.getColumnModel().getColumn(3).setHeaderValue("Contact");
		Tabel.getColumnModel().getColumn(4).setHeaderValue("Email");
		Tabel.getColumnModel().getColumn(5).setHeaderValue("Qualification");
		Tabel.getColumnModel().getColumn(6).setHeaderValue("Languages");
		Tabel.getColumnModel().getColumn(7).setHeaderValue("Post");
	
		i=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Emp_id,E_name,E_address,E_phone,E_Email,E_Qualification,E_Language,E_post from Employee_details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Tabel.setValueAt(rs.getString(1).trim(), i, 0);
				Tabel.setValueAt(rs.getString(2).trim(), i, 1);
				Tabel.setValueAt(rs.getString(3).trim(), i, 2);
				Tabel.setValueAt(rs.getString(4).trim(), i, 3);
				Tabel.setValueAt(rs.getString(5).trim(), i, 4);
				Tabel.setValueAt(rs.getString(6).trim(), i, 5);
				Tabel.setValueAt(rs.getString(7).trim(), i, 6);
				Tabel.setValueAt(rs.getString(8).trim(), i, 7);
				i++;
			}
		
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		Panel.add(scroll, BorderLayout.CENTER);
		Panel.setVisible(false);
		Panel.setVisible(true);
		ViewEmployeeFrame.setVisible(false);
		ViewEmployeeFrame.setVisible(true);
	}

}
