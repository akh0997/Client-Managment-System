import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
public class ImagePanel extends JDesktopPane{
	ImageIcon Icon;
	int width,height ;
	String s;
	public ImagePanel(String image ,int a,int b) 
	{
		this.s=image;
		width=a;
		height=b;
	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Icon=new ImageIcon(s);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(Icon.getImage(), 0, 0, width ,height , null);
	}
}
