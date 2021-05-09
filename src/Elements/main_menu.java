package Elements;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main_menu extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton exit;
	public JButton start;
	public bg_music bg;
	public JComboBox<?> levelbox;
	public int lev_no;
	public boolean on;
	public main_menu(int w, int h)
	{
			
			String lev_arr[] = {"Demo","Level 1","Level 2","Level 3","Level 4","Level 5", "Level 6"};
			exit = new JButton(new ImageIcon("sprites\\exit2.jpg"));
			start = new JButton(new ImageIcon("sprites\\start_button.jpg"));
			JLabel lev_label = new JLabel(new ImageIcon("sprites\\level.jpg"));	
			JLabel title = new JLabel(new ImageIcon("sprites\\welcome.png"));
			bg = new bg_music();
			
			levelbox = new JComboBox(lev_arr);
			
			//Hide drop down button of Combo box
			levelbox.setUI(new javax.swing.plaf.metal.MetalComboBoxUI()
				{public void layoutComboBox(Container parent, MetalComboBoxLayoutManager manager) 
					{super.layoutComboBox(parent, manager);
					 arrowButton.setBounds(0,0,0,0);
					 }});
			
			title.setBounds(180, 200, 1200, 400);
			lev_label.setBounds(650,720,220,70);
			lev_label.setVisible(true);
			
			start.setBounds(400,720,220,70);
			bg.mute_button.setBounds(25*w/26,h/80,50,50);
			levelbox.setBounds(650,720,220,70);
			exit.setBounds(900,720,220,70);
			
			this.setBounds(0,0,w,h);
			this.setLayout(null);
			this.setBackground(new Color(50,50,50));
			this.add(bg.mute_button);
			this.add(title);
			this.add(lev_label);
			this.add(start);
			this.add(levelbox);
			this.add(exit);
			
			start.addActionListener(new start());
			exit.addActionListener(new exit());	
			bg.start();
		
	}
	
	public class start implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			lev_no = levelbox.getSelectedIndex();
			on = true;
		}
	}
	
	public class exit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
