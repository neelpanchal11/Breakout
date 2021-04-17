package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {
	
	public void endgame()
	{
	    JLabel l1 = new JLabel(new ImageIcon("C:\\Users\\Neel\\OneDrive\\Desktop\\game over.jpg"));
	    JButton b1 = new JButton(new ImageIcon("C:\\Users\\Neel\\OneDrive\\Desktop\\restart.png"));
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
	
	public void pausegame()
	{
		JLabel l1 = new JLabel(new ImageIcon("C:\\Users\\Neel\\OneDrive\\Desktop\\paused.jpg"));
	    //JButton b1 = new JButton(new ImageIcon("C:\\Users\\Neel\\OneDrive\\Desktop\\resumegame.png"));
	    setLocation(0,22);
	    setSize(1600,900);
	    setUndecorated(true);
	    setOpacity(0.5f);
	    setLayout(null);
	    setVisible(true);
	    l1.setBounds(0,0,1600,900);
	    //b1.setBounds(620,600,350,100);
	    //add(b1);
	    add(l1);
		
	}
}
