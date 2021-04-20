package Elements;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class sound {
	File file;
	Clip clip;
	public sound(String loc)
	{
		
		file = new File(loc);
		
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	public void stop()
	{
		
		clip.stop();
	}
	public void volume()
	{
		
		FloatControl gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-5.0f); 
	}
	
}
