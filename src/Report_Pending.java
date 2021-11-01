import java.awt.BorderLayout;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.sun.jndi.ldap.Connection;

public class Report_Pending {

	JInternalFrame ReportPendingFrame;
	JPanel panel;
	JTable Table;
	JScrollPane scroll;
	BorderLayout b1;
	int row;
//	JFrame Frame;
//	JDesktopPane pane;
	public Report_Pending()
	{
		ReportPendingFrame=new JInternalFrame("demo");
		panel=new JPanel();
		b1=new BorderLayout();
		panel.setLayout(b1);
//		Frame=new JFrame("demo"); 
//		pane=new JDesktopPane();
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement(" select count(*) from Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details ) )");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				row=Integer.parseInt(rs.getString(1));
			}
			
		}
		catch (Exception e) 
		{
			
		}
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement(" select count (distinct ProjectId) from Billing_details where Balance not in (0)");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				row=row+Integer.parseInt(rs.getString(1));
			}
		}
		catch (Exception e) 
		{
			
		}
		
		Table=new JTable(row,5);
		Table.getColumnModel().getColumn(0).setHeaderValue("Client");
		Table.getColumnModel().getColumn(1).setHeaderValue("Project");
		Table.getColumnModel().getColumn(2).setHeaderValue("Total Cost");
		Table.getColumnModel().getColumn(3).setHeaderValue("Paid Amount");
		Table.getColumnModel().getColumn(4).setHeaderValue("Project status");
		
		int i=0;
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			//PreparedStatement ps=conn.prepareStatement("select  b.Name,a.* from (select * from  Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details )))a join  Client_details b on a.P_client=b.Client_ID");
			PreparedStatement ps=conn.prepareStatement("Select * ,Isnull((Select Sum(paid) from Billing_details where ClientID=Client_details.Client_Id and ProjectId=Project_details.Project_id) ,0)from Client_details join Project_details on Client_details.Client_Id=Project_details.P_client");
			
	//		 Select * ,Isnull((Select Sum(paid) from Billing_details where ClientID=Client_details.Client_Id and ProjectId=Project_details.Project_id) ,0)from Client_details join Project_details on Client_details.Client_Id=Project_details.P_client
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String client=rs.getString(2).trim();
				String Proj= rs.getString(7).trim();
				Float Totalamt=Float.parseFloat(rs.getString(12).trim());
				String status=rs.getString(14).trim();
				Float amt=Float.parseFloat(rs.getString(15).trim());
				Float rem=Totalamt-amt;
				if(rem!=0)
				{
				Table.getModel().setValueAt(client, i,0);
				Table.getModel().setValueAt(Proj, i,1);
				Table.getModel().setValueAt(Totalamt, i,2);
				Table.getModel().setValueAt(status, i,4);
				Table.getModel().setValueAt(rem+"", i,3);
				}
				i++;
				
			}
		}
		catch (Exception e) 
		{
			
		}
		
		scroll=new JScrollPane(Table);
		panel.add(scroll);
		ReportPendingFrame.add(panel);

		ReportPendingFrame.setLocation(400,100);
		ReportPendingFrame.setSize(800,800);
		ReportPendingFrame.setResizable(true);
		ReportPendingFrame.setMaximizable(true);
		ReportPendingFrame.setIconifiable(true);
		ReportPendingFrame.setClosable(true);
		ReportPendingFrame.setVisible(true);
		ReportPendingFrame.setFocusable(true);
		
//		pane.add(ReportPendingFrame);
//		Frame.add(ReportPendingFrame);
////		select  a.*,b.Name from (select * from  Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details )))a join  Client_details b on a.P_client=b.Client_ID 
//		Frame.setSize(800, 800);
//		Frame.setVisible(true);
////		System.out.println(""+row);
	}
	public static void main(String[] args) 
	{
		new Report_Pending();
	}
}
