package Elements;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main_menu extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame run;
	public static int lev_no;
	public JButton exit;
	public JButton start;
	public JButton lev_button;
	public JLabel title;
	public bg_music bg;
	public level_select select;
	//public JComboBox<?> levelbox;
	public boolean on = false;
	
	public main_menu(int w, int h, JFrame run)
	{
		
		this.run = run;
		exit = new JButton(new ImageIcon("sprites\\exit2.jpg"));
		start = new JButton(new ImageIcon("sprites\\start_button.jpg"));
		lev_button = new JButton(new ImageIcon("sprites\\level.jpg"));
		//JLabel lev_label = new JLabel(new ImageIcon("sprites\\level.jpg"));	
		title = new JLabel(new ImageIcon("sprites\\welcome.png"));
		bg = new bg_music();	
		//levelbox = new JComboBox(lev_arr);
			
//		levelbox.setUI(new javax.swing.plaf.metal.MetalComboBoxUI()
//				{public void layoutComboBox(Container parent, MetalComboBoxLayoutManager manager) 
//					{super.layoutComboBox(parent, manager);
//					 arrowButton.setBounds(0,0,0,0);
//					 }});
			
		title.setBounds(180, 200, 1200, 400);
		lev_button.setBounds(650,720,220,70);
		lev_button.setVisible(true);
		lev_button.addActionListener(new lev_sel());
		
		start.setBounds(400,720,220,70);
		bg.mute_button.setBounds(25*w/26,h/80,50,50);
		//levelbox.setBounds(650,720,220,70);
		exit.setBounds(900,720,220,70);
		
		
		this.setBounds(0,0,w,h);
		this.setLayout(null);
		this.setBackground(new Color(50,50,50));
		this.add(bg.mute_button);
		this.add(title);
		this.add(lev_button);
		this.add(start);
		//this.add(levelbox);
		this.add(exit);
			
		exit.addActionListener(new exit());	
		bg.start();
		
		select = new level_select(w,h, new Level_select_AL());
		select.setVisible(false);
		
		this.add(select);
	}

	
	public class exit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public class lev_sel implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			select.setVisible(true);
			title.setVisible(false);
			start.setVisible(false);
			exit.setVisible(false);
			lev_button.setVisible(false);
		}
		
	}
	
	public class Level_select_AL implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton) e.getSource();
	        lev_no = (int) btn.getClientProperty("row") + 3 * ((int) btn.getClientProperty("column"));
	        System.out.println(lev_no);
			select.setVisible(false);
			title.setVisible(true);
			start.setVisible(true);
			exit.setVisible(true);
			lev_button.setVisible(true);
	        
		}
	}
	
}
