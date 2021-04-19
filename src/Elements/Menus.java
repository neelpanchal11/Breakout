package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {
	
	boolean pause = true;
	
	public void endgame(boolean won)
	{
	    JFrame f1 = new JFrame();
	    JLabel l1;
	    JLabel l2;
	    
	    if (won)
	    {
	    	l1 = new JLabel(new ImageIcon("sprites\\game over.jpeg"));
	    	l2 = new JLabel();
	    }else
	    {
	    	l1 = new JLabel(new ImageIcon("sprites\\me.jpg"));
	    	l2 = new JLabel(new ImageIcon("sprites\\lose.jpg"));
	    }
	    JButton reset = new JButton(new ImageIcon("sprites\\reset.jpg"));
	    JButton exit = new JButton(new ImageIcon("sprites\\exit.jpg"));
	    
	    reset.setBounds(280,580,200,60);
	    exit.setBounds(280,650,200,50);
	    l1.setBounds(100,120,600,440);
	    l2.setBounds(130,20,500,100);
	    exit.addActionListener(new BL());
	    
	    f1.setUndecorated(true);
	    f1.getContentPane().setBackground(Color.BLACK);
	    f1.setLayout(null);
	    f1.setVisible(true);
	    f1.setBounds(430,100,800,750);
		
	    f1.add(reset);
	    f1.add(exit);
	    f1.add(l1);
	    f1.add(l2);

	    f1.setAlwaysOnTop(true);
	}
	
	
	public void pausegame(int w, int h)
	{
		JLabel l1 = new JLabel(new ImageIcon("sprites\\paused.jpeg"));
	
		setLocation(0,25);
	    setSize(w,h);
	    setUndecorated(true);
	    getContentPane().setBackground(Color.BLACK);
	    setOpacity(0.5f);
	    setLayout(null);
	    setVisible(true);
	    l1.setBounds(0,0,1600,900);
	    add(l1);
	    
	    this.addKeyListener(new AL());
	    setAlwaysOnTop(true);
	    pause = true;
	}

	public boolean resume() 
	{
		return pause;
	}
	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{

				dispose();
				pause = false;
				
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
}
