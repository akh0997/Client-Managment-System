import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
public class Billing implements ActionListener ,ItemListener{
	JInternalFrame BillingFrame;
	JPanel panel,mainpanel,toppanel,bottompanel;
	JLabel ClientLabel,ProjectLabel,CostLabel,PaidLabel,DueLabel;
	JComboBox CBclient,CBproject;
	JTextField cost;

	JLabel HeadingLabel;
	
	ImageIcon ClientIcon,ProjectIcon,CostIcon,BalanceIcon,PaidIcon;
	Image clientimg,projectimg,costimg,balanceimg,paidimg;
	JLabel clientlabelicon,projectlabelicon,costlabelicon,balancelabelicon,paidlabelicon;
	
	JScrollPane scroll;
	JTextField paid,Due;

	BorderLayout b1;
	JButton submit;
	JButton reset;
	GridBagLayout gbl;
	GridBagConstraints gbc;

	JFrame frame;
	JDesktopPane pane;
	ArrayList<String> data;
	
	public Billing() 
	{
//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		
		BillingFrame =new JInternalFrame("demo");
		panel=new JPanel();
		mainpanel=new JPanel();
		toppanel=new JPanel();
		bottompanel=new JPanel();
		
		mainpanel.setBorder(new EmptyBorder(80,80,80,80));
		b1=new BorderLayout();
		mainpanel.setLayout(b1);
		data=new ArrayList<String>();
		
		CBclient=new JComboBox();
		CBproject=new JComboBox();
		cost=new JTextField(15);
		paid=new JTextField(15);
		Due=new JTextField(15);
	
		submit=new JButton("Submit");
		reset=new JButton("Reset");
	
		submit.addActionListener(this);
		reset.addActionListener(this);
		
		ClientLabel=new JLabel("Client :");
		ProjectLabel=new JLabel("Project :");
		CostLabel=new JLabel("Cost :");
		PaidLabel=new JLabel("Paid :");
		DueLabel=new JLabel("Balance Due :");
		HeadingLabel=new JLabel("Billing");
		
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		CBclient.setFont(new Font("Taohma",Font.PLAIN,20));
		CBproject.setFont(new Font("Taohma",Font.PLAIN,20));
		cost.setFont(new Font("Taohma",Font.PLAIN,20));
		Due.setFont(new Font("Taohma",Font.PLAIN,20));
		paid.setFont(new Font("Taohma",Font.PLAIN,20));
		
		cost.setMargin(new Insets(5,5,5,5));
		Due.setMargin(new Insets(5,5,5,5));
		paid.setMargin(new Insets(5,5,5,5));

		submit.setFont(new Font("Taohma",Font.PLAIN,20));
		reset.setFont(new Font("Taohma",Font.PLAIN,20));
		cost.setEditable(false);
		Due.setEditable(false);
//		cost.setText("");
		
		
		ClientLabel.setFont(new Font("Taohma",Font.BOLD,28));
		ProjectLabel.setFont(new Font("Taohma",Font.BOLD,28));
		CostLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PaidLabel.setFont(new Font("Taohma",Font.BOLD,28));
		DueLabel.setFont(new Font("Taohma",Font.BOLD,28));
		HeadingLabel.setFont(new Font("Taohma",Font.BOLD,40));
		
		CBclient.setPreferredSize(new Dimension(200,30));
		CBproject.setPreferredSize(new Dimension(200,30));
		CBclient.addItemListener(this);
		CBproject.addItemListener(new projectLis());
		
		CBclient.addItem("--Select--");
		CBproject.addItem("--Select--");
		CBproject.setSelectedIndex(0);
	
		CBproject.disable();
		
		
		
		
		/////////////////////////////////////////
		////////////////////////////////////////
		
		ClientIcon=new ImageIcon("E:/projectpic/client2.png");
		clientimg=ClientIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		ProjectIcon=new ImageIcon("E:/projectpic/project.png");
		projectimg=ProjectIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		CostIcon=new ImageIcon("E:/projectpic/cost2.png");
		costimg=CostIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		BalanceIcon=new ImageIcon("E:/projectpic/balance.png");
		balanceimg=BalanceIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		PaidIcon=new ImageIcon("E:/projectpic/paid.png");
		paidimg=PaidIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		clientlabelicon=new JLabel(new ImageIcon(clientimg));
		projectlabelicon=new JLabel(new ImageIcon(projectimg));
		costlabelicon=new JLabel(new ImageIcon(costimg));
		balancelabelicon=new JLabel(new ImageIcon(balanceimg));
		paidlabelicon=new JLabel(new ImageIcon(paidimg));
		
		
///////////////////////////////////////////////////////////
		///////////////////////////////////////////
		
		submit.setMargin(new Insets(10,10,10,10));
		reset.setMargin(new Insets(10,10,10,10));
		
		String str;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Client_Id,Name from Client_details");
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1).trim();
				data.add(str);
				CBclient.addItem(str+" ("+rs.getString(2).trim()+")");
			}
			
		}
		catch (Exception e)
		{
			
		}
		
		
		panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(ClientLabel, gbc);
		panel.add(ClientLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(CBclient, gbc);
		panel.add(CBclient);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(clientlabelicon, gbc);
		panel.add(clientlabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(ProjectLabel, gbc);
		panel.add(ProjectLabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(CBproject, gbc);
		panel.add(CBproject);
		
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(projectlabelicon, gbc);
		panel.add(projectlabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(CostLabel, gbc);
		panel.add(CostLabel);
		

		gbc.gridx=1;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(cost, gbc);
		panel.add(cost);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(costlabelicon, gbc);
		panel.add(costlabelicon);
		

		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(DueLabel, gbc);
		panel.add(DueLabel);
		

		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Due, gbc);
		panel.add(Due);
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(balancelabelicon, gbc);
		panel.add(balancelabelicon);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PaidLabel, gbc);
		panel.add(PaidLabel);
		

		gbc.gridx=1;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(paid, gbc);
		panel.add(paid);
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(paidlabelicon, gbc);
		panel.add(paidlabelicon);
		
//		gbc.gridx=0;
//		gbc.gridy=5;
//		gbl.setConstraints(reset, gbc);
//		panel.add(reset);
//		
//		gbc.gridx=1;
//		gbc.gridy=5;
//		gbc.anchor=GridBagConstraints.EAST;
//		gbl.setConstraints(submit, gbc);
//		panel.add(submit);
		
		
		bottompanel.add(submit);
		bottompanel.add(reset);
		
		toppanel.add(HeadingLabel);
		
		mainpanel.add(panel,BorderLayout.CENTER);
		mainpanel.add(toppanel,BorderLayout.NORTH);
		mainpanel.add(bottompanel,BorderLayout.SOUTH);
		
		
	
		BillingFrame.add(mainpanel);
		BillingFrame.setLocation(0,0);
		BillingFrame.setSize(800,800);
		BillingFrame.setResizable(false);
		BillingFrame.setMaximizable(false);
		BillingFrame.setIconifiable(true);
		BillingFrame.setClosable(true);
		BillingFrame.setVisible(true);
		

//		pane.setLayout(null);
//		pane.add(BillingFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);	
		
	}

	public static void main(String[] args) 
	{
//		new Billing();

	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==submit)
		{
			if(CBclient.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(BillingFrame, "Select a Client");
			}
			else if(CBproject.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(BillingFrame, "Select a Project");
			}
			else if(paid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(BillingFrame, "Enter amount to be paid ");
			}
			else
			{
				String cid,pid,total,pai,bal;
				Float i,j,k;
				cid=data.get(CBclient.getSelectedIndex()-1);
				pid=(String)CBproject.getSelectedItem();
				total=cost.getText();
				pai=paid.getText();
				bal=Due.getText();
				i=Float.parseFloat(pai);
				j=Float.parseFloat(bal);
				k=j-i;
				if(k<0)
				{
					JOptionPane.showMessageDialog(BillingFrame, "Paid amount Exceed the Balance!!!! ");
				}
				else{
					
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement(" insert into Billing_details (ClientId,ProjectId,TotalCost,Paid,Balance) Values("+cid+","+pid+","+total+","+pai+","+k+")");
						int x=ps.executeUpdate();
						if(x>0)
						{
							JOptionPane.showMessageDialog(BillingFrame, "Record inserted");
							Payment_recipte obj;
							obj=new Payment_recipte(cid,pid,bal);
							BillingFrame.getParent().add(obj.ReciptFrame);
							obj.ReciptFrame.moveToFront();
							BillingFrame.dispose();
							
						}
						else
						{
							JOptionPane.showMessageDialog(BillingFrame, "Record not inserted");
						}
					} 
					catch (Exception e) {
				
					}
				}
			}
		}
		else if(evt.getSource()==reset)
		{
			CBclient.setSelectedIndex(0);
			CBproject.setSelectedIndex(0);
			paid.setText("");
			Due.setText("");
			cost.setText("");
		}
		
	}

	public void itemStateChanged(ItemEvent itm) 
	{
		if(itm.getStateChange()==ItemEvent.SELECTED)
			{
				
			//	String item=(String)(itm.getItem());
				
				cost.setText("");
				CBproject.removeAllItems();
				CBproject.insertItemAt("--select--",CBproject.getItemCount());
				CBproject.enable();
				Due.setText("");
				paid.setText("");
				if(CBclient.getSelectedIndex()>0)
				{
					int i=CBclient.getSelectedIndex();
					String item=data.get(i-1);
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("select Project_id  from Project_details where P_client="+item);
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
					CBproject.insertItemAt("--select--",CBproject.getItemCount());
					CBproject.setSelectedIndex(0);	
					CBproject.disable();
				}
			}			
	}
	
	class projectLis implements ItemListener
	{

		public void itemStateChanged(ItemEvent evt) 
		{
			if(evt.getStateChange()==ItemEvent.SELECTED)
			{
				if(CBclient.getSelectedIndex()!=0 && CBproject.getSelectedIndex()!=0)
				{
					//String client=(String)CBclient.getSelectedItem();
					String project=(String)CBproject.getSelectedItem();
					int j=CBclient.getSelectedIndex();
					String client=data.get(j-1);
					String coststr="";
					String duestr="";
					
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("select P_cost from Project_details where Project_id="+project+" and P_client="+client);
					//	PreparedStatement pn=conn.prepareStatement("Select top 1 Balance from Billing_details where ProjectID="+project+" and ClientID="+client+" order by InvoiceID desc");
					//  PreparedStatement ps=conn.prepareStatement("select a.P_cost,b.Balance from (select * from Project_details where Project_id="+project+" and P_client="+client+")a Join (Select top 1 * from Billing_details where ProjectID="+project+" and ClientID="+client+" )b on a.Project_id=b.ProjectId");
						ResultSet rs=ps.executeQuery();
						//ResultSet rn=pn.executeQuery();
						while(rs.next())
						{
						//	cost.setText(rs.getString(1));
							coststr=rs.getString(1);	
						}
						
					}
					catch (Exception e) {}
					
					try {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement pn=conn.prepareStatement("Select top 1 Balance from Billing_details where ProjectID="+project+" and ClientID="+client+" order by InvoiceID desc");
						ResultSet rn=pn.executeQuery();
						if(rn.next())
						{
							duestr=rn.getString(1);
						}
						else
						{
							duestr=coststr;
						}
						
					} 
					catch (Exception e) {
						
					}
					Float i=Float.parseFloat(coststr);
					cost.setText(""+i);
					Float k=Float.parseFloat(duestr);
					Due.setText(""+k);
//					System.out.println(""+i);
				}
			
			}
			
		}
		
	}
	
	
	
}
