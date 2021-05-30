package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pause_menu extends JPanel {
	
	boolean pause = true;
	JLabel pause_img;
	bg_music bg;
	sound pause_sound = new sound("sounds\\pause.wav");
	sound unpause_sound = new sound("sounds\\unpause.wav");
	JPanel returnboard;
	
	
	public pause_menu(int w, int h, bg_music bg, JPanel board)
	{
		returnboard = board;
		pause_img = new JLabel(new ImageIcon("sprites\\paused.png"));
		setBounds(0,0,w,h);
	    setLayout(null);
	    setBackground(new Color(0,0,0,150));
	    setVisible(false);
	    pause_img.setBounds(0,0,w,h);
	    pause_img.setForeground(new Color(0,0,0,150));
		bg.mute_button.setBounds(25*w/26,h/80,50,50);
	    bg.mute_button.addKeyListener(new AL());
	    add(pause_img);
	    add(bg.mute_button);
	    this.bg = bg;
	    
	    this.addKeyListener(new AL());
	}
	public void pausegame()
	{
		pause = true;
	    pause_sound.start();
		setVisible(true);
		requestFocus();
	}
	public void resumegame()
	{
		pause = false;
		setVisible(false);
		unpause_sound.start();
		returnboard.requestFocus();
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
			
			if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			{
				resumegame();
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				System.exit(0);	
			}
		}
	}
	
}
