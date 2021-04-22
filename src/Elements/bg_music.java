package Elements;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class bg_music {
	
	Clip clip;
	AudioInputStream audio;
	boolean mute = false;
	
	public bg_music()
	{
		
		File file = new File("sounds//bg.wav");
		
		try
		{
			
			audio = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
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
		try {
			clip.open(audio);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void mute(JButton button)
	{
		
		if(mute)
		{
			clip.start();
			button.setIcon(new ImageIcon("sprites\\unmuted.jpg"));
		}
		else
		{
			clip.stop();
			button.setIcon(new ImageIcon("sprites\\muted.jpg"));
		}
		mute = !mute;		
	}
}
