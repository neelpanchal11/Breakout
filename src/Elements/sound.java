package Elements;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class sound {
	Clip clip;
	Clip clip2; // backup clip if clip 1 is busy
	public sound(String loc)
	{
		
		File file = new File(loc);
		
		try
		{	

			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip2 = AudioSystem.getClip();
			clip2.open(AudioSystem.getAudioInputStream(file));
			
		
			// TODO Auto-generated catch blocks
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
		if(clip.isRunning()) // backup clip if clip 1 is busy
		{
			clip2.start();
			clip2.setFramePosition(0);
			if(clip2.isRunning()) {
				System.out.print("lol");
			}
		}else {
			
			clip.start();
			clip.setFramePosition(0);
		}
		
		
	}
}
