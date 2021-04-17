import java.awt.*;
import javax.swing.*;
import Elements.*;
import java.awt.event.*;

public class Board extends JFrame {
	
	int w,h,margin=40;
	Image canvas;
	paddle pad1;
	ball ball1;
	boolean ballMove = true;
	int lev_no = 1;
	
	
	levels lev1 = new levels(5,8, lev_no);
	
	Board()
	{	
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.addKeyListener(new AL());
		this.setBackground(new Color(50,50,50));
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);	

		w = getSize().width; 
		h = getSize().height;
		
		pad1 = new paddle((w-pad1.w)/2,750);   
		ball1 = new ball((w-ball1.r)/2,600);
		lev1.generate();
		
		
		while(ballMove) 
		{
		
			ball1.motion();
		
		try {
			Thread.sleep(4); 
		} catch (InterruptedException e) {			// DELAY
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		collisionCheck();
		repaint();
		}
		
	}

	

	public void paint(Graphics g) 
	{		
			canvas = createImage(w,h);
			g.drawImage(canvas,0,0,this);

			pad1.draw(g);
			ball1.draw(g);
			lev1.draw(g);
	}
	
	
	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			pad1.keyPress(e);			
			repaint();
		}
	}
	
	
	
	public static void main (String[] args) 
	{
		Board game = new Board();	
	}
	
	public void collisionCheck() 
	{
		if (ball1.x + ball1.r >= w -margin || ball1.x <= margin)
		{
			ball1.east = !ball1.east;
			System.out.println("HIT X");
				
		}
		
		if (ball1.y >= h-margin || ball1.y <= margin)
		{
			ball1.south = !ball1.south;
			System.out.println("HIT Y");
		}
		
		if ((ball1.y +ball1.r > pad1.y && ball1.y < pad1.y) && (ball1.x >= pad1.x && ball1.x +ball1.r <= pad1.x+pad1.w))
		{
			ball1.south = !ball1.south;
			System.out.println("HIT Y");
		}

	}

}
