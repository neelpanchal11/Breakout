package Elements;
import java.awt.Graphics;
import java.awt.Rectangle;

public class levels 
{	
	int row,col;
	brick[][] bricks;
	boolean[][] pattern;
	pattern pat = new pattern();
	
	public levels(int row ,int col, int pat_no)
	{
		this.row = row;
		this.col = col;
		this.pattern = pat.pat[pat_no];
		bricks = new brick[row][col];
	}
	public void generate()
	{
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
            	
            	if(pattern[i][j])
            	{
            		bricks[i][j] = new brick(j * 180 + 80, i * 90 + 80);
            
            	}
        
            }
	
        }
	}
	public void draw(Graphics g)
	{
	
		for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
            	
            	if(pattern[i][j])
            	{
            	bricks[i][j].draw(g);
            	}
            }
        }
	}

}
