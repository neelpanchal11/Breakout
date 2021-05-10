package Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class level_select extends JPanel 
{	
	ActionListener Level_select_AL;
	JButton lev_button_gen[][] = new JButton[3][3];
	ImageIcon lev_arr[][] = {{new ImageIcon("sprites\\levels\\demo.png"), new ImageIcon("sprites\\levels\\lev1.png"), new ImageIcon("sprites\\levels\\lev2.png")},
							 {new ImageIcon("sprites\\levels\\lev3.png"), new ImageIcon("sprites\\levels\\lev4.png"), new ImageIcon("sprites\\levels\\lev5.png")},
							 {new ImageIcon("sprites\\levels\\lev6.png"), new ImageIcon("sprites\\levels\\lev6.png"), new ImageIcon("sprites\\levels\\lev6.png")}};

	public level_select(int w, int h, ActionListener AL)
	{	
		Level_select_AL = AL;
		this.setBounds(w/4,h/6,800,350);
		this.setBackground(new Color(0,0,0,80));
		this.setLayout(null);
		gen_mat();
	}
	
	public void gen_mat()
	{
		for( int i = 0; i < 3; i++)
		{
			for( int j = 0; j < 3; j++)
			{
				lev_button_gen[i][j] = new JButton(lev_arr[j][i]);
				lev_button_gen[i][j].putClientProperty("column", i);
				lev_button_gen[i][j].putClientProperty("row", j);
				lev_button_gen[i][j].setBounds(10 + 280*i, 10 + 120*j, 220, 70);
				lev_button_gen[i][j].addActionListener(Level_select_AL);
				add(lev_button_gen[i][j]);
			}
		}
	}
	
	
}

