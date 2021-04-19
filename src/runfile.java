import javax.swing.JFrame;


public class runfile {
	public static void main (String[] args) 
	{
		start();
	}
	
	
	public static void start()
	{		
		
		JFrame window = new JFrame();
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		window.setTitle("ATARI BREAKOUT COPY");
		window.setVisible(true);

		int w = window.getSize().width; 
		int h = window.getSize().height;
		int lev_no = 2;
		
		Board game = new Board(w,h,lev_no);
		
		window.addKeyListener(game.new AL());
		window.add(game);
		game.gameloop();
		
	}

}
