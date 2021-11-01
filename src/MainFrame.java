import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import com.sun.java_cup.internal.Main;
public class MainFrame implements ActionListener
{	JFrame Frame;
	ImagePanel MainPanel;
	JMenuBar Menubar;
	JMenu M_Client,M_Project,M_Employee,M_Billing,M_Report;
	JMenuItem c1,c2,p1,p2,p3,e1,e2,prog,b1,b2,rp,rc;
	int acFlag=0,apFlag=0,aeFlag=0,vcFlag=0,vpFlag=0,veFlag=0,aspFlag=0,progFlag=0,pFlag=0,pdFlag=0,rpFlag=0,rcFlag=0;
	ImageIcon ClientIcon,ProjectIcon,EmployeeIcon,BillingIcon,ReportIcon;
	Image clintimg,projectimg,employeeimg,billingimg,reportimg;
	public MainFrame()
	{
		
		Frame=new JFrame("demo");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		double width=d.getWidth();
		double height=d.getHeight();
	//	MainPanel=new ImagePanel("E:/Computer_programing_Java/myjavproj/imgpanel.png",(int)(width),(int)(height));
	//	MainPanel=new ImagePanel("E:/SPIDER_MAN.png",(int)(width),(int)(height));
		MainPanel=new ImagePanel("E:/projectpic/4.jpg",(int)(width),(int)(height));
		Menubar=new JMenuBar();
		
		ClientIcon=new ImageIcon("E:/projectpic/client.png");
		clintimg=ClientIcon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
			
		ProjectIcon=new ImageIcon("E:/projectpic/project.png");
		projectimg=ProjectIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		EmployeeIcon=new ImageIcon("E:/projectpic/emp.png");
		employeeimg=EmployeeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		BillingIcon=new ImageIcon("E:/projectpic/invoice.png");
		billingimg=BillingIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		ReportIcon=new ImageIcon("E:/projectpic/report1.png");
		reportimg=ReportIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		
		M_Client=new JMenu("  Client ");
		M_Project=new JMenu("  Project ");
		M_Employee=new JMenu("  Employee ");
		M_Billing=new JMenu("  Billing ");
		M_Report= new JMenu("Report");
		
		M_Client.setIcon(new ImageIcon(clintimg));
		M_Project.setIcon(new ImageIcon(projectimg));
		M_Employee.setIcon(new ImageIcon(employeeimg));
		M_Billing.setIcon(new ImageIcon(billingimg));
		M_Report.setIcon(new ImageIcon(reportimg));	
		
		M_Client.setFont(new Font("Taohma",Font.PLAIN,20));
		M_Employee.setFont(new Font("Taohma",Font.PLAIN,20));
		M_Project.setFont(new Font("Taohma",Font.PLAIN,20));
		M_Billing.setFont(new Font("Taohma",Font.PLAIN,20));
		M_Report.setFont(new Font("Taohma",Font.PLAIN,20));
		
		c1=new JMenuItem("Add Client");
		c2=new JMenuItem("View Client");
		p1=new JMenuItem("Add Project");
		p2=new JMenuItem("View Project");
		p3=new JMenuItem("Assign Project");
		e1=new JMenuItem("Add Employee");
		e2=new JMenuItem("View Employee");
		b1=new JMenuItem("Make Payment ");
		b2=new JMenuItem("Payment Details");
		rp=new JMenuItem("Pending  ");
		rc=new JMenuItem("Complete");
		prog=new JMenuItem("Progress");
		
		prog.setFont(new Font("Taohma",Font.PLAIN,20));
		c1.setFont(new Font("Taohma",Font.PLAIN,20));
		c2.setFont(new Font("Taohma",Font.PLAIN,20));
		p1.setFont(new Font("Taohma",Font.PLAIN,20));
		p2.setFont(new Font("Taohma",Font.PLAIN,20));
		p3.setFont(new Font("Taohma",Font.PLAIN,20));
		e1.setFont(new Font("Taohma",Font.PLAIN,20));
		e2.setFont(new Font("Taohma",Font.PLAIN,20));
		b1.setFont(new Font("Taohma",Font.PLAIN,20));
		b2.setFont(new Font("Taohma",Font.PLAIN,20));
		rp.setFont(new Font("Taohma",Font.PLAIN,20));
		rc.setFont(new Font("Taohma",Font.PLAIN,20));
		
		prog.addActionListener(this);
		c1.addActionListener(this);
		c2.addActionListener(this);
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		e1.addActionListener(this);
		e2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		rp.addActionListener(this);
		rc.addActionListener(this);
		
		M_Client.add(c1);
		M_Client.add(c2);
		M_Project.add(p1);
		M_Project.add(p2);
		M_Project.add(p3);
		M_Employee.add(e1);
		M_Employee.add(e2);
		M_Billing.add(b1);
		M_Billing.add(b2);
		M_Employee.add(prog);
		M_Report.add(rp);
		M_Report.add(rc);
		
		MainPanel.setLayout(null);

		Menubar.add(M_Client);
		Menubar.add(M_Project);
		Menubar.add(M_Employee);
		Menubar.add(M_Billing);
		Menubar.add(M_Report);
				
		Frame.setJMenuBar(Menubar);
		
		Frame.add(MainPanel);
		Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new MainFrame();

	}
	
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==c1)
		{	
			if(acFlag==0)
			{
			//	Frame.remove(MainPanel);
				add_Client obj;
				obj=new add_Client();
				obj.AddClientFrame.addInternalFrameListener(new addclientlis());
				MainPanel.add(obj.AddClientFrame);
				obj.AddClientFrame.moveToFront();
				try 
				{
					   obj.AddClientFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			//	Frame.add(MainPanel);
				acFlag=1;
			}
			else
			{
				
			}
		}
		if(evt.getSource()==p1)
		{
			if(apFlag==0)
			{
			//	Frame.remove(MainPanel);
				add_Project obj;
				obj=new add_Project();
				obj.AddProjectFrame.addInternalFrameListener(new addprojlis());
				MainPanel.add(obj.AddProjectFrame);
				obj.AddProjectFrame.moveToFront();
				try 
				{
					   obj.AddProjectFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			//	Frame.add(MainPanel);
				apFlag=1;
			}
			else
			{
				
			}
		}
		if(evt.getSource()==e1)
		{
			if(aeFlag==0)
			{
			//	Frame.remove(MainPanel);
				add_Employee obj;
				obj=new add_Employee();
				obj.AddEmployeeFrame.addInternalFrameListener(new addemplis());
			
				MainPanel.add(obj.AddEmployeeFrame);
				obj.AddEmployeeFrame.moveToFront();
				try 
				{
					   obj.AddEmployeeFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
				//Frame.add(MainPanel);
				aeFlag=1;
			}
			else
			{
				
			}
		}
		if(evt.getSource()==c2)
		{
			if(vcFlag==0)
			{
				//Frame.remove(MainPanel);
				view_Client obj;
				obj=new view_Client();
				obj.ViewClientFrame.addInternalFrameListener(new viewclietlis());
				MainPanel.add(obj.ViewClientFrame);
				obj.ViewClientFrame.moveToFront();
				try 
				{
					   obj.ViewClientFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
				//		Frame.add(MainPanel);
				vcFlag=1;
			}
			else
			{
				
			}
		}
		
		
		
		
		if(evt.getSource()==p2)
		{
			if(vpFlag==0)
			{
				//Frame.remove(MainPanel);
				view_Project obj;
				obj=new view_Project();
				obj.ViewProjectFrame.addInternalFrameListener(new viewprojlis());
				MainPanel.add(obj.ViewProjectFrame);
				obj.ViewProjectFrame.moveToFront();
				try 
				{
					   obj.ViewProjectFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
				//	Frame.add(MainPanel);
				vpFlag=1;
			}
			else
			{
				
			}
		
		}
		
		if(evt.getSource()==p3)
		{
			if(aspFlag==0)
			{
				//Frame.remove(MainPanel);
				assign_Project obj;
				obj=new assign_Project();
				obj.AssignProjectFrame.addInternalFrameListener(new assprojlis());
				MainPanel.add(obj.AssignProjectFrame);
				obj.AssignProjectFrame.moveToFront();
				try 
				{
					   obj.AssignProjectFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
				//	Frame.add(MainPanel);
				aspFlag=1;
			}
			else
			{
				
			}
			
			
		}
		
		/////////////////////////////////////////////////
		/////////////////////////////////////////////////
		
		if(evt.getSource()==prog)
		{
			if(progFlag==0)
			{
				//Frame.remove(MainPanel);
				Progress_Report obj;
				obj=new Progress_Report();
				obj.ProgressReportFrame.addInternalFrameListener(new progresslis());
				MainPanel.add(obj.ProgressReportFrame);
				obj.ProgressReportFrame.moveToFront();
				try 
				{
					   obj.ProgressReportFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
				//	Frame.add(MainPanel);
				progFlag=1;
			}
			else
			{
				
			}
		}
		
		
		if(evt.getSource()==e2)
		{
			if(veFlag==0)
			{
				//Frame.remove(MainPanel);
				view_Employee obj;
				obj=new view_Employee();
				obj.ViewEmployeeFrame.addInternalFrameListener(new viewemplis());
				
				MainPanel.add(obj.ViewEmployeeFrame);
				obj.ViewEmployeeFrame.moveToFront();
				try 
				{
					   obj.ViewEmployeeFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			
				veFlag=1;
			}
			else
			{
				
			}
		}	
		///////////////////////////////////////billing/////////////////////////////////////
		if(evt.getSource()==b1)
		{
			if(pFlag==0)
			{
				//Frame.remove(MainPanel);
				Billing obj;
				obj=new Billing();
				obj.BillingFrame.addInternalFrameListener(new paymentlis());
				
				MainPanel.add(obj.BillingFrame);
				obj.BillingFrame.moveToFront();
				try 
				{
					   obj.BillingFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			
				pFlag=1;
			}
			else
			{
				
			}
		}	
		//////////////////////////////////////
		if(evt.getSource()==b2)
		{
			if(pdFlag==0)
			{
				//Frame.remove(MainPanel);
				Payment_details obj;
				obj=new Payment_details();
				obj.paymentDetailsFrame.addInternalFrameListener(new paymentdetailslis());
				
				MainPanel.add(obj.paymentDetailsFrame);
				obj.paymentDetailsFrame.moveToFront();
				try 
				{
					   obj.paymentDetailsFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			
				pdFlag=1;
			}
			else
			{
				
			}
		}
		
		//////////////////////////////////////////////////////
		
		if(evt.getSource()==rp)
		{
			if(rpFlag==0)
			{
				//Frame.remove(MainPanel);
				Report_Pending obj;
				obj=new Report_Pending();
				obj.ReportPendingFrame.addInternalFrameListener(new reportpendinglis());
				
				MainPanel.add(obj.ReportPendingFrame);
				obj.ReportPendingFrame.moveToFront();
				try 
				{
					   obj.ReportPendingFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			
				rpFlag=1;
			}
			else
			{
				
			}
		}
		
		if(evt.getSource()==rc)
		{
			if(rcFlag==0)
			{
				//Frame.remove(MainPanel);
				Report_complete obj;
				obj=new Report_complete();
				obj.ReportCompleteFrame.addInternalFrameListener(new reportcompletelis());
				
				MainPanel.add(obj.ReportCompleteFrame);
				obj.ReportCompleteFrame.moveToFront();
				try 
				{
					   obj.ReportCompleteFrame.setSelected(true);
						
				} catch (Exception e) {
				
				}
			
				rcFlag=1;
			}
			else
			{
				
			}
		}
		
		
		
	}
	
/////////////////////////////////////////////////////internalframe lisners /////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	class addclientlis implements InternalFrameListener      ////add client frame listner
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}
	
		public void internalFrameClosing(InternalFrameEvent arg0) {
			acFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	class addprojlis implements InternalFrameListener     ////////////////add project lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			apFlag=0;
			}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	class addemplis implements InternalFrameListener            /////////////add employee lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			aeFlag=0;
			
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	class viewclietlis implements InternalFrameListener           /////////////view  client lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			vcFlag=0;
			}
		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	class viewprojlis implements InternalFrameListener           /////////////view  project lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			vpFlag=0;
		}
		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	class viewemplis implements InternalFrameListener          /////////////view  employee  lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
		
	}
	class assprojlis implements InternalFrameListener       /////////////////ass Project lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			aspFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {	}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}	
	}
	
	class progresslis implements InternalFrameListener     ////////////////Progress lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			progFlag=0;
			}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}
		
	}
	
	class paymentlis implements InternalFrameListener              /////////////////payment  lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {
			
			pFlag=0;
		}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			pFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {	}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}	
	}
	
	class paymentdetailslis implements InternalFrameListener          ////////////////////////////payment details lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {
			
			pdFlag=0;
		}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			pdFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {	}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}	
	}
	
	class reportpendinglis implements InternalFrameListener          ////////////////////////////payment details lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {
			
			rpFlag=0;
		}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			rpFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {	}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}	
	}
	
	class reportcompletelis implements InternalFrameListener          ////////////////////////////payment details lis
	{

		public void internalFrameActivated(InternalFrameEvent arg0) {}

		public void internalFrameClosed(InternalFrameEvent arg0) {
			
			rcFlag=0;
		}

		public void internalFrameClosing(InternalFrameEvent arg0) {
			rcFlag=0;
		}

		public void internalFrameDeactivated(InternalFrameEvent arg0) {}

		public void internalFrameDeiconified(InternalFrameEvent arg0) {	}

		public void internalFrameIconified(InternalFrameEvent arg0) {}

		public void internalFrameOpened(InternalFrameEvent arg0) {}	
	}
	
	
}



