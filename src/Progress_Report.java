import java.awt.*;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.RemarshalException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.sun.java_cup.internal.Main;
import com.sun.org.apache.regexp.internal.recompile;
public class Progress_Report implements ItemListener ,ActionListener 
{
	JInternalFrame ProgressReportFrame;
	
	JPanel mainpanel,cbpanel,tablepanel,cbmainpanel,cbtopPanel,cbbottomPanel;
	
	JComboBox CBEmployee,CBproject;
	JLabel ProgStatus,Employee,Project;
	JCheckBox Finished;
	JTable Tabel;
	JScrollPane scroll;
	JButton submit;
	
	JLabel HeadingLabel;
	
	ImageIcon EmployeeIcon,ProjectIcon;
	Image employeeimg,projectimg ;
	JLabel employeelabelicon,projectlabelicon;
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	GridLayout gl;
	GridBagConstraints gbc;
	GridBagLayout gbl;
	JTextArea ProgStatustext;
	int row; 
	BorderLayout b1,b2;
	String[] projects;
	public Progress_Report() 
	{
		ProgressReportFrame=new JInternalFrame("Demo");
		mainpanel=new JPanel();
		cbpanel=new JPanel();
		tablepanel=new JPanel();
		
		cbmainpanel=new JPanel();
		cbtopPanel=new JPanel();
		cbbottomPanel=new JPanel();
		
		b2=new BorderLayout();
		
		cbmainpanel.setBorder(new EmptyBorder(20,10,10,20));
		cbmainpanel.setLayout(b2);
		
		
		CBEmployee=new JComboBox();
		CBproject=new JComboBox();
		HeadingLabel=new JLabel("Progress Report");
		ProgStatus =new JLabel("Project status  :: ");
		Project=new JLabel("Project  ::");
		Employee=new JLabel("Employee  ::");
		Finished=new JCheckBox("Finished");
		submit=new JButton("Submit");
		gl=new GridLayout(2,1);
		gbc=new GridBagConstraints();
		gbl=new GridBagLayout();
		b1=new BorderLayout();
		ProgStatustext=new JTextArea(3,20);
		ProgStatustext.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		tablepanel.setLayout(b1);
		CBproject.disable();
		
		Finished.setFont(new Font("Taohma",Font.BOLD,20));
		HeadingLabel.setFont(new Font("Taohma",Font.BOLD,30));
		submit.setFont(new Font("Taohma",Font.PLAIN,24));
		CBEmployee.setFont(new Font("Taohma",Font.PLAIN,24));
		CBproject.setFont(new Font("Taohma",Font.PLAIN,24));
		
		ProgStatustext.setFont(new Font("Taohma",Font.PLAIN,20));
		ProgStatus.setFont(new Font("Taohma",Font.BOLD,24));
		Employee.setFont(new Font("Taohma",Font.BOLD,24));
		Project.setFont(new Font("Taohma",Font.BOLD,24));
		
		//Finished.setPreferredSize(new Dimension(20,20));
//		Finished.setSize(new Dimension(100,20));
		CBEmployee.setPreferredSize(new Dimension(250,30));
		CBproject.setPreferredSize(new Dimension(250,30));
		submit.setPreferredSize(new Dimension(205,30));
		
		CBproject.addItem("--select--");
		CBEmployee.addItem("--select--");
		CBEmployee.addItemListener(this);
		submit.addActionListener(this);
		
		/////////////////////////////////////////////
		////////////////////////////////////////////
		
		EmployeeIcon=new ImageIcon("E:/projectpic/emp2.png");
		employeeimg=EmployeeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		ProjectIcon=new ImageIcon("E:/projectpic/ptitel.png");
		projectimg=ProjectIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			
		employeelabelicon=new JLabel(new ImageIcon(employeeimg));
		projectlabelicon=new JLabel(new ImageIcon(projectimg));
		
		////////////////////////////////////////////////
		//////////////////////////////////////////////////
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select Emp_id from Employee_details");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CBEmployee.addItem(rs.getString(1));
			}
		} catch (Exception e) {
			
		}
		
		mainpanel.setLayout(gl);
		
		cbpanel.setLayout(gbl);
		
		gbc.gridx=200;
		gbc.insets=new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Employee, gbc);
		cbpanel.add(Employee);
	
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(CBEmployee, gbc);
		cbpanel.add(CBEmployee);
		
		gbc.gridx=2;
		gbc.gridy=0;
	
		gbl.setConstraints(employeelabelicon, gbc);
		cbpanel.add(employeelabelicon);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(Project, gbc);
		cbpanel.add(Project);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(CBproject, gbc);
		cbpanel.add(CBproject);
	
		gbc.gridx=2;
		gbc.gridy=1;
		
		gbl.setConstraints(projectlabelicon, gbc);
		cbpanel.add(projectlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(ProgStatus, gbc);
		cbpanel.add(ProgStatus);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(ProgStatustext, gbc);
		cbpanel.add(ProgStatustext);
		
		gbc.gridx=1;
		gbc.gridy=15;
		gbl.setConstraints(Finished, gbc);
		cbpanel.add(Finished);

//		gbc.gridx=1;
//		gbc.gridy=16;
//		gbl.setConstraints(submit, gbc);
//		cbpanel.add(submit);
		
		//////tabel making
		
		cbtopPanel.add(HeadingLabel);
		cbbottomPanel.add(submit);
		
		cbmainpanel.add(cbpanel,BorderLayout.CENTER);
		cbmainpanel.add(cbtopPanel,BorderLayout.NORTH);
		cbmainpanel.add(cbbottomPanel,BorderLayout.SOUTH);
		
		mainpanel.add(cbmainpanel);
		mainpanel.add(tablepanel);
		
		ProgressReportFrame.setSize(d);
		
		ProgressReportFrame.add(mainpanel);
		//ProgressReportFrame.setLocation(400,100);
		//ProgressReportFrame.setSize(800,800);
		ProgressReportFrame.setResizable(true);
		ProgressReportFrame.setIconifiable(true);
		ProgressReportFrame.setMaximizable(true);
		ProgressReportFrame.setClosable(true);
		ProgressReportFrame.setVisible(true);
			
	}
	public static void main(String[] args) 
	{
		
	}
	public void itemStateChanged(ItemEvent evt) 
	{
		if(evt.getStateChange()==ItemEvent.SELECTED)
		{
			int x=0;
			String item=(String)(evt.getItem());
			CBproject.removeAllItems();
			
			CBproject.enable();
			CBproject.insertItemAt("--select--",CBproject.getItemCount());
			
			//System.out.println(item);
			try 
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
				PreparedStatement ps=conn.prepareStatement("select Project_id  from Assign_Project where Emp_id="+item);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
//					projects[x]=rs.getString(1);
//						x++;
						//CBproject.addItem(rs.getString(1));
					CBproject.insertItemAt(rs.getString(1),CBproject.getItemCount());
				}
				
//				DefaultComboBoxModel df=new DefaultComboBoxModel(projects);
//				CBproject.setModel(df);
				CBproject.setSelectedIndex(0);
			
				
			} 
			catch (Exception e) 
			{
		
			}
			Make_tabel(item);
		}
		
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==submit)
		{
			if(Finished.isSelected())
			{
//				try {
//					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//					PreparedStatement ps=conn.prepareStatement("update Project_details set Progress='Finished' where Project_id="+(String)CBproject.getSelectedItem());
//					int j=ps.executeUpdate();
//				} 
//				catch (Exception e) {}
//				
//				
//				try {
//
//					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//					PreparedStatement ps=conn.prepareStatement("delete from Progress_details where (Project_id like "+(String)CBproject.getSelectedItem()+") and (Emp_id="+(String)CBEmployee.getSelectedItem()+")");
//					int j=ps.executeUpdate();
//				//	System.out.println(j);
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//
//				try {
//
//					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
//					PreparedStatement ps=conn.prepareStatement("delete from Assign_Project where (Project_id like "+(String)CBproject.getSelectedItem()+") and (Emp_id="+(String)CBEmployee.getSelectedItem()+")");
//					int j=ps.executeUpdate();
//				//	System.out.println(j);
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
				
				String emp,pro;
				emp=(String)CBEmployee.getSelectedItem();
				pro=(String)CBproject.getSelectedItem();
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
					
					CallableStatement call=conn.prepareCall("{call for_progress_Report(?,?,?)}");
					
					call.setString(1,pro);
					call.setString(2,emp);
					call.registerOutParameter(3,Types.INTEGER);
					call.executeUpdate();
					int a=call.getInt(3);
					if(a==1)
					{
						JOptionPane.showMessageDialog(ProgressReportFrame, "Project is completed");
					}
					else if(a==0)
					{
						JOptionPane.showMessageDialog(ProgressReportFrame, "Progress report Submitted");
					}
					else
					{
						JOptionPane.showMessageDialog(ProgressReportFrame, "Progress report not submitted Submitted");
					}
					
				} 
				catch (Exception e) {}
				
			}
			else
			{
				try 
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
					PreparedStatement ps=conn.prepareStatement("insert into Progress_details values(?,?,?)");
					ps.setString(1,(String)CBEmployee.getSelectedItem());
					ps.setString(2,(String)CBproject.getSelectedItem());
					ps.setString(3,ProgStatustext.getText() );
					int i=ps.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(ProgressReportFrame, "Record inserted!!!!!!");	
					}
				} 
				catch (Exception e) {
					
				}
			}
			CBEmployee.setSelectedIndex(0);
			CBproject.removeAllItems();
			CBproject.addItem("--select--");
			ProgStatustext.setText("");
			CBproject.disable();
			
			Make_tabel((String)CBEmployee.getSelectedItem());
		}
	}
	
	public void Make_tabel(String str)
	{
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			
			PreparedStatement ps=conn.prepareStatement("select count(*) from Progress_details where Emp_id="+str);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				row=Integer.parseInt(rs.getString(1));
			}
			tablepanel.remove(scroll);
			scroll.remove(Tabel);
			tablepanel.invalidate();
			//mainpanel.invalidate();
			ProgressReportFrame.invalidate();
		} 
		catch (Exception e) {
			
		}
		Tabel=new JTable(row,2);
		
		//Tabel.setFont(new Font("Taohma",Font.PLAIN,20));
		scroll=new JScrollPane(Tabel);
		
		Tabel.getColumnModel().getColumn(0).setHeaderValue("Project");
		Tabel.getColumnModel().getColumn(1).setHeaderValue("Status");
//		System.out.println(str);
		int i=0;
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select  a.p_titel, b.Pstatus from Project_details a join (select * from Progress_details where Emp_id="+str+") b on a.Project_id=b.Project_id;");
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				Tabel.setValueAt(rs.getString(1).trim(), i,0);
				Tabel.setValueAt(rs.getString(2).trim(), i,1);
				i++;
			}
		} 
		catch (Exception e) {
			
		}
		//scroll.add(Tabel);
		tablepanel.add(scroll);
		tablepanel.setVisible(false);
		tablepanel.setVisible(true);
		ProgressReportFrame.setVisible(false);
		ProgressReportFrame.setVisible(true);

	}

}
