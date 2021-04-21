package Elements;
import java.awt.Color;
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
		
        for (int i = 0; i < row; i++)
        {

            for (int j = 0; j < col; j++)
            {
            	
            	if(pattern[i][j])
            	{
            		bricks[i][j] = new brick(j * 150 + 120, i * 65 + 85);
            
            	}
        
            }
	
        }
	}
	public void draw(Graphics g)
	{
		Color color;
		for (int i = 0; i < row; i++)
		{
			
			color = new Color(90+10*i,90+10*i,195+10*i);
            
			for (int j = 0; j < col; j++)
			{
            	
            	if(pattern[i][j])
            	{
            	bricks[i][j].draw(g,color);
            	}
            }
        }
	}

	public boolean[] BrickColision(int ballx, int bally, int ballr) 
	{
		boolean[] returning = {false, false}; // {vertical col, horizontal col}
		
		for (int i = 0; i < row; i++)
		{
            for (int j = 0; j < col; j++)
            {   	
            	if(pattern[i][j] && bricks[i][j].state)
            	{            	
            		if(bricks[i][j].x < ballx + ballr && bricks[i][j].x + bricks[i][j].w > ballx) // Vertical Collision
            		{
            			
            			if (bally + ballr == bricks[i][j].y || bally == bricks[i][j].y + bricks[i][j].h )
            			{
            				sound brick_hit = new sound("sounds\\brick_hit_v.wav");
            				bricks[i][j].state = false;
            				returning[0] = true;
            			}
            			
            		}
        			if(bricks[i][j].y < bally + ballr && bricks[i][j].y + bricks[i][j].h > bally) // Horizontal Collision
        			{
        				if (ballx +ballr == bricks[i][j].x || ballx == bricks[i][j].x + bricks[i][j].w )
        				{
        					sound brick_hit = new sound("sounds\\brick_hit.wav");
        					bricks[i][j].state = false;
            				returning[1] = true;    
        				}
        			}
        			
        			if(ballx +ballr == bricks[i][j].x || ballx == bricks[i][j].x + bricks[i][j].w)
        			{ // Corner Collision
        				if(bally + ballr == bricks[i][j].y || bally == bricks[i][j].y + bricks[i][j].h)
        				{
        					sound brick_hit = new sound("sounds\\brick_hit_v.wav");
        					bricks[i][j].state = false;
            				returning[0] = true;
            				returning[1] = true;   
        				}
        			}
            	}
            }
        }
	
	return returning;
	}
	
	public byte numBrick()
	{
		
		byte count = 0;
		for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
            	
            	if(pattern[i][j] && bricks[i][j].state)
            	{
            		count++;
            	}
            }
        }
		return count;
	}

}
