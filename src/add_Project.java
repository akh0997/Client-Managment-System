import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.java_cup.internal.Main;
public class add_Project implements ActionListener
{
//	JFrame frame;
//	JDesktopPane pane;
	
	JInternalFrame AddProjectFrame;
	JPanel Panel,mainpanel,bottompanel,toppanel;
	
	JLabel HeadingLabel;
	
	JLabel PTitelLabel,PLangLabel,PDurationLabel,PClientLabel,PCostLabel,PDiscriptionLabel;
	JTextField PTitelText,PLangText,PDurationText,PClientText,PCostText;
	
	ImageIcon TitelIcon,LangIcon,DurationIcon,ClientIcon,CostIcon;
	Image titelimg,langimg,durationimg,clientimg,costimg;
	JLabel titellabelicon,langlabelicon,durationlabelicon,clientlabelicon,costlabelicon;
	
	BorderLayout b1;
	JTextArea PDiscriptionText;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton SubmitB,ResetB;
	public add_Project()
	{
//		frame=new JFrame("demo") ;
//		pane=new JDesktopPane();
		AddProjectFrame =new JInternalFrame("demo");
		Panel=new JPanel();
		mainpanel=new JPanel();
		bottompanel=new JPanel();
		toppanel=new JPanel();
		
		b1=new BorderLayout();
		
		mainpanel.setBorder(new EmptyBorder(30,30,60,30));
		
		HeadingLabel=new JLabel("Add Project");
		PTitelLabel=new JLabel("Project titel::");
		PLangLabel=new JLabel("Project Lang::");
		PDurationLabel=new JLabel("Project Duration::");
		PClientLabel=new JLabel("Client::");
		PCostLabel=new JLabel("Project Cost::");
		PDiscriptionLabel=new JLabel("Project Discription :");
		
		HeadingLabel.setFont(new Font("Taohma",Font.PLAIN,40));
		PTitelLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PLangLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PDurationLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PClientLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PCostLabel.setFont(new Font("Taohma",Font.BOLD,28));
		PDiscriptionLabel.setFont(new Font("Taohma",Font.BOLD,28));
		
		
		PTitelText=new JTextField(20);
		PLangText=new JTextField(20);
		
		PDurationText=new JTextField(20);
		PClientText=new JTextField(20);
		PCostText=new JTextField(20);
		
		PDiscriptionText=new JTextArea(5,25);
		PDiscriptionText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		PTitelText.setFont(new Font("Taohma",Font.PLAIN,20));
		PLangText.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PDurationText.setFont(new Font("Taohma",Font.PLAIN,20));
		PClientText.setFont(new Font("Taohma",Font.PLAIN,20));
		PCostText.setFont(new Font("Taohma",Font.PLAIN,20));

		PDiscriptionText.setFont(new Font("Taohma",Font.PLAIN,20));
		
		PTitelText.setMargin(new Insets(5,5,5,5));
		PLangText.setMargin(new Insets(5,5,5,5));
		
		PDurationText.setMargin(new Insets(5,5,5,5));
		PClientText.setMargin(new Insets(5,5,5,5));
		PCostText.setMargin(new Insets(5,5,5,5));
		
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		
		TitelIcon=new ImageIcon("E:/projectpic/ptitel.png");
		titelimg=TitelIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		LangIcon=new ImageIcon("E:/projectpic/pencil.png");
		langimg=LangIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		DurationIcon=new ImageIcon("E:/projectpic/duration.png");
		durationimg=DurationIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		ClientIcon=new ImageIcon("E:/projectpic/client2.png");
		clientimg=ClientIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		CostIcon=new ImageIcon("E:/projectpic/cost2.png");
		costimg=CostIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		titellabelicon=new JLabel(new ImageIcon(titelimg));
		langlabelicon=new JLabel(new ImageIcon(langimg));
		durationlabelicon=new JLabel(new ImageIcon(durationimg));
		clientlabelicon=new JLabel(new ImageIcon(clientimg));
		costlabelicon=new JLabel(new ImageIcon(costimg));
		
		
		///////////////////////////////////////////
		//////////////////////////////////////////
		
		SubmitB=new JButton("Submit");
		ResetB=new JButton("Reset");
		
		mainpanel.setLayout(b1);
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		SubmitB.setFont(new Font("Taohma",Font.PLAIN,20));
		ResetB.setFont(new Font("Taohma",Font.PLAIN,20));
		
		SubmitB.setMargin(new Insets(10,10,10,10));
		ResetB.setMargin(new Insets(10,10,10,10));
		
		Panel.setLayout(gbl);
		gbc.gridx=200;
		gbc.insets= new Insets(10,10,10,10);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PTitelLabel, gbc);
		Panel.add(PTitelLabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(PTitelText, gbc);
		Panel.add(PTitelText);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(titellabelicon, gbc);
		Panel.add(titellabelicon);
		
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PLangLabel, gbc);
		Panel.add(PLangLabel);
		
		gbc.gridx=1;
		gbc.gridy=1;	
		gbl.setConstraints(PLangText, gbc);
		Panel.add(PLangText);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbl.setConstraints(langlabelicon, gbc);
		Panel.add(langlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PDurationLabel, gbc);
		Panel.add(PDurationLabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(PDurationText, gbc);
		Panel.add(PDurationText);
		
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbl.setConstraints(durationlabelicon, gbc);
		Panel.add(durationlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PClientLabel, gbc);
		Panel.add(PClientLabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(PClientText, gbc);
		Panel.add(PClientText);
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbl.setConstraints(clientlabelicon, gbc);
		Panel.add(clientlabelicon);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PCostLabel, gbc);
		Panel.add(PCostLabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(PCostText, gbc);
		Panel.add(PCostText);
		
		gbc.gridx=2;
		gbc.gridy=5;
		gbl.setConstraints(costlabelicon, gbc);
		Panel.add(costlabelicon);
		
		
	
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.anchor=GridBagConstraints.WEST;
		gbl.setConstraints(PDiscriptionLabel, gbc);
		Panel.add(PDiscriptionLabel);
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbc.gridheight=10;
		gbc.gridwidth=10;
		gbl.setConstraints(PDiscriptionText, gbc);
		Panel.add(PDiscriptionText);
//		
//		gbc.gridx=0;
//		gbc.gridy=18;
//		gbc.anchor=GridBagConstraints.WEST;
//		gbl.setConstraints(SubmitB, gbc);
//		Panel.add(SubmitB);
//		
//		gbc.gridx=1;
//		gbc.gridy=18;
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

		AddProjectFrame.add(mainpanel);
		AddProjectFrame.setLocation(0,0);
		AddProjectFrame.setSize(800,800);
		AddProjectFrame.setResizable(true);
		AddProjectFrame.setMaximizable(true);
		AddProjectFrame.setIconifiable(true);
		AddProjectFrame.setClosable(true);
		AddProjectFrame.setVisible(true);
		
//		pane.setLayout(null);
//		pane.add(AddProjectFrame);
//		frame.add(pane);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		
		//new add_Project();
	}

	public void actionPerformed(ActionEvent evt) 
	{
	
		if(evt.getSource()==SubmitB)
		{
			if(PTitelText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Project titel is required");
				
			}
			else if(PLangText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Project language is required");
			}
			else if(PDurationText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Project Duration is required");
			}
			else if(PClientText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Client id is required");
			}
			else if(PCostText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Project cost is required");
			}
			else if(PDiscriptionText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(AddProjectFrame, "Project Discription is required");
			}
			else
			{
				try
				{
					
						
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						
						java.sql.Connection conn=DriverManager.getConnection("jdbc:odbc:MyDsn");
						PreparedStatement ps=conn.prepareStatement("insert into Project_details(P_titel,P_language,P_duration,P_client,p_cost,P_discription) values(?,?,?,?,?,?)");
						ps.setString(1, PTitelText.getText());
						ps.setString(2, PLangText.getText());
						ps.setString(3, PDurationText.getText());
						ps.setString(4, PClientText.getText());
						ps.setString(5, PCostText.getText());
						ps.setString(6, PDiscriptionText.getText());
						int i=ps.executeUpdate();
						if(i>0)
						{
							PTitelText.setText("");
							PLangText.setText("");
							PDurationText.setText("");
							PClientText.setText("");
							PCostText.setText("");
							PDiscriptionText.setText("");
							JOptionPane.showMessageDialog(AddProjectFrame, "Project Added Succesfully");
						}
						else
						{
							
							JOptionPane.showMessageDialog(AddProjectFrame, "Fail to add Project");
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
			PTitelText.setText("");
			PLangText.setText("");
			PDurationText.setText("");
			PClientText.setText("");
			PCostText.setText("");
			PDiscriptionText.setText("");
		}
	}

}
