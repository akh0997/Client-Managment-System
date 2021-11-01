import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
public class Payment_details implements ItemListener,ActionListener
{
	
	JInternalFrame paymentDetailsFrame;
	JPanel Panel,mainpanel,Framepanel,buttonPanel,tablepanel;
	JTable Tabel;
	JScrollPane scroll;
	JLabel ClientLabel,ProjectLabel;
	JComboBox CBclient,CBproject;
	JButton Search,GenInvoice;
	GridBagConstraints gbc;
	GridBagLayout gbl;
	BorderLayout b1,b2;
	JFrame frame;
	GridLayout gl;
	JDesktopPane pane;
	ResultSet rs;
	JButton[] buttons;
	ArrayList<String> data;
	
	public Payment_details()
	{
//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		
		paymentDetailsFrame=new JInternalFrame("demo");
		Framepanel=new JPanel();
		buttonPanel=new JPanel();
		Panel=new JPanel();
		mainpanel=new JPanel();
		tablepanel=new JPanel();
		data=new ArrayList<String>();
		CBclient=new JComboBox();
		CBproject=new JComboBox();
	
		Search=new JButton("Search");
		GenInvoice=new JButton("Generate Invoice");
		gbc=new GridBagConstraints();
		gbl=new GridBagLayout();
		b1=new BorderLayout();
		b2=new BorderLayout();
		ClientLabel=new JLabel("Client :");
		ProjectLabel=new JLabel("Project :");
		gl=new GridLayout(2,1);
		
		ClientLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		ProjectLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		CBclient.setFont(new Font("Tohoma",Font.PLAIN,20));
		CBproject.setFont(new Font("Tohoma",Font.PLAIN,20));
		Search.setFont(new Font("Tohoma",Font.PLAIN,20));
		GenInvoice.setFont(new Font("Tohoma",Font.PLAIN,20));
		CBclient.addItem("--Select--");
		CBproject.addItem("--Select--");

		GenInvoice.setSize(200, 40);
		Framepanel.setLayout(b2);
		mainpanel.setLayout(gl);
		CBclient.addItemListener( this);
	//	CBproject.addItemListener(this);
		Search.addActionListener(this);
		GenInvoice.addActionListener(this);
		Panel.setLayout(gbl);
		tablepanel.setLayout(b1);
		
		
		gbc.gridx=200;
		gbc.insets=new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(ClientLabel, gbc);
		Panel.add(ClientLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(CBclient, gbc);
		Panel.add(CBclient);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(ProjectLabel, gbc);
		Panel.add(ProjectLabel);
		
		gbc.gridx=3;
		gbc.gridy=0;
		gbl.setConstraints(CBproject, gbc);
		Panel.add(CBproject);
		
		gbc.gridx=4;
		gbc.gridy=0;
		gbl.setConstraints(Search, gbc);
		Panel.add(Search);
		
		
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("Select Client_Id from client_details");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CBclient.addItem(rs.getString(1).trim());
			}
			
		}
		catch (Exception e) {
			
		}
		CBclient.setSelectedIndex(0);
		buttonPanel.add(GenInvoice);
		mainpanel.add(Panel);
		mainpanel.add(tablepanel);
		
		Framepanel.add(mainpanel,BorderLayout.CENTER);
		Framepanel.add(buttonPanel,BorderLayout.SOUTH);
		paymentDetailsFrame.add(Framepanel);
		
		paymentDetailsFrame.setLocation(0,0);
		paymentDetailsFrame.setSize(800,800);
		paymentDetailsFrame.setResizable(true);
		paymentDetailsFrame.setMaximizable(true);
	paymentDetailsFrame.setIconifiable(true);
		paymentDetailsFrame.setClosable(true);
		paymentDetailsFrame.setVisible(true);
		
//		pane.setLayout(null);
//		pane.add(paymentDetailsFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);	
		
		
	}

	public static void main(String[] args) 
	{
//			new Payment_details();
	}

	public void itemStateChanged(ItemEvent item)
	{
		if(item.getStateChange()==ItemEvent.SELECTED)
		{
			String cid=(String)item.getItem();
			
				CBproject.removeAllItems();
				CBproject.insertItemAt("--Select--",CBproject.getItemCount());
				CBproject.enable();
		
				if(CBclient.getSelectedIndex()>0)
				{
					int i=CBclient.getSelectedIndex();
				
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("select Project_id  from Project_details where P_client="+cid);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							CBproject.insertItemAt(rs.getString(1),CBproject.getItemCount());
						}
					
						
					} 
					catch (Exception e) 
					{
					
					}
					CBproject.setSelectedIndex(0);	
				}
				else
				{
					CBproject.insertItemAt("--Select--",CBproject.getItemCount());
					CBproject.setSelectedIndex(0);	
					CBproject.disable();
				}
				
			
		}
		
	}

	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==Search)
		{
			if(CBclient.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(paymentDetailsFrame, "Please select a client!!!!!");
			}
			else
			{
				if(CBclient.getSelectedIndex()!=0)
				{
					Make_tabel();
				}
			}
		}
		else if(evt.getSource()==GenInvoice)
		{
			int row=Tabel.getSelectedRow();
			if(row>=0)
			{
				String Cid=(String)CBclient.getSelectedItem();
				String invoice =data.get(row);
				
				
				Payment_recipte obj;
				obj=new Payment_recipte(Cid,invoice);
				
				paymentDetailsFrame.getParent().add(obj.ReciptFrame);
				obj.ReciptFrame.moveToFront();
				
			}
		}
		
	}
	
	
	void Make_tabel()
	{
		int i=0;
		String cid=(String)CBclient.getSelectedItem();
		String Query="";
		if(CBproject.getSelectedIndex()!=0)
		{
			Query=" and ProjectId="+(String)CBproject.getSelectedItem();
		}
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Billing_details where ClientID="+cid+""+Query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				i=Integer.parseInt(rs.getString(1));
			}
			tablepanel.remove(scroll);		
			scroll.remove(Tabel);
			tablepanel.invalidate();
			paymentDetailsFrame.invalidate();
		
		}
		catch(Exception ee)
		{
			//System.out.println(ee);
		}
		Tabel =new JTable(i,6);
		Tabel.getTableHeader().setFont(new Font("Tohma",Font.PLAIN,20));
		scroll=new JScrollPane(Tabel);
		
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Project ID");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Project Titel");
		Tabel.getColumnModel().getColumn(2).setHeaderValue("Date");
		Tabel.getColumnModel().getColumn(3).setHeaderValue("Total Cost");
		Tabel.getColumnModel().getColumn(4).setHeaderValue("Paid Amount");
		Tabel.getColumnModel().getColumn(5).setHeaderValue("Balance");
		
	
		i=0;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
		
		//	PreparedStatement ps=conn.prepareStatement("select * from Billing_details where ClientID="+cid+""+Query);
			
			
		//	 select b.ProjectId,a.p_titel,b.Billdate,b.TotalCost,b.Paid,b.Balance from(select * from Billing_details where ClientID=1018)b join Project_details a on a.Project_id=b.ProjectId
			PreparedStatement ps=conn.prepareStatement("select b.InvoiceID,b.ProjectId,a.p_titel,b.Billdate,b.TotalCost,b.Paid,b.Balance from(select * from Billing_details where ClientID="+cid+""+Query+")b join Project_details a on a.Project_id=b.ProjectId");
			
			rs=ps.executeQuery();
			while(rs.next())
			{
			
				data.add(rs.getString(1).trim());	
				Tabel.setValueAt(rs.getString(2).trim(), i, 0);
				Tabel.setValueAt(rs.getString(3).trim(), i, 1);
				
				String str[]=rs.getString(4).substring(0,10).split("-");
				String str1="";
				for(int k=str.length-1;k>=0;k--)
				{
					if(k>0)
					{
						str1=str1+str[k]+"-";
					}
					else
					{
						str1=str1+str[k];
					}
				}
				
			//	Tabel.setValueAt(rs.getString(3).trim(), i, 2);
				Tabel.setValueAt(str1, i, 2);
				Tabel.setValueAt(rs.getString(5).trim(), i, 3);
				Tabel.setValueAt(rs.getString(6).trim(), i, 4);
				Tabel.setValueAt(rs.getString(7).trim(), i, 5);
				
			
				i++;
			}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}

		tablepanel.add(scroll, BorderLayout.CENTER);
		tablepanel.setVisible(false);
		tablepanel.setVisible(true);
		paymentDetailsFrame.setVisible(false);
		paymentDetailsFrame.setVisible(true);
	}



}
