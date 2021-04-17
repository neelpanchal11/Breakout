package Elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class paddle
{

	  static public int w = 250;
	  int h = 25;
	  
	  public int x,y;
	  
	  public paddle(int x, int y) 
	  {
		  this.x = x;
		  this.y =y;	  
	  }

	  public void keyPress(KeyEvent e)
	  {
		  
		  if (e.getKeyCode() == KeyEvent.VK_LEFT) 
		  {
		        this.x = this.x - 10;
		  }
		
		  if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
		  {
		        this.x = this.x + 10;
		  }
	  }
	  
	  public void draw(Graphics g)
	  {
		  g.setColor(new Color(255, 150, 150));
		  g.fillRoundRect(this.x, this.y, this.w, this.h, this.h, this.h);
	  }
}
