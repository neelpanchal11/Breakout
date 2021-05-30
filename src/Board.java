import java.awt.*;
import javax.swing.*;

import Elements.*;

import java.awt.event.*;

public class Board extends JPanel implements ActionListener, KeyListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	sound wall_hit = new sound("sounds//wall.wav");
	static int w;
	static int h;
	boolean pause = true;
	boolean end = false;
	int lev_no;
	int numBrick;
	
	bg_music bg;
	Timer time;
	Image canvas;
	
	paddle pad1;
	ball ball1;
	JLabel score_disp;
	JLabel start_game;
	
	pause_menu pausemenu;
	end_menu endmenu;
	levels lev1;
	
	Board(int w, int h, int lev_no, bg_music bg, ActionListener resetfunction)
	{	
		this.w= w;
		this.h = h;
		this.lev_no = lev_no;
		this.bg = bg;
	
		score_disp = new JLabel();
		start_game = new JLabel(new ImageIcon("sprites\\start.jpg"));
		startgame();
		
		lev1 = new levels(6,9, lev_no);
		pad1 = new paddle((w-pad1.w)/2,750);   
		ball1 = new ball((w-ball1.r)/2,600);
		pausemenu = new pause_menu(w,h,bg,this);
		endmenu = new end_menu(resetfunction);
		canvas = createImage(w,h);
		lev1.generate();
		numBrick = lev1.numBrick();
		
		time = new Timer(1,this);
		time.start();
		
		this.add(pausemenu);
		this.add(endmenu);
		this.setBounds(0,0,w,h);
		this.setLayout(null);
		this.setBackground(new Color(50,50,50));
		addKeyListener(this);
	
	}
	
	public void paintComponent(Graphics g) 
	{		
			super.paintComponent(g);
			g.drawImage(canvas,0,0,this);	
			pad1.draw(g);
			ball1.draw(g);
			lev1.draw(g);	

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
		bg.volume();
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
		if(ball1.x + ball1.r >= w || ball1.x <= 0||ball1.y <= 0)
		{
			wall_hit.start();
		}
		ball1.paddle_hit((ball1.y +ball1.r > pad1.y && ball1.y < pad1.y) && (ball1.x >= pad1.x && ball1.x +ball1.r <= pad1.x+pad1.w) && ball1.south,
				(pad1.x+pad1.w/2)>(ball1.x+ball.r/2));
		
			
		boolean[] side = lev1.BrickColision(ball1.x, ball1.y, ball1.r, ball1.east, ball1.south);
		ball1.bounce_v(side[0]);
		ball1.bounce_h(side[1]);
		
		if ( ball1.y >= h || numBrick == lev1.score) // GAME END
		{
			bg.stop();
			end = true;
			endmenu.endgame(numBrick == lev1.score); //method for end menu
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		time.start();
		
		if(!pause&&!end)
		{
			ball1.motion();
			collisionCheck();
			score_display(lev1.score);
			repaint();
		}
		else
		{
			pause = pausemenu.resume();
		}
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!pause&&!end) // Paddle Motion
		{
			pad1.keyPress(e,w);	
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) // PAUSE GAME
		{
			if (!pause&&!end) 
			{
				pause = true;
				pausemenu.pausegame();
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		}
}
