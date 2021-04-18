package Elements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ball
{
		public int x;
		public int y;

		int step = 1;
		public boolean east = false, south = false;
		public static int r = 36;

		
		public ball(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		  public void draw(Graphics g)
		  {
			  g.setColor(new Color(255, 255, 255));
			  g.fillOval(this.x, this.y, this.r, this.r);  
			  
		  }

		
		public void motion()
		{
			this.x = this.x + (east?step:-step);
			this.y = this.y + (south?step:-step);
		}
		
}