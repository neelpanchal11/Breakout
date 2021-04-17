package Elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class brick 
{
	public int x;
	public int y;
	public int l=140;
	public int b=55;
	boolean state;
	public brick(int x, int y)
	{

		this.x = x;
		this.y = y;
		state = true;
		System.out.println("Brick");
	}
	
	public void draw(Graphics g)
	{
		
		if (state)
		{
		g.setColor(new Color(150,150,255));
		g.fillRect(this.x, this.y, l, b);
		}
	}
}
