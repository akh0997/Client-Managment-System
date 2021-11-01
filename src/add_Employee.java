import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
import com.sun.org.apache.regexp.internal.recompile;
public class add_Employee implements ActionListener 
{
	JInternalFrame AddEmployeeFrame;
	JPanel Panel,mainpanel,bottompanel,toppanel;
	
	JLabel HeadingLabel;
	
	JLabel NameLabel,AddressLabel,PhoneLabel,EmailLabel,QualificationLabel,LangLabel,PostLabel;
	JTextField NameText,AddressText,PhoneText,EmailText,QualificationText,LangText,PostText;
	
	ImageIcon NameIcon,AddressIcon,PhoneIcon,EmailIcon,QualifictaionIcon,LangIcon,PostIcon;
	Image nameimg,addressimg,phoneimg,emailimg,qualificationimg,langimg,postimg;
	JLabel namelabelicon,addresslabelicon,phonelabelicon,emaillabelicon,qualificationlabelicon,langlabelicon,postlabelicon;
	BorderLayout b1;
	
	JButton SubmitB,ResetB;
	GridBagLayout gbl;
	GridBagConstraints gbc;
//	JFrame frame;
//	JDesktopPane pane;
	public add_Employee() 
	{
//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		AddEmployeeFrame=new JInternalFrame("demo");
		Panel=new JPanel();
		mainpanel=new JPanel();
		bottompanel=new JPanel();
		toppanel=new JPanel();
		
		b1=new BorderLayout();
		
		HeadingLabel=new JLabel("Add Employee");
		
		NameLabel=new JLabel("Name:");
		AddressLabel=new JLabel("Address:");
		PhoneLabel=new JLabel("Phone No.:");
		EmailLabel=new JLabel("Email:");
		QualificationLabel=new JLabel("Qualification::");
		LangLabel=new JLabel("Languages::");
		PostLabel=new JLabel("Post::");
		
		HeadingLabel.setFont(new Font("Taohma",Font.PLAIN,40));
		NameLabel.setFont(new Font("Taohma",Font.BOLD,28));
		AddressLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PhoneLabel.setFont(new Font("Taohma",Font.BOLD,28));
		EmailLabel.setFont(new Font("Taohma",Font.BOLD,28));
		QualificationLabel.setFont(new Font("Taohma",Font.BOLD,28));
		LangLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PostLabel.setFont(new Font("Taohma",Font.BOLD,28));
		
		NameText=new JTextField(20);
		AddressText=new JTextField(20);
		PhoneText=new JTextField(20);
		EmailText=new JTextField(20);
		QualificationText=new JTextField(20);
		LangText=new JTextField(20);
		PostText=new JTextField(20);
		
		NameText.setFont(new Font("Taohma",Font.PLAIN,20));
		AddressText.setFont(new Font("Taohma",Font.PLAIN,20));
		PhoneText.setFont(new Font("Taohma",Font.PLAIN,20));
		EmailText.setFont(new Font("Taohma",Font.PLAIN,20));
		QualificationText.setFont(new Font("Taohma",Font.PLAIN,20));
		LangText.setFont(new Font("Taohma",Font.PLAIN,20));
		PostText.setFont(new Font("Taohma",Font.PLAIN,20));
		
		NameText.setMargin(new Insets(5,5,5,5));
		AddressText.setMargin(new Insets(5,5,5,5));
		PhoneText.setMargin(new Insets(5,5,5,5));
		EmailText.setMargin(new Insets(5,5,5,5));
		QualificationText.setMargin(new Insets(5,5,5,5));
		LangText.setMargin(new Insets(5,5,5,5));
		PostText.setMargin(new Insets(5,5,5,5));
		
		//////////////////////////////////////////////
		/////////////////////////////////////////////
		
		NameIcon=new ImageIcon("E:/projectpic/emp2.png");
		nameimg=NameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		AddressIcon=new ImageIcon("E:/projectpic/address.png");
		addressimg=AddressIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
		PhoneIcon=new ImageIcon("E:/projectpic/phone.png");
		phoneimg=PhoneIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		EmailIcon=new ImageIcon("E:/projectpic/email.png");
		emailimg=EmailIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		QualifictaionIcon=new ImageIcon("E:/projectpic/quali.png");
		qualificationimg=QualifictaionIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		LangIcon=new ImageIcon("E:/projectpic/pencil.png");
		langimg=LangIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		PostIcon=new ImageIcon("E:/projectpic/post.png");
		postimg=PostIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		namelabelicon=new JLabel(new ImageIcon(nameimg));
		addresslabelicon=new JLabel(new ImageIcon(addressimg));
		phonelabelicon=new JLabel(new ImageIcon(phoneimg));
		emaillabelicon=new JLabel(new ImageIcon(emailimg));
		qualificationlabelicon=new JLabel(new ImageIcon(qualificationimg));
		langlabelicon=new JLabel(new ImageIcon(langimg));
		postlabelicon=new JLabel(new ImageIcon(postimg));
		
		
		//////////////////////////////////////////////
		/////////////////////////////////////////////
		
		
		SubmitB=new JButton("Submit");
		ResetB=new JButton("Reset");
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		mainpanel.setBorder(new EmptyBorder(60,60,60,60));
		
		mainpanel.setLayout(b1);
		
		SubmitB.setFont(new Font("Taohma",Font.PLAIN,20));
		ResetB.setFont(new Font("Taohma",Font.PLAIN,20));
		
		SubmitB.setMargin(new Insets(10,10,10,10));
		ResetB.setMargin(new Insets(10,10,10,10));
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
		//pane.setLayout(null);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(NameLabel, gbc);
		Panel.add(NameLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
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
		gbl.setConstraints(EmailText, gbc);
		Panel.add(EmailText);
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbl.setConstraints(emaillabelicon, gbc);
		Panel.add(emaillabelicon);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(QualificationLabel, gbc);
		Panel.add(QualificationLabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(QualificationText, gbc);
		Panel.add(QualificationText);
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbl.setConstraints(qualificationlabelicon, gbc);
		Panel.add(qualificationlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(LangLabel, gbc);
		Panel.add(LangLabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(LangText, gbc);
		Panel.add(LangText);
		
		gbc.gridx=2;
		gbc.gridy=5;
		gbl.setConstraints(langlabelicon, gbc);
		Panel.add(langlabelicon);

		gbc.gridx=0;
		gbc.gridy=6;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PostLabel, gbc);
		Panel.add(PostLabel);
		
		gbc.gridx=1;
		gbc.gridy=6;
		gbl.setConstraints(PostText, gbc);
		Panel.add(PostText);
		
		gbc.gridx=2;
		gbc.gridy=6;
		gbl.setConstraints(postlabelicon, gbc);
		Panel.add(postlabelicon);
		
//		gbc.gridx=0;
//		gbc.gridy=7;
//		gbc.anchor=GridBagConstraints.WEST;
//		gbl.setConstraints(SubmitB, gbc);
//		Panel.add(SubmitB);
//		
//		gbc.gridx=1;
//		gbc.gridy=7;
//		gbc.anchor=GridBagConstraints.EAST;
//		gbl.setConstraints(ResetB, gbc);
//		Panel.add(ResetB);
		
		bottompanel.add(SubmitB);
		bottompanel.add(ResetB);
		
		toppanel.add(HeadingLabel);
		
		mainpanel.add(Panel,BorderLayout.CENTER);
		mainpanel.add(toppanel,BorderLayout.NORTH);
		mainpanel.add(bottompanel,BorderLayout.SOUTH);
		
		SubmitB.addActionListener(this);
		ResetB.addActionListener(this);
		
		
		AddEmployeeFrame.add(mainpanel);
		AddEmployeeFrame.setLocation(0,0);
		AddEmployeeFrame.setSize(800,800);
		AddEmployeeFrame.setResizable(true);
		AddEmployeeFrame.setIconifiable(true);
		AddEmployeeFrame.setMaximizable(true);
		
		AddEmployeeFrame.setClosable(true);
		AddEmployeeFrame.setVisible(true);
		

//		pane.setLayout(null);
//		pane.add(AddEmployeeFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//		
	}
	public static void main(String[] args)
	{
	
		//new add_Employee();
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==SubmitB)
		{
			if(NameText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Name is required");
				
			}
			else if(AddressText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Address is required");
			}
			else if(PhoneText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Phone no. is required");
			}
			else if(EmailText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Email id is required");
			}
			else if(QualificationText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Qualification is required");
			}
			else if(LangText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Languages is required");
			}
			else if(PostText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddEmployeeFrame, "Post is required");
			}
			
			else
			{
				try
				{
					
						
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("insert into Employee_details(E_name,E_address,E_phone,E_Email,E_Qualification,E_Language,E_post) values(?,?,?,?,?,?,?)");
						ps.setString(1,NameText.getText());
						ps.setString(2,AddressText.getText());
						ps.setString(3,PhoneText.getText());
						ps.setString(4,EmailText.getText());
						ps.setString(5,QualificationText.getText());
						ps.setString(6,LangText.getText());
						ps.setString(7,PostText.getText());
						
						int i=ps.executeUpdate();
						if(i>0)
						{
							NameText.setText("");
							AddressText.setText("");
							PhoneText.setText("");
							EmailText.setText("");
							QualificationText.setText("");
							LangText.setText("");
							PostText.setText("");
							JOptionPane.showMessageDialog(AddEmployeeFrame, "Employee Added Succesfully");
						}
						else
						{
							
							JOptionPane.showMessageDialog(AddEmployeeFrame, "Fail to add Employee");
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
			PhoneText.setText("");
			EmailText.setText("");
			QualificationText.setText("");
			LangText.setText("");
			PostText.setText("");
			
		}
		
	}

}
