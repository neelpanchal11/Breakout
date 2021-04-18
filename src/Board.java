import java.awt.*;
import javax.swing.*;
import Elements.*;
import java.awt.event.*;

public class Board extends JPanel {
	
	static int w;
	static int h;
	boolean pause = false;
	int lev_no = 0;
	
	Image canvas;
	paddle pad1;
	ball ball1;
	Menus menu = new Menus();
	JPanel panel= new JPanel();
	levels lev1 = new levels(6,9, lev_no);
	
	Board()
	{	

		pad1 = new paddle((w-pad1.w)/2,750);   
		ball1 = new ball((w-ball1.r)/2,600);
		
		canvas = createImage(w,h);
		lev1.generate();
		
		this.setBounds(0,0,w,h);
		this.setBackground(new Color(50,50,50));
	
	}
	
	public void paintComponent(Graphics g) 
	{		
			super.paintComponent(g);
			g.drawImage(canvas,0,0,this);
			
			pad1.draw(g);
			ball1.draw(g);
			lev1.draw(g);	

	}
	
	public void gameloop() 
	{
		while(true) 
		{
			if(!pause)
			{
				ball1.motion();
				collisionCheck();
				repaint();
			}
			try
			{
				Thread.sleep(3); 
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}
	
	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{	
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				if (!pause) 
				{
					menu.pausegame(w,h);
				}
				
				pause = !pause;
			}
			
			if(!pause)
			{
			pad1.keyPress(e,w);	
			repaint();
			}
		}
	}	
	
	public void collisionCheck() 
	{
		if (ball1.x + ball1.r >= w || ball1.x <= 0)
		{
			ball1.east = !ball1.east;
			System.out.println("HIT X");		
		}
		
		if ( ball1.y >= h) // GAME LOST
		{
			pause = true;
			menu.endgame(); //method for end menu
		}
		
		if ((ball1.y +ball1.r > pad1.y && ball1.y < pad1.y) && (ball1.x >= pad1.x && ball1.x +ball1.r <= pad1.x+pad1.w))
		{
			ball1.south = false;
			System.out.println("HIT Y");
		}
		
		if (ball1.y <= 0)
		{
			ball1.south = !ball1.south;
			System.out.println("HIT Y");
		}
		
		if (ball1.y < 600) 
		{
		
			int side = lev1.BrickColision(ball1.x, ball1.y, ball1.r);
			
			if (side == -1)
			{
				ball1.east = !ball1.east;
			}
			
			else if (side == 1)
			{
				ball1.south = !ball1.south;
			}
		
		}
	}
	
	public static void main (String[] args) 
	{		
		
		JFrame window = new JFrame();
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setTitle("ATARI BREAKOUT COPY");
		window.setVisible(true);

		w = window.getSize().width; 
		h = window.getSize().height;
		
		Board game = new Board();
		
		window.addKeyListener(game.new AL());
		window.add(game);
		game.gameloop();
		
	}
}