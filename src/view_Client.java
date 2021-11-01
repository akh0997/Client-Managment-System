import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
public class view_Client implements ActionListener
{
//	JFrame frame;
//	JDesktopPane pane;
	JInternalFrame ViewClientFrame;
	JPanel Panel,BPanel;
	JTable Tabel;
	JScrollPane scroll;
	
	ResultSet rs;
	
	int i;
	BorderLayout B;
	JButton BDel,BUp;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	public view_Client()
	{
//		frame=new JFrame("demo");
//		pane=new JDesktopPane();
		ViewClientFrame =new JInternalFrame("demo");
		Panel=new JPanel();
		BPanel=new JPanel();
		i=0;
		B=new BorderLayout();
		Panel.setLayout(B);
		BDel=new JButton("Delete");
		BUp=new JButton("Update");
		gbc=new GridBagConstraints();
		gbl=new GridBagLayout();
		//
		
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
		ViewClientFrame.add(Panel);
		ViewClientFrame.setLocation(400,100);
		ViewClientFrame.setSize(800,800);
		ViewClientFrame.setResizable(true);
		ViewClientFrame.setMaximizable(true);
		ViewClientFrame.setIconifiable(true);
		ViewClientFrame.setClosable(true);
		ViewClientFrame.setVisible(true);
		ViewClientFrame.setFocusable(true);

		
//		pane.add(ViewClientFrame);
//		frame.add(pane);
//		frame.setSize(800, 800);
//		frame.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		
		
	}

	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==BDel)
		{
			int row=Tabel.getSelectedRow();
			String str=(String)Tabel.getModel().getValueAt(row,0);
			//System.out.println(str);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("delete from Client_details where Client_Id="+str);
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
				update_Client	obj;
				obj=new update_Client(str);
				ViewClientFrame.getParent().add(obj.UpdateClientFrame);
				obj.UpdateClientFrame.setVisible(true);
				obj.UpdateClientFrame.moveToFront();
				ViewClientFrame.dispose();
			}
		}	
	}
	void Make_tabel()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Client_details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				i=Integer.parseInt(rs.getString(1));
			}

			Panel.remove(scroll);		
			scroll.remove(Tabel);
			Panel.invalidate();
			ViewClientFrame.invalidate();
		}
		catch(Exception ee)
		{
			//System.out.println("2 "+ee);
		}
		Tabel =new JTable(i,5);
		
		scroll=new JScrollPane(Tabel);
		Tabel.getTableHeader().setFont(new Font("Tohma",Font.PLAIN,20));
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Client ID");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Name");
		Tabel.getColumnModel().getColumn(2).setHeaderValue("Address");
		Tabel.getColumnModel().getColumn(3).setHeaderValue("Contact");
		Tabel.getColumnModel().getColumn(4).setHeaderValue("Email");
		i=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Client_Id,Name,Client_Address,Phone,Email from Client_details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				Tabel.setValueAt(rs.getString(1).trim(), i, 0);
				Tabel.setValueAt(rs.getString(2).trim(), i, 1);
				Tabel.setValueAt(rs.getString(3).trim(), i, 2);
				Tabel.setValueAt(rs.getString(4).trim(), i, 3);
				Tabel.setValueAt(rs.getString(5).trim(), i, 4);
				i++;
			}

		}
		catch(Exception ee)
		{

			System.out.println("3 "+ee);
		}	
		Panel.add(scroll, BorderLayout.CENTER);
		Panel.setVisible(false);
		Panel.setVisible(true);
		ViewClientFrame.setVisible(false);
		ViewClientFrame.setVisible(true);
	}
}
