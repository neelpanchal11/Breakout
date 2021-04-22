package Elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class bg_music {
	
	Clip clip;
	AudioInputStream audio;
	boolean mute = false;
	public JButton mute_button = new JButton(new ImageIcon("sprites\\unmuted.jpg"));
	
	public bg_music()
	{
		mute_button.addActionListener(new mute());
		File file = new File("sounds//bg.wav");
		
		try
		{
			
			audio = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.open(audio);
			// TODO Auto-generated catch block
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{

		if (!mute)
		{
		clip.start();
		}
	}
	
	public void stop()
	{
		clip.stop();
	}
	
	public void volume()
	{	
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-6.0f); 
	}

	public void mute()
	{
		
		if(mute)
		{
			clip.start();
			mute_button.setIcon(new ImageIcon("sprites\\unmuted.jpg"));
		}
		else
		{
			clip.stop();
			mute_button.setIcon(new ImageIcon("sprites\\muted.jpg"));
		}
		mute = !mute;		
	}
	
	public class mute implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			mute();
		}
	}
}
