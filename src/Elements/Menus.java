package Elements;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menus extends JFrame {
	
	public Menus(){

	}
	
	public void endgame()
	{
	    JLabel l1;  
	    l1=new JLabel("First Label.");  
	    l1.setBounds(100,100, 100,30);  
	    add(l1);
	    setSize(300,300);  
	    setLayout(null);  
	    setVisible(true);  
		
	}
}
