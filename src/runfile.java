import java.awt.Color;
import java.awt.*;
import Elements.*;
import javax.swing.*;
import java.awt.event.*;

public class runfile extends JFrame{

	public static void main (String[] args) 
	{	
		welcome(); 
		//start();
	}
	
	public static void welcome()
	{
		String lev_no[] = {"Level 1","Level 2","Level 3","Level 4"};
		
		JButton exit = new JButton(new ImageIcon("sprites\\exit.jpg"));
		JButton start = new JButton(new ImageIcon("sprites\\start_button.jpg"));
		JLabel lev = new JLabel(new ImageIcon("sprites\\level.jpg"));
		JComboBox level = new JComboBox(lev_no);
		JFrame welcome = new JFrame();
		
		welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
		welcome.setUndecorated(true);
		welcome.getContentPane().setBackground(new Color(50,50,50));
		welcome.setLayout(null);
		welcome.setVisible(true);
		
		int w1 = welcome.getSize().width; 
		int h1 = welcome.getSize().height;
		
		lev.setBounds(650,720,200,50);
		lev.setVisible(true);
		start.setBounds(650,640,200,50);
		level.setBounds(650,720,200,50);
		exit.setBounds(650,800,200,50);
	
		welcome.add(lev);
		welcome.add(start);
		welcome.add(level);
		welcome.add(exit);
	
		
	}

	public static void start()
	{		
		
		JFrame window = new JFrame();
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setTitle("ATARI BREAKOUT COPY");
		window.setVisible(true);

		int w = window.getSize().width; 
		int h = window.getSize().height;
		int lev_no = 1;
		
		Board game = new Board(w,h,lev_no);
		
		window.addKeyListener(game.new AL());
		window.add(game);
		game.startgame();
		game.gameloop();
		
	}
//
//	public class select implements ActionListener
//	{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
}
