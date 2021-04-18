package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {

	public void endgame()
	{
	    JFrame f1 = new JFrame();
	    JLabel l1 = new JLabel(new ImageIcon("sprites\\game over.jpeg"));
	    JButton b1 = new JButton(new ImageIcon("sprites\\restart.jpeg"));
	    setLocation(550,300);
	    setSize(512,425);
	    getContentPane().setBackground(Color.BLACK);
	    setLayout(null);
	    setVisible(true);
	    b1.setBounds(160,300,150,30);
	    l1.setBounds(0,-50,500,400);
	    add(b1);
	    add(l1);

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
