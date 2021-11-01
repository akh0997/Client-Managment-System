import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Project_pending 
{
	JInternalFrame ProjectPendingFrame;
	JPanel panel;
	JTable Table;
	JScrollPane scroll;
	public Project_pending() 
	{
		ProjectPendingFrame=new JInternalFrame("Demo");
		panel=new JPanel();
		scroll=new JScrollPane();
		Table=new JTable();		
		
	}
	public static void main(String[] args) 
	{
	
	}
}
