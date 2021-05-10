package Elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class levels 
{	
	int row,col, originX = 120 ,originY = 85, spacingX = 150, spacingY = 65;
	brick[][] bricks;
	boolean[][] pattern;
	pattern pat = new pattern();
	public byte score = 0;
	boolean[] returning = {false,false}; // {Vertical col, Horizontal col}
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
            		bricks[i][j] = new brick(j * spacingX + originX, i * spacingY + originY);
            		bricks[i][j].state = pattern[i][j];
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
            	bricks[i][j].draw(g,color);
            }
        }
	}

	public boolean[] BrickColision(float ballx, float bally, int balld, int ballstep) 
	{
		returning[0] = false;
		returning[1] = false;
		
		int diffX = (int)ballx - originX;
		int diffY = (int)bally - originY;
		
		if(diffX + balld < 0 || diffY + balld < 0 || diffX > spacingX*col || diffY > spacingY*row)
		{
			return returning;
		}
		
		int i[] = {limit(diffY/spacingY,row),limit((diffY + balld)/spacingY,row)},
			j[] = {limit(diffX/spacingX,col),limit((diffX + balld)/spacingX,col)};
		
		for (int k = 0; k<2 - (i[0] == i[1]?1:0); k++)
		{
			for (int l = 0; l<2 - (j[0] == j[1]?1:0); l++)
			{
		collision_conditions(i[k],j[l],ballx, bally, balld, ballstep);
			}
		}
		
		boolean multi_collision[]= 
			{
					bricks[i[0]][j[0]].state && bricks[i[0]][j[1]].state || bricks[i[1]][j[0]].state && bricks[i[1]][j[1]].state,
					bricks[i[0]][j[0]].state && bricks[i[1]][j[0]].state || bricks[i[0]][j[1]].state && bricks[i[1]][j[1]].state
		};
		
		returning[0]= returning[0] && (multi_collision[0] || !multi_collision[1]);
		returning[1]= returning[1] && (multi_collision[1] || !multi_collision[0]);
		//score = (byte) (score + (returning[0]||returning[1]?1:0));
		return returning;
	}
	
	void collision_conditions(int i,int j, float ballx, float bally, int balld, int ballstep)
	{

				brick col_brick = bricks[i][j];
				
				if(col_brick.state)
				{            	   			
    				col_brick.state = false;
    				score++;
    				returning[0] = bally + balld - ballstep < col_brick.y || bally + ballstep > col_brick.y + col_brick.h;
    				returning[1] = ballx +balld - ballstep < col_brick.x || ballx + ballstep > col_brick.x + col_brick.w;  
    				sound brick_hit = returning[0]?new sound("sounds\\brick_hit_v.wav"):new sound("sounds\\brick_hit.wav");
				}
    }
	
	public byte numBrick()
	{
		
		byte count = 0;
		for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
            	
            	if(bricks[i][j].state)
            	{
            		count++;
            	}
            }
        }
		return count;
	}
	
	int limit(int val,int Hlim)
	{
		return Math.min(Math.max(val, 0), Hlim-1);
	}

}
