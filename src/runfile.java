import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7141151800441150268L;
	
	static Board game;
	public static main_menu welcome;
	static runfile run = null;
	static boolean reset = true;
	public static void main (String[] args) 
	{	
		
//		while (true)
//		{
			run = new runfile();
//			while(!welcome.on)
//			{}			
//			welcome.on = false;
//		}
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
		
		welcome = new main_menu(w,h,this);
		welcome.start.addActionListener(new start());
		this.add(welcome);
		
		game = new Board(w,h,welcome.lev_no, welcome.bg);
		game.setVisible(false);
		this.add(game);
		
		
		
		this.repaint();
	}

	
	public static void start()
	{		
		run.remove(welcome);
		game.setVisible(true);
		run.repaint();
		game.requestFocus();
		
		//game.startgame();
		//game.gameloop();
		
	}
	public class start implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			welcome.lev_no = welcome.levelbox.getSelectedIndex();
			welcome.on = true;

			start();
		}
	}

}