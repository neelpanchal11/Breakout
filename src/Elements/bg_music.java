package Elements;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class bg_music {
	
	Clip clip;
	boolean mute = false;
	
	public bg_music()
	{
		
		File file = new File("sounds//bg.wav");
		
		try
		{
			
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audio);
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
		}
		else
		{
			clip.stop();
		}
		mute = !mute;		
	}
}
