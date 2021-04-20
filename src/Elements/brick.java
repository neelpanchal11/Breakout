package Elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class brick 
{
	public int x;
	public int y;
	public int w=140;
	public int h=55;
	boolean state;
	public brick(int x, int y)
	{

		this.x = x;
		this.y = y;
		state = true;
	}
	
	public void draw(Graphics g, Color color )
	{
		
		if (state)
		{
		g.setColor(color);
		g.fillRect(this.x, this.y, w, h);
		}
	}
}
