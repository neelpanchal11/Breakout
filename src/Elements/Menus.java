package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {

	public void endgame()
	{
	    JFrame f1 = new JFrame();
	    JLabel l1 = new JLabel(new ImageIcon("sprites\\game over.jpeg"));
	    JButton b1 = new JButton(new ImageIcon("sprites\\restart.jpg"));
	    JButton b2 = new JButton(new ImageIcon("sprites\\exit.jpg"));
	    b1.setBounds(300,300,150,30);
	    b2.setBounds(325,350,100,35);
	    l1.setBounds(90,-50,600,500);
	    f1.setUndecorated(true);
	    f1.getContentPane().setBackground(Color.BLACK);
	    f1.setLayout(null);
	    f1.setVisible(true);
	    f1.setBounds(430,250,800,500);
	    f1.add(b1);
	    f1.add(b2);
	    f1.add(l1);
	    f1.setAlwaysOnTop(true);
	}
	
	public void pausegame(int w, int h)
	{
		JLabel l1 = new JLabel(new ImageIcon("sprites\\paused.jpeg"));
	    setLocation(0,22);
	    setSize(w,h);
	    setUndecorated(true);
	    getContentPane().setBackground(Color.BLACK);
	    setOpacity(0.5f);
	    setLayout(null);
	    setVisible(true);
	    l1.setBounds(0,0,1600,900);
	    add(l1);
	    this.addKeyListener(new AL());
	}

	public class AL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{	
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				
			}
			
			dispose();
		}
	}
}	

