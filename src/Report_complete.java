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
public class Report_complete {

	JInternalFrame ReportCompleteFrame;
	JPanel panel;
	JTable Table;
	JScrollPane scroll;
	BorderLayout b1;
	int row;
//	JFrame Frame;
//	JDesktopPane pane;
	public Report_complete()
	{
		ReportCompleteFrame=new JInternalFrame("demo");
		panel=new JPanel();
		b1=new BorderLayout();
		panel.setLayout(b1);
//		Frame=new JFrame("demo"); 
//		pane=new JDesktopPane();
		
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select count(*) from Billing_details where Balance in(0)");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				row=Integer.parseInt(rs.getString(1));
			}
		}
		catch (Exception e)
		{
		
		}
		Table=new JTable(row,4);
		Table.getColumnModel().getColumn(0).setHeaderValue("Client");
		Table.getColumnModel().getColumn(1).setHeaderValue("Project");
		Table.getColumnModel().getColumn(2).setHeaderValue("Total Cost");
		Table.getColumnModel().getColumn(3).setHeaderValue("Status");
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
			PreparedStatement ps=conn.prepareStatement("select a.Name,c.P_titel ,c.Progress,b.* from Client_details a join( select * from Billing_details where Balance in(0)) b on a.Client_Id=b.ClientID join Project_details c on c.Project_id=b.ProjectId");
		//	select a.Name,c.P_titel , b.* from Client_details a join( select * from Billing_details where Balance in(0)) b on a.Client_Id=b.ProjectId joinProject_details c on c.Project_id=b.ProjectId
			
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				Table.getModel().setValueAt(rs.getString(1).trim(), i, 0);
				Table.getModel().setValueAt(rs.getString(2).trim(), i, 1);
				Table.getModel().setValueAt(rs.getString(3).trim(), i, 3);
				Table.getModel().setValueAt(rs.getString(7).trim(), i, 2);
				i++;
			}
		}
		catch (Exception e)
		{
		
		}
		scroll=new JScrollPane(Table);
		panel.add(scroll);
		ReportCompleteFrame.add(panel);

		ReportCompleteFrame.setLocation(400,100);
		ReportCompleteFrame.setSize(800,800);
		ReportCompleteFrame.setResizable(true);
		ReportCompleteFrame.setMaximizable(true);
		ReportCompleteFrame.setIconifiable(true);
		ReportCompleteFrame.setClosable(true);
		ReportCompleteFrame.setVisible(true);
		ReportCompleteFrame.setFocusable(true);
		
//		pane.add(ReportCompleteFrame);
//		Frame.add(ReportCompleteFrame);
////		select  a.*,b.Name from (select * from  Project_details where Project_id in(select Project_id from Project_details where Project_id not in (Select distinct ProjectId from Billing_details )))a join  Client_details b on a.P_client=b.Client_ID 
//		Frame.setSize(800, 800);
//		Frame.setVisible(true);
//		System.out.println(""+row);
		
	}

	
	public static void main(String[] args) {
	new Report_complete();

	}

}
