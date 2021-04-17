package Elements;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ball
{
		public int x;
		public int y;
		int step = 5;
		public boolean east = false, south = false;
		public static int r = 36;
		
		public ball(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public void draw(Graphics g) 
		{
			  g.fillOval(this.x, this.y, r, r);
		}
		
		public void motion()
		{
			this.x = this.x + (east?step:-step);
			this.y = this.y + (south?step:-step);
		}
		
		public static class box extends Rectangle
		{

		}
}