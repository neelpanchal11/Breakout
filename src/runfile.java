import java.awt.Color;
import java.awt.*;
import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile{

	JComboBox levelbox;
	JFrame welcome;
	JButton mute_button;
	
	static boolean reset = true;
	static boolean on = false; 
	static bg_music bg;
	static JFrame window;
	static JButton start;
	static int lev_no;
	//boolean is_mute = false;
	
	
	public static void main (String[] args) 
	{	
		bg = new bg_music();
		
		while (true)
		{
			if(reset)
			{	
				runfile run = new runfile();
				reset = false;
				bg.start();
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
	
		String lev_arr[] = {"Demo","Level 1","Level 2","Level 3","Level 4","Level 5", "Level 6"};
		JButton exit = new JButton(new ImageIcon("sprites\\exit2.jpg"));
		JButton start = new JButton(new ImageIcon("sprites\\start_button.jpg"));
		JLabel lev_label = new JLabel(new ImageIcon("sprites\\level.jpg"));	
		JLabel title = new JLabel(new ImageIcon("sprites\\welcome.png"));
		mute_button = new JButton(new ImageIcon("sprites\\unmuted.jpg"));
		
		levelbox = new JComboBox(lev_arr);
		
		//Hide drop down button of Combo box
		levelbox.setUI(new javax.swing.plaf.metal.MetalComboBoxUI()
			{public void layoutComboBox(Container parent, MetalComboBoxLayoutManager manager) 
				{super.layoutComboBox(parent, manager);
				 arrowButton.setBounds(0,0,0,0);
				 }});
		
		welcome = new JFrame();
		
		welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
		welcome.setUndecorated(true);
		welcome.getContentPane().setBackground(new Color(50,50,50));
		welcome.setLayout(null);
		welcome.setVisible(true);
		
		title.setBounds(165, 200, 1200, 300);
		lev_label.setBounds(650,720,220,70);
		lev_label.setVisible(true);
		start.setBounds(400,720,220,70);
		mute_button.setBounds(1540,10,50,50);
		levelbox.setBounds(650,720,220,70);
		exit.setBounds(900,720,220,70);	

		welcome.add(mute_button);
		welcome.add(title);
		welcome.add(lev_label);
		welcome.add(start);
		welcome.add(levelbox);
		welcome.add(exit);
		
		mute_button.addActionListener(new mute());
		start.addActionListener(new start());
		exit.addActionListener(new exit());
		
	}

	public static void start()
	{		
		bg.volume();
		window = new JFrame();
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setUndecorated(true);
		window.setTitle("ATRIA BREAKOUT");
		window.setVisible(true);

		int w = window.getSize().width; 
		int h = window.getSize().height;
		
		Board game = new Board(w,h,lev_no, bg);
		
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
			lev_no = levelbox.getSelectedIndex();
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
	
	public class mute implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			bg.mute(mute_button);
		}
	}
}
