import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
import sun.net.www.content.text.plain;
import sun.security.provider.SystemIdentity;
import java.awt.event.*;
public class Client_management implements ActionListener
{
	JFrame Frame;
	//JPanel MainePanel;
	JDesktopPane MainePanel;
	JTextField login_id;
	JPasswordField login_pas;
	JLabel login_user,login_password;
	JButton loginB;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f;
	
	public Client_management() 
	{
		Frame=new JFrame("Demo");
		//MainePanel=new JPanel();
		MainePanel=new JDesktopPane();
		f=new Font("Tahoma",Font.PLAIN, 30);
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		gbc.gridy=200;
		
		gbc.insets= new Insets(10,10,10,10);
		MainePanel.setLayout(gbl);
		
		login_id=new JTextField(10);
		login_pas=new JPasswordField(10);
		login_id.setFont(new Font("Tahoma",Font.PLAIN, 25));
		login_pas.setFont(new Font("Tahoma",Font.PLAIN, 25));
		login_id.setMargin(new Insets(5,5,5,5));
		login_pas.setMargin(new Insets(5,5,5,5));
		
		login_user=new JLabel("Enter Username::");
		login_password=new JLabel("Enter Password ::");
		login_user.setFont(f);
		login_password.setFont(f);
		
		
		loginB=new JButton("LogIn");
		loginB.setPreferredSize(new Dimension(465,60));
		loginB.setFont(f);
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(login_user,gbc);
		
		loginB.addActionListener(this);
		
		MainePanel.add(login_user);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(login_id,gbc);
		MainePanel.add(login_id);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(login_password,gbc);
		MainePanel.add(login_password);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(login_pas,gbc);
		MainePanel.add(login_pas);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=2;
		gbl.setConstraints(loginB,gbc);
		MainePanel.add(loginB);
		
		Frame.add(MainePanel);
		//Frame.setSize(500, 500);
		Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Frame.setVisible(true);
		
	}
	public static void main(String[] args) 
	{
		new Client_management();

	}
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==loginB)
		{
			try{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:MyDsn");
				String text = login_pas.getText();
				PreparedStatement ps=con.prepareStatement("select * from user_detail where user_name='"+login_id.getText()+"' and user_pass='"+text+"'");
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					Frame.dispose();
					MainFrame obj;
					obj=new MainFrame();
					System.out.println("succes");
				}
				else
				{
					JOptionPane.showMessageDialog(Frame, "Invalid Password or User Id");
					login_id.setText("");
					login_pas.setText("");
					
				}
			}
			catch(Exception ee)
			{
				System.out.print(ee);
			}
			
			//System.out.println("succes");
		
			
			
		}
		
	}
}
