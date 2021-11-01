import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import sun.net.www.content.text.plain;
import sun.security.provider.SystemIdentity;

public class add_Client implements ActionListener
{
	
//	JFrame frame;
//	JDesktopPane pane;
	JInternalFrame AddClientFrame;
	JPanel Panel,mainpanel,bottompanel,toppanel;
	
	JLabel HeadingLabel;
	JLabel NameLabel,AddressLabel,PhoneLabel,EmailLabel;
	JTextField NameText,AddressText,PhoneText,EmailText;
	
	ImageIcon NameIcon,AddressIcon,PhoneIcon,EmailIcon;
	Image nameimg,addressimg,phoneimg,emailimg;
	JLabel namelabelicon,addresslabelicon,phonelabelicon,emaillabelicon;
	
	BorderLayout b1;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton SubmitB,ResetB;
	

	public add_Client() {
		
//		frame=new JFrame("demo");
//		pane=new JDesktopPane();
		AddClientFrame =new JInternalFrame("Add Client");
		Panel=new JPanel();
		mainpanel=new JPanel();
		bottompanel=new JPanel();
		toppanel=new JPanel();
		
		b1=new BorderLayout();
		
		HeadingLabel=new JLabel("Add Client");
		
		NameLabel=new JLabel("Client Name :");
		AddressLabel=new JLabel("Address :");
		PhoneLabel=new JLabel("Phone No. :");
		EmailLabel=new JLabel("Email :");
		
		
		HeadingLabel.setFont(new Font("Taohma",Font.PLAIN,40));
		
		NameLabel.setFont(new Font("Taohma",Font.BOLD,28));
		AddressLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PhoneLabel.setFont(new Font("Taohma",Font.BOLD,28));
		EmailLabel.setFont(new Font("Taohma",Font.BOLD,28));
		

		
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
		///////////////////////////////////////////////////
		////////////////////////////////////////////////
		
		NameIcon=new ImageIcon("E:/projectpic/name.png");
		nameimg=NameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		
		AddressIcon=new ImageIcon("E:/projectpic/address.png");
		addressimg=AddressIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		PhoneIcon=new ImageIcon("E:/projectpic/phone.png");
		phoneimg=PhoneIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		EmailIcon=new ImageIcon("E:/projectpic/email.png");
		emailimg=EmailIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		namelabelicon=new JLabel(new ImageIcon(nameimg));
		addresslabelicon=new JLabel(new ImageIcon(addressimg));
		phonelabelicon=new JLabel(new ImageIcon(phoneimg));
		emaillabelicon=new JLabel(new ImageIcon(emailimg));
		
		/////////////////////////////////////////////////
		//////////////////////////////////////////////////
		
		
		
		SubmitB=new JButton("Submit");
		ResetB=new JButton("Reset");
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		mainpanel.setLayout(b1);
		
		mainpanel.setBorder(new EmptyBorder(80,80,80,80));
		
		SubmitB.setFont(new Font("Taohma",Font.PLAIN,20));
		ResetB.setFont(new Font("Taohma",Font.PLAIN,20));
		
		SubmitB.setMargin(new Insets(10,10,10,10));
		ResetB.setMargin(new Insets(10,10,10,10));
		
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
//		pane.setLayout(null);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(NameLabel, gbc);
		Panel.add(NameLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.EAST;
		gbl.setConstraints(NameText, gbc);
		Panel.add(NameText);

		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(namelabelicon, gbc);
		Panel.add(namelabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(AddressLabel, gbc);
		Panel.add(AddressLabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.EAST;
		gbl.setConstraints(AddressText, gbc);
		Panel.add(AddressText);
		

		gbc.gridx=2;
		gbc.gridy=1;
		gbl.setConstraints(addresslabelicon, gbc);
		Panel.add(addresslabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PhoneLabel, gbc);
		Panel.add(PhoneLabel);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.EAST;
		gbl.setConstraints(PhoneText, gbc);
		Panel.add(PhoneText);
		

		gbc.gridx=2;
		gbc.gridy=2;
		gbl.setConstraints(phonelabelicon, gbc);
		Panel.add(phonelabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(EmailLabel, gbc);
		Panel.add(EmailLabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.EAST;
		gbl.setConstraints(EmailText, gbc);
		Panel.add(EmailText);
		

		gbc.gridx=2;
		gbc.gridy=3;
		gbl.setConstraints(emaillabelicon, gbc);
		Panel.add(emaillabelicon);
		

//		gbc.gridx=0;
//		gbc.gridy=4;
//		gbc.anchor=GridBagConstraints.WEST;
//		gbl.setConstraints(SubmitB, gbc);
//		Panel.add(SubmitB);
//		
//		gbc.gridx=1;
//		gbc.gridy=4;
//		gbc.anchor=GridBagConstraints.EAST;
//		gbl.setConstraints(ResetB, gbc);
//		Panel.add(ResetB);
		
		bottompanel.add(SubmitB);
		bottompanel.add(ResetB);
		
		toppanel.add(HeadingLabel);
		
		mainpanel.add(Panel,BorderLayout.CENTER);
		mainpanel.add(toppanel,BorderLayout.NORTH);
		mainpanel.add(bottompanel,BorderLayout.SOUTH);
		
		
		ResetB.addActionListener(this);
		SubmitB.addActionListener(this);
		
		AddClientFrame.add(mainpanel);
		AddClientFrame.setLocation(400,100);
		AddClientFrame.setSize(800,800);
		AddClientFrame.setResizable(true);
		AddClientFrame.setMaximizable(true);
		AddClientFrame.setIconifiable(true);
		AddClientFrame.setClosable(true);
		AddClientFrame.setVisible(true);
	
//		pane.add(AddClientFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
	
		
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==SubmitB)
		{
			if(NameText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddClientFrame, "Name is required!");
			}
			else if(AddressText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddClientFrame, "Address is required!");
			}
			else if(PhoneText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddClientFrame, "Phone no. is required!");
			}
			else if(EmailText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddClientFrame, "Email id is required!");
			}
			else
			{
				
				try
				{
					
						
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("insert into Client_details(Name,Client_Address,Phone,Email) values(?,?,?,?)");
						ps.setString(1, NameText.getText());
						ps.setString(2, AddressText.getText());
						ps.setString(3, PhoneText.getText());
						ps.setString(4, EmailText.getText());
						int i=ps.executeUpdate();
						if(i>0)
						{
							NameText.setText("");
							AddressText.setText("");
							PhoneText.setText("");
							EmailText.setText("");
							JOptionPane.showMessageDialog(AddClientFrame, "Client Added Succesfully");
						}
						else
						{
							
							JOptionPane.showMessageDialog(AddClientFrame, "Fail to add the client");
						}
				}
				catch(Exception ee)
				{
					System.out.print(ee);
				}
			}
			
		}
		if(evt.getSource()==ResetB)
		{
			NameText.setText("");
			AddressText.setText("");
			EmailText.setText("");
			PhoneText.setText("");
		}
	}

}
