import java.awt.Color;
import java.awt.*;
import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile{

	JComboBox level;
	JFrame welcome;
	static boolean reset = true;
	static boolean on = false; 
	static JFrame window;
	static JButton start;
	static int lev_no;
	
	public static void main (String[] args) 
	{	
		while (true)
		{
			if(reset) {
			runfile run = new runfile();
			reset = false;
			}
			if(on)
			{
			start();
			window.dispose();
			on = false;
			reset = true;
			}
			System.out.println(); // I DONT EVEN KNOW
			
		}
	}
	
	public runfile()
	{
		
		String lev_arr[] = {"Level 1","Level 2","Level 3","Level 4"};
		JButton exit = new JButton(new ImageIcon("sprites\\exit.jpg"));
		JButton start = new JButton(new ImageIcon("sprites\\start_button.jpg"));
		JLabel lev = new JLabel(new ImageIcon("sprites\\level.jpg"));	
		level = new JComboBox(lev_arr);
		welcome = new JFrame();
		
		welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
		welcome.setUndecorated(true);
		welcome.getContentPane().setBackground(new Color(50,50,50));
		welcome.setLayout(null);
		welcome.setVisible(true);
		
		lev.setBounds(650,720,200,50);
		lev.setVisible(true);
		start.setBounds(650,640,200,50);
		level.setBounds(650,720,200,50);
		exit.setBounds(650,800,200,50);	

		welcome.add(lev);
		welcome.add(start);
		welcome.add(level);
		welcome.add(exit);
		
		start.addActionListener(new start());
		exit.addActionListener(new exit());
		
	}

	public static void start()
	{		
		window = new JFrame();
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setTitle("ATARI BREAKOUT COPY");
		window.setVisible(true);

		int w = window.getSize().width; 
		int h = window.getSize().height;
		
		Board game = new Board(w,h,lev_no);
		
		window.addKeyListener(game.new AL());
		window.add(game);
		game.startgame();
		game.gameloop();
		
	}

	public class start implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			lev_no = level.getSelectedIndex();
			on = true;
			welcome.dispose();
		}
	}
	
	public class exit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
