import java.awt.*;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
import com.sun.jndi.ldap.Connection;
import com.sun.org.apache.bcel.internal.generic.Type;
public class assign_Project implements ActionListener
{
	JInternalFrame AssignProjectFrame;
	JPanel mainpanel,tabelpanel,cbpanel,cbmainpanel,cbtopPanel,cbbottomPanel ;
	JComboBox CBEmployee,CBProject;
	JLabel Employee,Project,Remarks;
	
	JLabel HeadingLabel;
	
	ImageIcon EmployeeIcon,ProjectIcon,RemarksIcon;
	Image employeeimg,projectimg ,remarksimg;
	JLabel employeelabelicon,projectlabelicon,remarkslabelicon;
	
	JButton Add;
	JTable Tabel;
	GridLayout Gr;
	JScrollPane Scroll;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JTextField remarkstext;
	BorderLayout b1,b2;
	int row;
	
	
	public assign_Project() 
	{
		AssignProjectFrame =new JInternalFrame("demo");
		
		mainpanel=new JPanel();
		cbpanel=new JPanel();
		tabelpanel=new JPanel();
		cbmainpanel=new JPanel();
		cbtopPanel=new JPanel();
		cbbottomPanel=new JPanel();
		
		b2=new BorderLayout();
		cbmainpanel.setLayout(b2);
		cbmainpanel.setBorder(new EmptyBorder(20,30,40,30));
		
		CBEmployee=new JComboBox();
		CBProject=new JComboBox();
		
		Employee=new JLabel("Select Employee  ::");
		Project=new JLabel("Select Project  ::");
		HeadingLabel=new JLabel("Assign Project");
		Remarks=new JLabel("Remarks  ::");
		remarkstext=new JTextField(11);
		
		
		Add=new JButton("ADD");
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		Gr=new GridLayout(2,1);
		b1=new BorderLayout();
		
		tabelpanel.setLayout(b1);
		
		Add.addActionListener(this);
		
		HeadingLabel.setFont(new Font("Taohma",Font.PLAIN,40));
		Add.setFont(new Font("Taohma",Font.BOLD,28));
		CBEmployee.setFont(new Font("Taohma",Font.PLAIN,25));
		CBProject.setFont(new Font("Taohma",Font.PLAIN,25));
		remarkstext.setFont(new Font("Taohma",Font.PLAIN,25));
		Remarks.setFont(new Font("Taohma",Font.BOLD,28));
		Employee.setFont(new Font("Taohma",Font.BOLD,28));
		Project.setFont(new Font("Taohma",Font.BOLD,28));
		
		Add.setPreferredSize(new Dimension(205,40));
		CBEmployee.setPreferredSize(new Dimension(250,30));
		CBProject.setPreferredSize(new Dimension(250,30));
		CBEmployee.addItem("--Select--");
		CBProject.addItem("--Select--");
		
		////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////
		
		EmployeeIcon=new ImageIcon("E:/projectpic/emp2.png");
		employeeimg=EmployeeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		ProjectIcon=new ImageIcon("E:/projectpic/ptitel.png");
		projectimg=ProjectIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		RemarksIcon=new ImageIcon("E:/projectpic/remarks2.png");
		remarksimg=RemarksIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		employeelabelicon=new JLabel(new ImageIcon(employeeimg));
		projectlabelicon=new JLabel(new ImageIcon(projectimg));
		remarkslabelicon=new JLabel(new ImageIcon(remarksimg));
		
		
		/////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////
		
		
		
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Project_id from Project_details where Progress='Running' or Progress='Pending'");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				CBProject.addItem(rs.getString(1));
			}

			ps=conn.prepareStatement("select Emp_id from Employee_details");
			rs=ps.executeQuery();
			while(rs.next())
			{
				CBEmployee.addItem(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		///////tabel making
		Make_Tabel();
		
		
			
		//tabelpanel.add(Scroll);
		
		cbpanel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets=new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Project,gbc);
		cbpanel.add(Project);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(CBProject,gbc);
		cbpanel.add(CBProject);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(projectlabelicon,gbc);
		cbpanel.add(projectlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Employee,gbc);
		cbpanel.add(Employee);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(CBEmployee,gbc);
		cbpanel.add(CBEmployee);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(employeelabelicon,gbc);
		cbpanel.add(employeelabelicon);
	
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Remarks,gbc);
		cbpanel.add(Remarks);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(remarkstext,gbc);
		cbpanel.add(remarkstext);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(remarkslabelicon,gbc);
		cbpanel.add(remarkslabelicon);
		
//		gbc.gridx=1;
//		gbc.gridy=3;
//		gbl.setConstraints(Add,gbc);
//		cbpanel.add(Add);
		
		cbtopPanel.add(HeadingLabel);
		cbbottomPanel.add(Add);
		
		cbmainpanel.add(cbpanel,BorderLayout.CENTER);
		cbmainpanel.add(cbtopPanel,BorderLayout.NORTH);
		cbmainpanel.add(cbbottomPanel,BorderLayout.SOUTH);
		
		
		mainpanel.setLayout(Gr);
		mainpanel.add(cbmainpanel);
		mainpanel.add(tabelpanel);
		
		AssignProjectFrame.add(mainpanel);
		AssignProjectFrame.setLocation(400,100);
		AssignProjectFrame.setSize(800,800);
		AssignProjectFrame.setResizable(true);
		AssignProjectFrame.setIconifiable(true);
		AssignProjectFrame.setMaximizable(true);
		AssignProjectFrame.setClosable(true);
		AssignProjectFrame.setVisible(true);
		
	}

	public static void main(String[] args)
	{
	
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==Add)
		{
//			if(CBEmployee.getSelectedIndex()!=0 && CBProject.getSelectedIndex()!=0 && remarkstext.getText().equals("")){}
//			else 
				
			if(CBEmployee.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(AssignProjectFrame, "Select an Employee!!!");
			}
			else if(CBProject.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(AssignProjectFrame, "Select a Project!!!");
			}
			else if(remarkstext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AssignProjectFrame, "Remarks is Required!!!");
			}
			else
			{
				int flag=0;
				ResultSet n;
				String emp=(String)CBEmployee.getSelectedItem();
				String proj=(String)CBProject.getSelectedItem();
				
				try{
					
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					
					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
					//System.out.println("hdgfsdhgfjsd");
					
					CallableStatement call=conn.prepareCall("{call for_assign_project(?,?,?,?)}");
					
					call.setString(1,proj);
					call.setString(2,emp);
					call.setString(3, remarkstext.getText());
					call.registerOutParameter(4,Types.INTEGER);
					call.executeUpdate();
					int a=call.getInt(4);
					
					if(a==0)
					{
						JOptionPane.showMessageDialog(AssignProjectFrame, "project is already assigned");
					}
					else if(a==1)
					{
						JOptionPane.showMessageDialog(AssignProjectFrame, "Record inserted");
						CBEmployee.setSelectedIndex(0);
						CBProject.setSelectedIndex(0);
						remarkstext.setText("");
						Make_Tabel();
					}
					else
					{
						JOptionPane.showMessageDialog(AssignProjectFrame, "Record not inserted");
					}
				//	System.out.println("hdgfsdhgfjsd"+a);
				}
				catch (Exception e)
				{
				
				}	
				
//				try 
//				{
//					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//					PreparedStatement ps=conn.prepareStatement("select * from Assign_Project where Project_id="+proj+" and Emp_Id="+emp);
//					n=ps.executeQuery();
//				
//					if(n.next()==false)
//					{
//						JOptionPane.showMessageDialog(AssignProjectFrame, "project is already assigned");
//					}
//					else
//					{
//						flag=1;
//					}
//				} 
//				catch (Exception e) 
//				{
//					
//				}
//				
//				if(flag==1)
//				{
//				
//					try 
//					{
//						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//						PreparedStatement ps=conn.prepareStatement("Update Project_details set Progress='Running' where Project_id="+proj);
//						int k=ps.executeUpdate();
//					
//					} 
//					catch (Exception e) 
//					{
//					
//					}
//					try 
//					{
//						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//						PreparedStatement ps=conn.prepareStatement("insert into Assign_Project(Emp_Id,Project_Id,Remarks) Values(?,?,?)");
//						ps.setString(1, emp);
//						ps.setString(2, proj);
//						ps.setString(3, remarkstext.getText());
//						int i=ps.executeUpdate();
//						if(i>0)
//						{
//							JOptionPane.showMessageDialog(AssignProjectFrame, "Record inserted");
//							CBEmployee.setSelectedIndex(0);
//							CBProject.setSelectedIndex(0);
//							remarkstext.setText("");
//							Make_Tabel();
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(AssignProjectFrame, "Record not inserted");
//						}
//					
//					} 
//					catch (Exception e) {
//						
//					}
//				}
				
			}
		}
	}
	public void Make_Tabel() 
	{
		
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Project_details a join Assign_Project b on a.Project_Id=b.Project_id join Employee_Details c on b.Emp_id=c.Emp_id");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				row=Integer.parseInt(rs.getString(1));
				
			}
			tabelpanel.remove(Scroll);
			Scroll.remove(Tabel);
			tabelpanel.invalidate();
			AssignProjectFrame.invalidate();
		}
		catch (Exception e) 
		{
			
		}
	//	System.out.println(CBEmployee.getSelectedIndex());
		
		Tabel=new JTable(row,3);
		Scroll=new JScrollPane(Tabel);
		Tabel.getTableHeader().setFont(new Font("Tohma",Font.PLAIN,20));
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Project ");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Employee");
		Tabel.getColumnModel().getColumn(2).setHeaderValue("Remarks");
		try 
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("select a.P_titel, c.E_name, b.remarks from Project_details a join Assign_Project b on a.Project_Id=b.Project_id join Employee_Details c on b.Emp_id=c.Emp_id");
				ResultSet pros=ps.executeQuery();
				int i=0;
				while(pros.next())
				{
					Tabel.setValueAt(pros.getString(1).trim(), i, 0);
					Tabel.setValueAt(pros.getString(2).trim(), i, 1);				
					Tabel.setValueAt(pros.getString(3).trim(), i, 2);
				i++;
			
			}
		} 
		catch (Exception e) {
		
		}
		tabelpanel.add(Scroll);
		tabelpanel.setVisible(false);
		tabelpanel.setVisible(true);
		AssignProjectFrame.setVisible(false);
		AssignProjectFrame.setVisible(true);
	}
	
}
