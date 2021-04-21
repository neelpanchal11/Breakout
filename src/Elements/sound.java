package Elements;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class sound {
	
	public sound(String loc)
	{
		
		File file = new File(loc);
		
		try
		{	
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		
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
}
