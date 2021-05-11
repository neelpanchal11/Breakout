package Elements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ball
{
		public float x;
		public float y;

		public int step = 5;
		float angle = 0;
		public boolean east = true, south = false;
		public static int r = 36;

		
		public ball(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		  public void draw(Graphics g)
		  {
			  g.setColor(new Color(255, 255, 255));
			  g.fillOval((int)this.x, (int)this.y, this.r, this.r);  
			  
		  }

		
		public void motion()
		{
			this.x = this.x + (east?step+angle:-step-angle);
			this.y = this.y + (south?step-angle:-step+angle);
		}
		
		public void bounce_h(boolean trig)
		{
			east = !(!east ^ trig);
		}
		
		public void bounce_v(boolean trig)
		{
			south = !(!south ^ trig);
		}
		
		public void paddle_hit(boolean trig, boolean diff)
		{
			south = south && !trig;
			angle = (float) (angle + (trig?(east ^ diff?0.5:-0.5):0));
			angle = Math.min(Math.max(angle, -step/2), step/2); // Angle range from 26 degrees to 63 degrees
			sound paddle_hit = trig?new sound("sounds\\paddle_hit.wav"):null;
			
		}
}