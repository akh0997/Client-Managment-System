import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import sun.net.www.content.text.plain;
import sun.security.provider.SystemIdentity;
public class update_Employee implements ActionListener{
	JInternalFrame UpdateEmployeeFrame;
	JPanel Panel;
	JLabel NameLabel,AddressLabel,PhoneLabel,EmailLabel,QualificationLabel,LangLabel,PostLabel;
	JTextField NameText,AddressText,PhoneText,EmailText,QualificationText,LangText,PostText;
	JButton SubmitB,ResetB;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	String name,address,phone,email,qualification,lang,post;
	String id;
//	JFrame frame;
//	JDesktopPane pane;
	public update_Employee(String str) {

//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		UpdateEmployeeFrame=new JInternalFrame("demo");
		Panel=new JPanel();
		id=str;
		NameLabel=new JLabel("Name:");
		AddressLabel=new JLabel("Address:");
		PhoneLabel=new JLabel("Phone No.:");
		EmailLabel=new JLabel("Email:");
		QualificationLabel=new JLabel("Qualification::");
		LangLabel=new JLabel("Languages::");
		PostLabel=new JLabel("Post::");
		
		NameLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		AddressLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PhoneLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		EmailLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		QualificationLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		LangLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		PostLabel.setFont(new Font("Taohma",Font.PLAIN,20));
		
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
			PreparedStatement ps=conn.prepareStatement("select * from Employee_details where Emp_id="+str);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				name=rs.getString(2);
				address=rs.getString(3);
				phone=rs.getString(4);
				email=rs.getString(5);
				qualification=rs.getString(6);
				lang=rs.getString(7);
				post=rs.getString(8);
				
				if(name!=null)
				NameText.setText(name.trim());
				
				if(address!=null)
				AddressText.setText(address.trim());
				
				if(phone!=null)
				PhoneText.setText(phone.trim());
				
				if(email!=null)
				EmailText.setText(email.trim());
				
				if(qualification!=null)
				QualificationText.setText(qualification.trim());
				
				if(lang!=null)
				LangText.setText(lang.trim());
				
				if(post!=null)
				PostText.setText(post.trim());
				
			}
			
		}
		catch(Exception ee)
		{
			
		}
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
		//pane.setLayout(null);
		
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
		gbl.setConstraints(QualificationLabel, gbc);
		Panel.add(QualificationLabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(QualificationText, gbc);
		Panel.add(QualificationText);
		

		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(LangLabel, gbc);
		Panel.add(LangLabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(LangText, gbc);
		Panel.add(LangText);
		

		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(PostLabel, gbc);
		Panel.add(PostLabel);
		
		gbc.gridx=1;
		gbc.gridy=6;
		gbl.setConstraints(PostText, gbc);
		Panel.add(PostText);
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbl.setConstraints(SubmitB, gbc);
		Panel.add(SubmitB);
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbl.setConstraints(ResetB, gbc);
		Panel.add(ResetB);
		
		SubmitB.addActionListener(this);
		ResetB.addActionListener(this);
		
		
		
		UpdateEmployeeFrame.add(Panel);
		UpdateEmployeeFrame.setLocation(0,0);
		UpdateEmployeeFrame.setSize(800,800);
		UpdateEmployeeFrame.setResizable(true);
		UpdateEmployeeFrame.setMaximizable(true);
		UpdateEmployeeFrame.setIconifiable(true);
		UpdateEmployeeFrame.setClosable(true);
		UpdateEmployeeFrame.setVisible(true);
		

//		pane.setLayout(null);
//		pane.add(AddEmployeeFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==SubmitB)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("update Employee_details set E_name='"+NameText.getText()+"',E_address='"+AddressText.getText()+"',E_phone='"+PhoneText.getText()+"',E_Email='"+EmailText.getText()+"',E_Qualification='"+QualificationText.getText()+"',E_Language='"+LangText.getText()+"',E_post='"+PostText.getText()+"' where Emp_id="+id);
				int i=ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(UpdateEmployeeFrame, "record Updated succesfully");
					view_Employee obj;
					obj=new view_Employee();
					UpdateEmployeeFrame.getParent().add(obj.ViewEmployeeFrame);
					obj.ViewEmployeeFrame.moveToFront();
					UpdateEmployeeFrame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(UpdateEmployeeFrame, "record is not Updated ");
				}
				
			}
			catch(Exception ee){}
		}
		
		if(evt.getSource()==ResetB)
		{
			NameText.setText(name.trim());
			AddressText.setText(address.trim());
			PhoneText.setText(phone.trim());
			EmailText.setText(email.trim());
			QualificationText.setText(qualification.trim());
			LangText.setText(lang.trim());
			PostText.setText(post.trim());
		}
		
	}

}
