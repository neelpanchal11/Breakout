package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {
	
	boolean pause = true;
	boolean reset = false;
	JLabel pause_img;
	bg_music bg;
	
	public void endgame(boolean won)
	{
	    JLabel l1;
	    JLabel l2;
	    
	    if (won)
	    {
	    	l1 = new JLabel(new ImageIcon("sprites\\finished.jpeg"));
	    	sound win_sound = new sound("sounds\\win.wav");
	    }else
	    {
	    	l1 = new JLabel(new ImageIcon("sprites\\me.jpg"));
	    	l2 = new JLabel(new ImageIcon("sprites\\lose.jpg"));
		    l2.setBounds(130,20,500,100);
		    add(l2);
		    sound lose_sound = new sound("sounds\\lose.wav");
	    }
	    JButton reset = new JButton(new ImageIcon("sprites\\menu.jpg"));
	    JButton exit = new JButton(new ImageIcon("sprites\\exit2.jpg"));
	    
	    reset.setBounds(280,575,220,70);
	    exit.setBounds(280,655,220,70);
	    
	    l1.setBounds(90,120,600,440);
	    exit.addActionListener(new BL());
	    reset.addActionListener(new RL());
	    setOpacity(1f);
	    setUndecorated(true);
	    getContentPane().setBackground(Color.BLACK);
	    setLayout(null);
	    setVisible(true);
	    setBounds(430,100,800,750);
		
	    add(reset);
	    add(exit);
	    add(l1);

	    
	    setAlwaysOnTop(true);
	}
	
	
	public void pausegame(int w, int h, bg_music bg)
	{
		pause_img = new JLabel(new ImageIcon("sprites\\paused.jpeg"));
	    pause = true;
		setLocation(0,0);
	    setSize(w,h);
	    setUndecorated(true);
	    getContentPane().setBackground(Color.BLACK);
	    setOpacity(0.5f);
	    setLayout(null);
	    setVisible(true);
	    pause_img.setBounds(0,0,w,h);
	    add(pause_img);
	    
	    this.bg = bg;
	    this.addKeyListener(new AL());
	    setAlwaysOnTop(true);
	}

	public boolean resume() 
	{
		return pause;
	}
	
	public boolean re_check()
	{
		return reset;
	}
	
	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				pause_img.setVisible(false);
				dispose();
				pause = false;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				System.exit(0);	
			}
		}
	}
	
	public class BL implements ActionListener
	{
		  public void actionPerformed(ActionEvent e)
			{		
				System.exit(0);			
			}
	}
	public class RL implements ActionListener
	{
		  public void actionPerformed(ActionEvent e)
			{		
			  	dispose();
				reset = true;			
			}
	}
}
