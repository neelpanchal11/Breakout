import java.awt.*;
import javax.swing.*;

import Elements.*;
import java.awt.event.*;

public class Board extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static int w;
	static int h;
	boolean pause = true;
	boolean end = false;
	boolean reset = false;
	int lev_no;
	int numBrick;
	bg_music bg;
	
	Image canvas;
	paddle pad1;
	ball ball1;
	Menus menu = new Menus();
	JPanel panel= new JPanel();
	JLabel score_disp;
	JLabel start_game;
	levels lev1;
	
	Board(int w, int h, int lev_no, bg_music bg)
	{	
		this.w= w;
		this.h = h;
		this.lev_no = lev_no;
		this.bg = bg;
		bg.volume();
	
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
		this.addKeyListener(new AL());
	
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
				score_display(lev1.score);
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
				Thread.sleep(2); 
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
			
			if(!pause&&!end) // Paddle Motion
			{
				pad1.keyPress(e,w);	
				repaint();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) // PAUSE GAME
			{
				if (!pause&&!end) 
				{
					pause = true;
					menu.pausegame(w,h,bg);
				}
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) // Start game
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
		
		ball1.bounce_h(ball1.x + ball1.r >= w || ball1.x <= 0);		
		ball1.bounce_v(ball1.y <= 0);
		ball1.paddle_hit((ball1.y +ball1.r > pad1.y && ball1.y < pad1.y) && (ball1.x >= pad1.x && ball1.x +ball1.r <= pad1.x+pad1.w));
			
		if (ball1.y < 600) 
		{
		
			boolean[] side = lev1.BrickColision(ball1.x, ball1.y, ball1.r);
			//score = (byte) (score + (side[0]||side[1]?1:0));
			ball1.bounce_v(side[0]);
			ball1.bounce_h(side[1]);
		
		}
		
		if ( ball1.y >= h || numBrick == lev1.score) // GAME END
		{
			
			bg.stop();
			end = true;
			menu.endgame(numBrick == lev1.score); //method for end menu
		
		}
	}
}
