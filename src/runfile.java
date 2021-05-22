import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7141151800441150268L;
	
	static int w,h;
	static Board game;
	static main_menu welcome;
	static runfile run;
	
	public static void main (String[] args) 
	{	
		run = new runfile();
	}
	
	public runfile()
	{		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("ATRIA BREAKOUT");
		
		w = this.getWidth();
		h = this.getHeight();
		welcome = new main_menu(w,h,this);
		welcome.start.addActionListener(new start_button_AL());
		
		this.add(welcome);
		this.repaint();
	}

	
	public static void start_game()
	{		
		run.remove(welcome);
		int w = run.getWidth();
		int h = run.getHeight();
		game = new Board(w,h,welcome.lev_no, welcome.bg, run.new reset_button_AL());
		run.add(game);
		run.repaint();
		game.requestFocus();
	}
	
	public class start_button_AL implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			start_game();
		}
	}
	
	public class reset_button_AL implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			run = new runfile();
		}
	}
	
}