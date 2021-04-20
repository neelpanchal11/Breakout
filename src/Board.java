import java.awt.*;
import javax.swing.*;
import Elements.*;
import java.awt.event.*;

public class Board extends JPanel {
	
	static int w;
	static int h;
	byte score = 0;
	boolean pause = true;
	boolean end = false;
	boolean reset = false;
	int lev_no;
	int numBrick;
	
	Image canvas;
	paddle pad1;
	ball ball1;
	Menus menu = new Menus();
	JPanel panel= new JPanel();
	JLabel score_disp;
	JLabel start_game;
	levels lev1;
	
	Board(int w, int h, int lev_no)
	{	
		this.w= w;
		this.h = h;
		this.lev_no = lev_no;
		
	
		score_disp = new JLabel();
		start_game = new JLabel(new ImageIcon("sprites\\start.jpg"));
		startgame();
		lev1 = new levels(6,9, lev_no);
		pad1 = new paddle((w-pad1.w)/2,750);   
		ball1 = new ball((w-ball1.r)/2,600);
		canvas = createImage(w,h);
		lev1.generate();
		numBrick = lev1.numBrick();

		this.setBounds(0,0,w,h);
		this.setLayout(null);
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
			if(!pause&&!end)
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
			
			if (reset)
			{
				break;
			}
			try
			{
				Thread.sleep(3); 
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			reset = menu.re_check();
		}
	}
	
	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{	
			if (e.getKeyCode() == KeyEvent.VK_SPACE) // PAUSE GAME
			{
				if (!pause&&!end) 
				{
					pause = true;
					menu.pausegame(w,h);
				}
			}
			
			if(!pause&&!end) // START GAME
			{
			pad1.keyPress(e,w);	
			repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				if (pause && !end) 
				{
					start_game.setVisible(false);
					pause = false;
				}
			}
		}
	}	
	
	public void score_display(byte score)
	{
		String s = String.valueOf(score);
		score_disp.setText(s);
		score_disp.setBounds(40,20,100,50);
		score_disp.setFont(new Font("Verdana", Font.BOLD, 40));
	    score_disp.setForeground(new Color(255, 150, 150));
	    add(score_disp);	
	}
	
	public void startgame()
	{
		start_game.setBounds(0,0,w,h);
		start_game.setFont(new Font("Verdana", Font.BOLD, 80));
		start_game.setBackground(new Color(0,0,0,0));
		start_game.setOpaque(false);
		start_game.setVisible(true);
	    add(start_game);
		
	}
	
	public void collisionCheck() 
	{
		if (ball1.x + ball1.r >= w || ball1.x <= 0)
		{
			ball1.east = !ball1.east;		
		}
		
		if ( ball1.y >= h) // GAME LOST
		{
			end = true;
			menu.endgame(false); //method for end menu
		}
		
		if ((ball1.y +ball1.r > pad1.y && ball1.y < pad1.y) && (ball1.x >= pad1.x && ball1.x +ball1.r <= pad1.x+pad1.w))
		{
			ball1.south = false;
		}
		
		if (ball1.y <= 0)
		{
			ball1.south = !ball1.south;
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
					end = true;
					menu.endgame(true);
				}
			}
			
			else if (side == 1)
			{
				ball1.south = !ball1.south;
				score++;
				if (numBrick == score)
				{
					end = true;
					menu.endgame(true);
				}
			}
		}
	}

}