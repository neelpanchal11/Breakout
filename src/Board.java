import java.awt.*;
import javax.swing.*;
import Elements.*;
import java.awt.event.*;

public class Board extends JPanel {
	
	static int w;
	static int h;
	byte score = 0;
	boolean pause = true;
	int lev_no;
	int numBrick;
	
	Image canvas;
	paddle pad1;
	ball ball1;
	Menus menu = new Menus();
	JPanel panel= new JPanel();
	JLabel score_disp;
	levels lev1 = new levels(6,9, lev_no);
	
	Board(int w, int h, int lev_no)
	{	
		this.w= w;
		this.h = h;
		this.lev_no = lev_no;
		score_disp = new JLabel();
		pad1 = new paddle((w-pad1.w)/2,750);   
		ball1 = new ball((w-ball1.r)/2,600);
		canvas = createImage(w,h);
		lev1.generate();
		numBrick = lev1.numBrick();
		
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
				score_display(score);
				repaint();
			}
			else
			{
				pause = menu.resume();
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
					pause = true;
					menu.pausegame(w,h);
				}
			}
			
			if(!pause)
			{
			pad1.keyPress(e,w);	
			repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if (pause) 
				{
					pause = false;
				}
			}
		}
	}	
	
	public void score_display(byte score)
	{
		String s = String.valueOf(score);
		score_disp.setText(s);
		score_disp.setBounds(40,20,50,50);
		score_disp.setFont(new Font("Verdana", Font.BOLD, 30));
	    score_disp.setForeground(Color.red);
	    add(score_disp);
		
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
			menu.endgame(false); //method for end menu
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
		
			byte side = lev1.BrickColision(ball1.x, ball1.y, ball1.r);
			
			if (side == -1)
			{
				ball1.east = !ball1.east;
				score++;
				if (numBrick == score)
				{
					pause = true;
					menu.endgame(true);
				}
			}
			
			else if (side == 1)
			{
				ball1.south = !ball1.south;
				score++;
				if (numBrick == score)
				{
					pause = true;
					menu.endgame(true);
				}
			}
		
		}
	}

}