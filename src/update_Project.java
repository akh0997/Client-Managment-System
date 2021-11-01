import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import sun.net.www.content.text.plain;
import sun.security.provider.SystemIdentity;
public class update_Project implements ActionListener
{

//	JFrame frame;
//	JDesktopPane pane;
	
	JInternalFrame UpdateProjectFrame;
	JPanel Panel;
	JLabel PTitelLabel,PLangLabel,PDurationLabel,PClientLabel,PCostLabel,PDiscriptionLabel;
	JTextField PTitelText,PLangText,PDurationText,PClientText,PCostText;
	JTextArea PDiscriptionText;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton SubmitB,ResetB;
	String titel,lang,duration,client,cost,discription;
	String id;

	public update_Project(String str) {

//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		UpdateProjectFrame =new JInternalFrame("demo");
		Panel=new JPanel();
		id=str;
		PTitelLabel=new JLabel("Project titel::");
		PLangLabel=new JLabel("Project Lang::");
		
		PDurationLabel=new JLabel("Project Duration::");
		PClientLabel=new JLabel("Client::");
		PCostLabel=new JLabel("Project Cost::");
		
		PDiscriptionLabel=new JLabel("Project Discription :");
		
		PTitelLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PLangLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PDurationLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PClientLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PCostLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PDiscriptionLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		
		
		PTitelText=new JTextField(20);
		PLangText=new JTextField(20);
		
		PDurationText=new JTextField(20);
		PClientText=new JTextField(20);
		PCostText=new JTextField(20);
		
		PDiscriptionText=new JTextArea(5,30);
		PDiscriptionText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		PTitelText.setFont(new Font("Taohma",Font.PLAIN,20));
		PLangText.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PDurationText.setFont(new Font("Taohma",Font.PLAIN,20));
		PClientText.setFont(new Font("Taohma",Font.PLAIN,20));
		PCostText.setFont(new Font("Taohma",Font.PLAIN,20));

		PDiscriptionText.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PTitelText.setMargin(new Insets(5,5,5,5));
		PLangText.setMargin(new Insets(5,5,5,5));
		
		PDurationText.setMargin(new Insets(5,5,5,5));
		PClientText.setMargin(new Insets(5,5,5,5));
		PCostText.setMargin(new Insets(5,5,5,5));
		
		
		SubmitB=new JButton("Submit");
		ResetB=new JButton("Reset");
		
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		SubmitB.setFont(new Font("Taohma",Font.PLAIN,20));
		ResetB.setFont(new Font("Taohma",Font.PLAIN,20));
		
		SubmitB.setMargin(new Insets(10,10,10,10));
		ResetB.setMargin(new Insets(10,10,10,10));
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select * from Project_details where Project_id="+str);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				titel=rs.getString(2);
				lang=rs.getString(3);
				duration=rs.getString(4);
				client=rs.getString(6);
				cost=rs.getString(7);
				discription=rs.getString(8);
				
				if(titel!=null)
				PTitelText.setText(titel.trim());
				
				if(lang!=null)
				PLangText.setText(lang.trim());
				
				if(duration!=null)
				PDurationText.setText(duration.trim());
				
				if(client!=null)
				PClientText.setText(client.trim());
				
				if(cost!=null)
				PCostText.setText(cost.trim());
				
				if(discription!=null)
				PDiscriptionText.setText(discription.trim());
				
			}
			
		}
		catch(Exception ee)
		{}
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(PTitelLabel, gbc);
		Panel.add(PTitelLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(PTitelText, gbc);
		Panel.add(PTitelText);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(PLangLabel, gbc);
		Panel.add(PLangLabel);
		
		gbc.gridx=1;
		 gbc.gridy=1;
		gbl.setConstraints(PLangText, gbc);
		Panel.add(PLangText);
		
	
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(PDurationLabel, gbc);
		Panel.add(PDurationLabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(PDurationText, gbc);
		Panel.add(PDurationText);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(PClientLabel, gbc);
		Panel.add(PClientLabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(PClientText, gbc);
		Panel.add(PClientText);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(PCostLabel, gbc);
		Panel.add(PCostLabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(PCostText, gbc);
		Panel.add(PCostText);
		
	
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbl.setConstraints(PDiscriptionLabel, gbc);
		Panel.add(PDiscriptionLabel);
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbc.gridheight=10;
		gbc.gridwidth=10;
		gbl.setConstraints(PDiscriptionText, gbc);
		Panel.add(PDiscriptionText);
		
		gbc.gridx=0;
		gbc.gridy=18;
		gbl.setConstraints(SubmitB, gbc);
		Panel.add(SubmitB);
		
		gbc.gridx=1;
		gbc.gridy=18;
		gbl.setConstraints(ResetB, gbc);
		Panel.add(ResetB);
		SubmitB.addActionListener(this);
		ResetB.addActionListener(this);
		
		

		UpdateProjectFrame.add(Panel);
		UpdateProjectFrame.setLocation(0,0);
		UpdateProjectFrame.setSize(800,800);
		UpdateProjectFrame.setResizable(true);
		UpdateProjectFrame.setMaximizable(true);
		UpdateProjectFrame.setIconifiable(true);
		UpdateProjectFrame.setClosable(true);
		UpdateProjectFrame.setVisible(true);
		
//		pane.setLayout(null);
//		pane.add(AddProjectFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
	}
	public static void main(String[] args) {
		

	}

	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==SubmitB)
		{
			try
			{
				//System.out.println(id);
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("update Project_details set P_titel='"+PTitelText.getText()+"',P_language='"+PLangText.getText()+"',P_duration="+PDurationText.getText()+",P_client="+PClientText.getText()+",P_cost="+PCostText.getText()+",P_discription='"+PDiscriptionText.getText()+"' where Project_id="+id);
				int i=ps.executeUpdate();
				System.out.println(i);
				if(i>0)
				{
					JOptionPane.showMessageDialog(UpdateProjectFrame, "Record updated Sccsefully");
					view_Project obj;
					obj=new view_Project();
					UpdateProjectFrame.getParent().add(obj.ViewProjectFrame);
					obj.ViewProjectFrame.moveToFront();
					UpdateProjectFrame.dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(UpdateProjectFrame, "Record is not updated ");
				}
				
			}
			catch(Exception ee)
			{}
			UpdateProjectFrame.dispose();
		}
		
		if(evt.getSource()==ResetB)
		{
			PTitelText.setText(titel.trim());
			PLangText.setText(lang.trim());
			PDurationText.setText(duration.trim());
			PClientText.setText(client.trim());
			PCostText.setText(cost.trim());
			PDiscriptionText.setText(discription.trim());
			
		}	
	}
}
