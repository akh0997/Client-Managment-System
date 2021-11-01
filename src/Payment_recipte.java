import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import sun.swing.PrintColorUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.peer.ComponentPeer;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.org.apache.xml.internal.serialize.Printer;

public class Payment_recipte implements ActionListener {

	JInternalFrame ReciptFrame;
	JPanel mainpanel,paymentDetailsmainpanel,reciptpanel,Bpanel,clientDetailPanel,invoicePanel,infoPanel,paymentDetailsPanel;

	JLabel cNameLabel,cNameValue,cEmailLabel,cEmailValue,cAddressLabel,cAddressValue,cNumberLabel,cNumberValue;
	JLabel InvoiceLabel,InvoiceValue,InvoiceDateLabel,InvoiceDateValue;
	
	JLabel PIDLabel,PIDValue,PNameLabel,PNameValue,PTotalLabel,PTotalValue,PPaidLabel,PPaidValue,PBalanceLabel,PBalanceValue,PDueLabel,PDueValue;
	
	ScrollPane scroll;
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	
	JFrame frame;
	JDesktopPane pane;
	
	int j=0;
	GridBagLayout gbl1,gbl2,gbl3;
	GridBagConstraints gbc1,gbc2,gbc3;
	GridLayout gl1,gl2;
	
	JButton print,Mail;
	BorderLayout b1,b2;
//	public Payment_recipte()
		
	public Payment_recipte( String Cid,String Pid,String Bal)
	{
		frame=new JFrame("demo") ;
		pane=new JDesktopPane();
		scroll=new ScrollPane();
		
		b1=new BorderLayout();
		b2=new BorderLayout();
		ReciptFrame = new JInternalFrame("demo");
		mainpanel = new JPanel();
		
		reciptpanel=new JPanel();
		Bpanel=new JPanel();
		
		clientDetailPanel=new JPanel();
		invoicePanel=new JPanel();
		paymentDetailsPanel=new JPanel();
		paymentDetailsmainpanel=new JPanel();
		infoPanel=new JPanel();
		
		
		paymentDetailsmainpanel.setLayout(b2);
		clientDetailPanel.setBackground(Color.WHITE);
		invoicePanel.setBackground(Color.WHITE);
//		invoicePanel.setBackground(new Color(55,121,230));
//		infoPanel.setBorder(new EmptyBorder(30, 30, 30, 30));	
//		invoicePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		paymentDetailsPanel.setBackground(Color.WHITE);
		paymentDetailsPanel.setBorder(new EmptyBorder(0, 200, 30, 30));	
		paymentDetailsmainpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		print=new JButton("Print");
		Mail=new JButton("Mail");
		
		print.addActionListener(this);
		Mail.addActionListener(this);
		
		gl1=new GridLayout(2,1);
		gl2=new GridLayout(1,2);
		
		gbl1=new GridBagLayout();
		gbc1=new GridBagConstraints(); 

		gbl2=new GridBagLayout();
		gbc2=new GridBagConstraints(); 

		gbl3=new GridBagLayout();
		gbc3=new GridBagConstraints(); 
		
		cNameLabel=new JLabel("Client Name :    ");
		cNameValue=new JLabel("abc");
		
		cEmailLabel=new JLabel("Email :    ");
		cEmailValue=new JLabel("abc@gmail.com");
		
		cAddressLabel=new JLabel("Address :    ");
		cAddressValue=new JLabel("#23,shgdhgfsh,karnal,Haryana");
		
		cNumberLabel=new JLabel("Contact No.:    ");
		cNumberValue=new JLabel("9999999999");
		
		
		InvoiceLabel=new JLabel("Invoice Number :    ");
		InvoiceValue=new JLabel("99999");
		
		InvoiceDateLabel=new JLabel("Invoice Date :    ");
		InvoiceDateValue=new JLabel("99/99/9999");
		
		
		 PIDLabel=new JLabel("Project ID : ");
		 PIDValue=new JLabel("10001");
		 
		 PNameLabel=new JLabel("Project Name :              ");
		 PNameValue=new JLabel("Management System");
		 
		 PTotalLabel=new JLabel("Cost :              ");
		 PTotalValue=new JLabel("10000");
	
		 PBalanceLabel=new JLabel("Balance :              ");
		 PBalanceValue=new JLabel("3000");
		 
		 PPaidLabel=new JLabel("Amount Paid:              ");
		 PPaidValue=new JLabel("1000");
		 
		 PDueLabel=new JLabel("Balance Due:              ");
		 PDueValue=new JLabel("2000");
		 
		
		////////////////////////////////////////////////////
		cNameLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cNameValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cEmailLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cEmailValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cAddressLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cAddressValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cNumberLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cNumberValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		
		InvoiceLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		InvoiceValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		InvoiceDateLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		InvoiceDateValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		/////////////////////////////////////////////
		
		 PIDLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PIDValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PNameLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PNameValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PTotalLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PTotalValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 
		 PPaidLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PPaidValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 
		 PBalanceLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PBalanceValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PDueLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PDueValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 
		 PIDValue.setText(Pid);
		 PBalanceValue.setText(Bal);
		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement ps=conn.prepareStatement("Select * from Client_details where Client_ID="+Cid);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 cNameValue.setText(rs.getString(2).trim());
				 cAddressValue.setText(rs.getString(3).trim());
				 cNumberValue.setText(rs.getString(4).trim());
				 cEmailValue.setText(rs.getString(5).trim());
			 }
		 } 
		 catch (Exception e) {}
		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement ps=conn.prepareStatement("Select P_titel from Project_details where Project_id="+Pid);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				PNameValue.setText(rs.getString(1).trim());
			 }
		 } 
		 catch (Exception e) {}
		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement pn=conn.prepareStatement("Select top 1 * from Billing_details where ClientId="+Cid+" and ProjectId="+Pid+" order by InvoiceId desc");
			 ResultSet rn=pn.executeQuery();
			 while(rn.next())
			 {
				InvoiceValue.setText(rn.getString(1).trim());
				PTotalValue.setText(rn.getString(4).trim());
				String str[]=rn.getString(5).substring(0,10).split("-");
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
				InvoiceDateValue.setText(str1);
				
				PPaidValue.setText(rn.getString(6).trim());
			//	PPaidValue.setText(rn.getString(6).substring(0));
				PDueValue.setText(rn.getString(7).trim());
				//System.out.println(rn.getString(4).trim()+" "+rn.getString(6).trim());
			 }
		 } 
		 catch (Exception e) {}
		////////////////////////////////////////////
		
		clientDetailPanel.setLayout(gbl1);
		invoicePanel.setLayout(gbl2);
		paymentDetailsPanel.setLayout(gbl3);
		////////////////////////////////////////////////////Client details panel///////////////////////////////////////////////////////////
		//////////////////////////////////////////////////
		gbc1.gridx=0;
		gbc1.gridy=0;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNameLabel, gbc1);
		clientDetailPanel.add(cNameLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=0;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNameValue, gbc1);
		clientDetailPanel.add(cNameValue);
		
		gbc1.gridx=0;
		gbc1.gridy=1;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cEmailLabel, gbc1);
		clientDetailPanel.add(cEmailLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=1;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cEmailValue, gbc1);
		clientDetailPanel.add(cEmailValue);
		
		gbc1.gridx=0;
		gbc1.gridy=2;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cAddressLabel, gbc1);
		clientDetailPanel.add(cAddressLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=2;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cAddressValue, gbc1);
		clientDetailPanel.add(cAddressValue);
		
		
		gbc1.gridx=0;
		gbc1.gridy=3;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNumberLabel, gbc1);
		clientDetailPanel.add(cNumberLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=3;
		gbc1.anchor=GridBagConstraints.WEST;	
		gbl1.setConstraints(cNumberValue, gbc1);
		clientDetailPanel.add(cNumberValue);
		
		//////////////////////////////////////////////////Invoice Details//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////
		gbc2.gridx=0;
		gbc2.gridy=0;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceLabel, gbc2);
		invoicePanel.add(InvoiceLabel);
		
		gbc2.gridx=1;
		gbc2.gridy=0;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceValue, gbc2);
		invoicePanel.add(InvoiceValue);
		
		
		gbc2.gridx=0;
		gbc2.gridy=1;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceDateLabel, gbc2);
		invoicePanel.add(InvoiceDateLabel);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceDateValue, gbc2);
		invoicePanel.add(InvoiceDateValue);
		
		/////////////////////////////////////////////////Payment details//////////////////////////////////////////////////
		////////////////////////////////////////////////
		
		gbc3.weightx=2;
		gbc3.gridx=0;
		gbc3.gridy=0;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PIDLabel, gbc3);
		paymentDetailsPanel.add(PIDLabel);
		
	
		gbc3.gridx=1;
		gbc3.gridy=0;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PIDValue, gbc3);
		paymentDetailsPanel.add(PIDValue);
		
		
		gbc3.gridx=0;
		gbc3.gridy=1;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PNameLabel, gbc3);
		paymentDetailsPanel.add(PNameLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=1;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PNameValue, gbc3);
		paymentDetailsPanel.add(PNameValue);
		
		gbc3.gridx=0;
		gbc3.gridy=2;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PTotalLabel, gbc3);
		paymentDetailsPanel.add(PTotalLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=2;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PTotalValue, gbc3);
		paymentDetailsPanel.add(PTotalValue);
		
		gbc3.gridx=0;
		gbc3.gridy=3;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PBalanceLabel, gbc3);
		paymentDetailsPanel.add(PBalanceLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=3;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PBalanceValue, gbc3);
		paymentDetailsPanel.add(PBalanceValue);
		
		
		gbc3.gridx=0;
		gbc3.gridy=4;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PPaidLabel, gbc3);
		paymentDetailsPanel.add(PPaidLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=4;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PPaidValue, gbc3);
		paymentDetailsPanel.add(PPaidValue);
		
		gbc3.gridx=0;
		gbc3.gridy=5;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PDueLabel, gbc3);
		paymentDetailsPanel.add(PDueLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=5;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PDueValue, gbc3);
		paymentDetailsPanel.add(PDueValue);
	
		//////////////////////
		reciptpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainpanel.setLayout(b1);
		mainpanel.setBorder(new EmptyBorder(70, 400, 300, 400));
		print.setPreferredSize(new Dimension(100,40));
		Mail.setPreferredSize(new Dimension(100,40));
		Bpanel.setBorder(new EmptyBorder(30,50,10,50));
		Bpanel.add(print);
		Bpanel.add(Mail);
		
		
		infoPanel.setLayout(gl2);
		
		infoPanel.add(clientDetailPanel);
		infoPanel.add(invoicePanel);
		
		paymentDetailsmainpanel.add(paymentDetailsPanel);
		reciptpanel.setLayout(gl1);
		reciptpanel.setBackground(Color.WHITE);
		
		reciptpanel.add(infoPanel);
		reciptpanel.add(paymentDetailsmainpanel);
	
		mainpanel.add(reciptpanel,BorderLayout.CENTER);
		
		mainpanel.add(Bpanel,BorderLayout.SOUTH);
		ReciptFrame.add(mainpanel);
		
		ReciptFrame.setLocation(0,0);
		
		//Dimension D=ReciptFrame.getParent
		ReciptFrame.setSize(d);
	
		ReciptFrame.setResizable(false);
		ReciptFrame.setMaximizable(false);
		
		ReciptFrame.setIconifiable(true);
	
		ReciptFrame.setClosable(true);
		ReciptFrame.setVisible(true);
		
//		pane.setLayout(null);
//		pane.add(ReciptFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);	
		
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////second constructor////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Payment_recipte( String Cid,String invoice)
	{
		frame=new JFrame("demo") ;
		pane=new JDesktopPane();
		scroll=new ScrollPane();
		
		
		b1=new BorderLayout();
		b2=new BorderLayout();
		ReciptFrame = new JInternalFrame("demo");
		mainpanel = new JPanel();
		
		reciptpanel=new JPanel();
		Bpanel=new JPanel();
		
		clientDetailPanel=new JPanel();
		invoicePanel=new JPanel();
		paymentDetailsPanel=new JPanel();
		paymentDetailsmainpanel=new JPanel();
		infoPanel=new JPanel();
		
		
		paymentDetailsmainpanel.setLayout(b2);
		clientDetailPanel.setBackground(Color.WHITE);
		invoicePanel.setBackground(Color.WHITE);
//		invoicePanel.setBackground(new Color(55,121,230));
//		infoPanel.setBorder(new EmptyBorder(30, 30, 30, 30));	
//		invoicePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		paymentDetailsPanel.setBackground(Color.WHITE);
		paymentDetailsPanel.setBorder(new EmptyBorder(0, 200, 30, 30));	
		paymentDetailsmainpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		print=new JButton("Print");
		Mail=new JButton("Mail");
		
		print.addActionListener(this);
		Mail.addActionListener(this);
		
		gl1=new GridLayout(2,1);
		gl2=new GridLayout(1,2);
		
		gbl1=new GridBagLayout();
		gbc1=new GridBagConstraints(); 

		gbl2=new GridBagLayout();
		gbc2=new GridBagConstraints(); 

		gbl3=new GridBagLayout();
		gbc3=new GridBagConstraints(); 
		
		cNameLabel=new JLabel("Client Name :    ");
		cNameValue=new JLabel("abc");
		
		cEmailLabel=new JLabel("Email :    ");
		cEmailValue=new JLabel("abc@gmail.com");
		
		cAddressLabel=new JLabel("Address :    ");
		cAddressValue=new JLabel("#23,shgdhgfsh,karnal,Haryana");
		
		cNumberLabel=new JLabel("Contact No.:    ");
		cNumberValue=new JLabel("9999999999");
		
		
		InvoiceLabel=new JLabel("Invoice Number :    ");
		InvoiceValue=new JLabel("99999");
		
		InvoiceDateLabel=new JLabel("Invoice Date :    ");
		InvoiceDateValue=new JLabel("99/99/9999");
		
		
		 PIDLabel=new JLabel("Project ID : ");
		 PIDValue=new JLabel("10001");
		 
		 PNameLabel=new JLabel("Project Name :              ");
		 PNameValue=new JLabel("Management System");
		 
		 PTotalLabel=new JLabel("Cost :              ");
		 PTotalValue=new JLabel("10000");
	
		 PBalanceLabel=new JLabel("Balance :              ");
		 PBalanceValue=new JLabel("3000");
		 
		 PPaidLabel=new JLabel("Amount Paid:              ");
		 PPaidValue=new JLabel("1000");
		 
		 PDueLabel=new JLabel("Balance Due:              ");
		 PDueValue=new JLabel("2000");
		 
		
		////////////////////////////////////////////////////
		cNameLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cNameValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cEmailLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cEmailValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cAddressLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cAddressValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		cNumberLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		cNumberValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		
		InvoiceLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		InvoiceValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		
		InvoiceDateLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		InvoiceDateValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		/////////////////////////////////////////////
		
		 PIDLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PIDValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PNameLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PNameValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PTotalLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PTotalValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 
		 PPaidLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PPaidValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 
		 PBalanceLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PBalanceValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PDueLabel.setFont(new Font("Tohoma",Font.PLAIN,20));
		 PDueValue.setFont(new Font("Tohoma",Font.PLAIN,20));
		 		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement ps=conn.prepareStatement("Select * from Client_details where Client_ID="+Cid);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 cNameValue.setText(rs.getString(2).trim());
				 cAddressValue.setText(rs.getString(3).trim());
				 cNumberValue.setText(rs.getString(4).trim());
				 cEmailValue.setText(rs.getString(5).trim());
			 }
		 } 
		 catch (Exception e) {}
		 
		String Pid="";
		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement pn=conn.prepareStatement("Select * from Billing_details where InvoiceId="+invoice);
			 ResultSet rn=pn.executeQuery();
			 while(rn.next())
			 {
				
				
				InvoiceValue.setText(rn.getString(1).trim());
				Pid=rn.getString(3).trim();
				PIDValue.setText(Pid);
				PTotalValue.setText(rn.getString(4).trim());
				String str[]=rn.getString(5).substring(0,10).split("-");
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
				InvoiceDateValue.setText(str1);
				Float paid=Float.parseFloat(rn.getString(6).trim());
				Float bal=Float.parseFloat(rn.getString(7).trim());
				PPaidValue.setText(paid+"");
				PBalanceValue.setText(""+(bal+paid));
			//	PPaidValue.setText(rn.getString(6).substring(0));
				PDueValue.setText(bal+"");
//				PBalanceValue.setText();
				
			 }
		 } 
		 catch (Exception e) {}
		 
		 
		 try 
		 {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			 PreparedStatement ps=conn.prepareStatement("Select P_titel from Project_details where Project_id="+Pid);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				PNameValue.setText(rs.getString(1).trim());
			 }
		 } 
		 catch (Exception e) {}
		////////////////////////////////////////////
		
		clientDetailPanel.setLayout(gbl1);
		invoicePanel.setLayout(gbl2);
		paymentDetailsPanel.setLayout(gbl3);
		////////////////////////////////////////////////////Client details panel///////////////////////////////////////////////////////////
		//////////////////////////////////////////////////
		gbc1.gridx=0;
		gbc1.gridy=0;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNameLabel, gbc1);
		clientDetailPanel.add(cNameLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=0;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNameValue, gbc1);
		clientDetailPanel.add(cNameValue);
		
		gbc1.gridx=0;
		gbc1.gridy=1;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cEmailLabel, gbc1);
		clientDetailPanel.add(cEmailLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=1;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cEmailValue, gbc1);
		clientDetailPanel.add(cEmailValue);
		
		gbc1.gridx=0;
		gbc1.gridy=2;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cAddressLabel, gbc1);
		clientDetailPanel.add(cAddressLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=2;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cAddressValue, gbc1);
		clientDetailPanel.add(cAddressValue);
		
		
		gbc1.gridx=0;
		gbc1.gridy=3;
		gbc1.anchor=GridBagConstraints.WEST;
		gbl1.setConstraints(cNumberLabel, gbc1);
		clientDetailPanel.add(cNumberLabel);
		
		gbc1.gridx=1;
		gbc1.gridy=3;
		gbc1.anchor=GridBagConstraints.WEST;	
		gbl1.setConstraints(cNumberValue, gbc1);
		clientDetailPanel.add(cNumberValue);
		
		//////////////////////////////////////////////////Invoice Details//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////
		gbc2.gridx=0;
		gbc2.gridy=0;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceLabel, gbc2);
		invoicePanel.add(InvoiceLabel);
		
		gbc2.gridx=1;
		gbc2.gridy=0;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceValue, gbc2);
		invoicePanel.add(InvoiceValue);
		
		
		gbc2.gridx=0;
		gbc2.gridy=1;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceDateLabel, gbc2);
		invoicePanel.add(InvoiceDateLabel);
		
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.anchor=GridBagConstraints.WEST;
		gbl2.setConstraints(InvoiceDateValue, gbc2);
		invoicePanel.add(InvoiceDateValue);
		
		/////////////////////////////////////////////////Payment details//////////////////////////////////////////////////
		////////////////////////////////////////////////
		
		gbc3.weightx=2;
		gbc3.gridx=0;
		gbc3.gridy=0;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PIDLabel, gbc3);
		paymentDetailsPanel.add(PIDLabel);
		
	
		gbc3.gridx=1;
		gbc3.gridy=0;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PIDValue, gbc3);
		paymentDetailsPanel.add(PIDValue);
		
		
		gbc3.gridx=0;
		gbc3.gridy=1;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PNameLabel, gbc3);
		paymentDetailsPanel.add(PNameLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=1;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PNameValue, gbc3);
		paymentDetailsPanel.add(PNameValue);
		
		gbc3.gridx=0;
		gbc3.gridy=2;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PTotalLabel, gbc3);
		paymentDetailsPanel.add(PTotalLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=2;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PTotalValue, gbc3);
		paymentDetailsPanel.add(PTotalValue);
		
		gbc3.gridx=0;
		gbc3.gridy=3;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PBalanceLabel, gbc3);
		paymentDetailsPanel.add(PBalanceLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=3;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PBalanceValue, gbc3);
		paymentDetailsPanel.add(PBalanceValue);
		
		
		gbc3.gridx=0;
		gbc3.gridy=4;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PPaidLabel, gbc3);
		paymentDetailsPanel.add(PPaidLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=4;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PPaidValue, gbc3);
		paymentDetailsPanel.add(PPaidValue);
		
		gbc3.gridx=0;
		gbc3.gridy=5;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PDueLabel, gbc3);
		paymentDetailsPanel.add(PDueLabel);
		
		gbc3.gridx=1;
		gbc3.gridy=5;
		gbc3.anchor=GridBagConstraints.WEST;
		gbl3.setConstraints(PDueValue, gbc3);
		paymentDetailsPanel.add(PDueValue);
	
		//////////////////////
		reciptpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainpanel.setLayout(b1);
		mainpanel.setBorder(new EmptyBorder(70, 400, 300, 500));
		print.setPreferredSize(new Dimension(100,40));
		Mail.setPreferredSize(new Dimension(100,40));
		Bpanel.setBorder(new EmptyBorder(30,50,10,50));
		Bpanel.add(print);
		Bpanel.add(Mail);
		
		
		infoPanel.setLayout(gl2);
		
		infoPanel.add(clientDetailPanel);
		infoPanel.add(invoicePanel);
		
		paymentDetailsmainpanel.add(paymentDetailsPanel);
		reciptpanel.setLayout(gl1);
		reciptpanel.setBackground(Color.WHITE);
		
		reciptpanel.add(infoPanel);
		reciptpanel.add(paymentDetailsmainpanel);
	
		mainpanel.add(reciptpanel,BorderLayout.CENTER);
		
		mainpanel.add(Bpanel,BorderLayout.SOUTH);
		ReciptFrame.add(mainpanel);
		
		ReciptFrame.setLocation(0,0);
		
		ReciptFrame.setSize(d);
	
		ReciptFrame.setResizable(false);
		ReciptFrame.setMaximizable(false);
		
		
	
		ReciptFrame.setClosable(true);
		ReciptFrame.setVisible(true);
		

		
	}
	
	

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	public static void main(String[] args) 
	{
//			new Payment_recipte("","","");
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==print)
		{
			OutputStream out;
			Dimension D=reciptpanel.getSize();
			BufferedImage image=new BufferedImage(D.width,D.height,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2=image.createGraphics();
			
			reciptpanel.paint(g2);
			String path="C:/Users/dell/Documents/INVOICE_img"+InvoiceValue.getText()+".jpg";
			try {
				out=new FileOutputStream(path);
				JPEGImageEncoder encode=JPEGCodec.createJPEGEncoder(out);
				encode.encode(image);
				out.close();
				
			} catch (Exception e) {}
			
			PrinterJob pjob = PrinterJob.getPrinterJob();
			PageFormat preformat = pjob.defaultPage();
			preformat.setOrientation(PageFormat.PORTRAIT);
			PageFormat postformat = pjob.pageDialog(preformat);
			//If user does not hit cancel then print.
			if (preformat != postformat) {
			    //Set print component
			    pjob.setPrintable(new Printer(reciptpanel), postformat);
			    if (pjob.printDialog()) {
			        try {
						pjob.print();
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
			JOptionPane.showMessageDialog(ReciptFrame, "Recipt is Printed!!!!");
		}
		else if(Mail==evt.getSource())
		{

		}
		
	}
	
	public static class Printer implements Printable {
	    final Component comp;

	    public Printer(Component comp){
	        this.comp = comp;
	    }

	    public int print(Graphics g, PageFormat format, int page_index) throws PrinterException {
	        if (page_index > 0) {
	            return Printable.NO_SUCH_PAGE;
	        }

	        // get the bounds of the component
	        Dimension dim = comp.getSize();
	        
	      
	        double cHeight = dim.getHeight();
	        double cWidth = dim.getWidth();
//	        double cHeight =3580;
//	        double cWidth = 2480;

	        // get the bounds of the printable area
	        double pHeight = format.getImageableHeight();
	        double pWidth = format.getImageableWidth();

	        double pXStart = format.getImageableX();
	        double pYStart = format.getImageableY();
	        
	        double xRatio = pWidth / cWidth;
	        double yRatio = pHeight / cHeight;
	      

	        Graphics2D g2 = (Graphics2D) g;

	        g2.translate(pXStart, pYStart);
	        
	        
//	        g2.translate(62, 62);
//	        g2.scale(xRatio, yRatio);
	        g2.scale(0.463, 0.65);
	        comp.paint(g2);

	        return Printable.PAGE_EXISTS;
	    }
	}
	

}
