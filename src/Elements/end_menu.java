package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class end_menu extends JPanel {
	
	boolean reset = false;
	bg_music bg;
	sound win_sound = new sound("sounds\\win.wav");
	sound lose_sound = new sound("sounds\\lose.wav");
    JLabel win = new JLabel(new ImageIcon("sprites\\finished.jpeg"));
    JLabel lose = new JLabel(new ImageIcon("sprites\\lose.jpg"));
    JLabel me = new JLabel(new ImageIcon("sprites\\me.jpg"));
	
	public end_menu(ActionListener resetfunction)
	{

	    JButton reset = new JButton(new ImageIcon("sprites\\menu.jpg"));
	    JButton exit = new JButton(new ImageIcon("sprites\\exit2.jpg"));
	    
	    lose.setBounds(130,20,500,100);
	    reset.setBounds(280,575,220,70);
	    exit.setBounds(280,655,220,70);
	    win.setBounds(90,120,600,440);
	    me.setBounds(90,120,600,440);
	    exit.addActionListener(new BL());
	    reset.addActionListener(resetfunction);
	    
	    this.setBackground(Color.BLACK);
	    setLayout(null);
	    setVisible(false);
	    setBounds(430,100,800,750);
		
	    add(reset);
	    add(exit);
	    add(win);
	    add(me);
	    add(lose);
	    
	    win.setVisible(false);
	    me.setVisible(false);
	    lose.setVisible(false);
	    //setAlwaysOnTop(true);
	}
	
	public void endgame(boolean won)
	{
		
		this.setVisible(true);
	    if (won)
	    {
	    	win.setVisible(true);
	    	win_sound.start();
	    }
	    
	    else
	    {
	    	me.setVisible(true);
	    	lose.setVisible(true);
		    lose_sound.start();
	    }
	    
	}
	
	public class BL implements ActionListener
	{
		  public void actionPerformed(ActionEvent e)
			{		
				System.exit(0);			
			}
	}

}
