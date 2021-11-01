import java.awt.*;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.css.ViewCSS;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import sun.net.www.content.text.plain;
import sun.security.provider.SystemIdentity;
public class update_Client implements ActionListener
{
//	JFrame frame;
//	JDesktopPane pane;
	JInternalFrame UpdateClientFrame;
	JPanel Panel;
	JLabel NameLabel,AddressLabel,PhoneLabel,EmailLabel;
	JTextField NameText,AddressText,PhoneText,EmailText;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton SubmitB,ResetB;
	String name,address,phone,email;
	String id;
	public update_Client(String str) {
//		frame=new JFrame("demo");
//		pane=new JDesktopPane();
		UpdateClientFrame =new JInternalFrame("Add Client");
		Panel=new JPanel();
	
		id=str;
		NameLabel=new JLabel("Client Name :");
		AddressLabel=new JLabel("Address :");
		PhoneLabel=new JLabel("Phone No. :");
		EmailLabel=new JLabel("Email :");

		NameLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		AddressLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PhoneLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		EmailLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		

		
		NameText=new JTextField(20);
		AddressText=new JTextField(20);
		PhoneText=new JTextField(20);
		EmailText=new JTextField(20);
	
	    NameText.setFont(new Font("Taohma",Font.PLAIN,20));	
		AddressText.setFont(new Font("Taohma",Font.PLAIN,20));
		PhoneText.setFont(new Font("Taohma",Font.PLAIN,20));
		EmailText.setFont(new Font("Taohma",Font.PLAIN,20));
		
	    NameText.setMargin(new Insets(5,5,5,5));
		AddressText.setMargin(new Insets(5,5,5,5));
		PhoneText.setMargin(new Insets(5,5,5,5));
		EmailText.setMargin(new Insets(5,5,5,5));
		
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
			PreparedStatement ps=conn.prepareStatement("Select * from Client_details where Client_Id="+str);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				name=rs.getString(2);
				address=rs.getString(3);
				phone=rs.getString(4);
				email=rs.getString(5);
				
				if(name!=null)
				NameText.setText(name.trim());

				if(address!=null)
					AddressText.setText(address.trim());

				if(phone!=null)
					PhoneText.setText(phone.trim());

				if(email!=null)
				EmailText.setText(email.trim());
			}
			
		}
		catch(Exception ee)
		{}
		
	
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
//		pane.setLayout(null);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(NameLabel, gbc);
		Panel.add(NameLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(NameText, gbc);
		Panel.add(NameText);
		
	
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(AddressLabel, gbc);
		Panel.add(AddressLabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(AddressText, gbc);
		Panel.add(AddressText);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(PhoneLabel, gbc);
		Panel.add(PhoneLabel);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(PhoneText, gbc);
		Panel.add(PhoneText);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(EmailLabel, gbc);
		Panel.add(EmailLabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(EmailText, gbc);
		Panel.add(EmailText);
		

		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(SubmitB, gbc);
		Panel.add(SubmitB);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(ResetB, gbc);
		Panel.add(ResetB);
		
		ResetB.addActionListener(this);
		SubmitB.addActionListener(this);
		
	
		UpdateClientFrame.add(Panel);
	
		
		UpdateClientFrame.setLocation(400,100);
		UpdateClientFrame.setSize(800,800);
		UpdateClientFrame.setResizable(true);
		UpdateClientFrame.setMaximizable(true);
		UpdateClientFrame.setIconifiable(true);
		UpdateClientFrame.setClosable(true);
		UpdateClientFrame.setVisible(true);
		
		
	
//		pane.add(AddClientFrame);
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
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("update Client_details set Name='"+NameText.getText()+"',Client_Address='"+AddressText.getText()+"',Phone='"+PhoneText.getText()+"',Email='"+EmailText.getText()+"' where Client_Id="+id );  
				int i=ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(UpdateClientFrame, "Record Updated succsefully ");
					view_Client obj;
					obj=new view_Client();
					UpdateClientFrame.getParent().add(obj.ViewClientFrame);
					obj.ViewClientFrame.moveToFront();
					UpdateClientFrame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(UpdateClientFrame, "Record is not Updated  ");
				}
				
			}
			catch(Exception ee)
			{}	
		}
		if(evt.getSource()==ResetB)
		{
			NameText.setText(name);
			AddressText.setText(address);
			PhoneText.setText(phone);
			EmailText.setText(email);
		}
	}
}
