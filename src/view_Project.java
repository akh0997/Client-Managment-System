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
public class view_Project implements ActionListener
{
//	JFrame frame;
//	JDesktopPane pane;
	JInternalFrame ViewProjectFrame;
	JPanel Panel,BPanel;
	JTable Tabel;
	JScrollPane scroll;
	int i;
	ResultSet rs;
	BorderLayout B;
	JButton BDel,BUp;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	public view_Project() 
	{
//		frame=new JFrame("demo");
//		pane=new JDesktopPane();
		ViewProjectFrame =new JInternalFrame("demo");
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
		ViewProjectFrame.add(Panel);
		ViewProjectFrame.setLocation(400,100);
		ViewProjectFrame.setSize(800,800);
		ViewProjectFrame.setResizable(true);
		ViewProjectFrame.setMaximizable(true);
		ViewProjectFrame.setIconifiable(true);
		ViewProjectFrame.setClosable(true);
		ViewProjectFrame.setVisible(true);
		ViewProjectFrame.setFocusable(true);
		
		
//		pane.add(ViewClientFrame);
//		frame.add(pane);
//		frame.setSize(800, 800);
//		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//new view_Project() ;

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
				PreparedStatement ps=conn.prepareStatement("delete from Project_details where Project_id="+str);
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
				update_Project obj;
				obj=new update_Project(str);
				ViewProjectFrame.getParent().add(obj.UpdateProjectFrame);
				obj.UpdateProjectFrame.setVisible(true);
				obj.UpdateProjectFrame.moveToFront();
				ViewProjectFrame.dispose();
			}
			
		}
		
	}
	
	
	void Make_tabel()
	{
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Project_details");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				i=Integer.parseInt(rs.getString(1));
			}
			
			Panel.remove(scroll);		
			
			scroll.remove(Tabel);
		
			Panel.invalidate();
		
			ViewProjectFrame.invalidate();
		
		
		}
		catch(Exception ee)
		{
			//System.out.println(ee);
		}
		Tabel =new JTable(i,9);
		Tabel.getTableHeader().setFont(new Font("Tohma",Font.PLAIN,20));
		scroll=new JScrollPane(Tabel);
		
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Project ID");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Project Titel");
		Tabel.getColumnModel().getColumn(2).setHeaderValue("Language");
		Tabel.getColumnModel().getColumn(3).setHeaderValue("Duration");
		Tabel.getColumnModel().getColumn(4).setHeaderValue("Date");
		Tabel.getColumnModel().getColumn(5).setHeaderValue("Client");
		Tabel.getColumnModel().getColumn(6).setHeaderValue("Cost");
		Tabel.getColumnModel().getColumn(7).setHeaderValue("Discription");
		Tabel.getColumnModel().getColumn(8).setHeaderValue("Status");
		
		i=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Project_id,P_titel,P_language,P_duration,P_Date,P_client,p_cost,P_discription ,Progress from Project_details");
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
				Tabel.setValueAt(rs.getString(9).trim(), i, 8);
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
		ViewProjectFrame.setVisible(false);
		ViewProjectFrame.setVisible(true);
	}

}
