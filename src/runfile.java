import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7141151800441150268L;
	
	static main_menu welcome;
	static runfile run = null;
	static boolean reset = true;
	public static void main (String[] args) 
	{	
		
		while (true)
		{
			if(reset)
			{	
					run = new runfile();
					reset = false;
			}
			if(welcome.on)
			{		
				run.remove(welcome);
				start();
				welcome.on = false;
				reset = true;
			}
			System.out.println();
		}
	}
	
	public runfile()
	{		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("ATRIA BREAKOUT");
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		welcome = new main_menu(w,h);
		
		this.add(welcome);
		this.repaint();
	}

	
	public static void start()
	{		

		int w = run.getSize().width; 
		int h = run.getSize().height;
		
		Board game = new Board(w,h,welcome.lev_no, welcome.bg);
		
		run.add(game);
		game.requestFocus();
		game.startgame();
		game.gameloop();
		
	}

}
