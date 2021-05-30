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

	sound brick_hit_horizontal = new sound("sounds\\brick_hit.wav");
	sound brick_hit_vertical = new sound("sounds\\brick_hit_v.wav");
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

	public boolean[] BrickColision(float ballx, float bally, int balld, boolean ballE, boolean ballS) 
	{
		boolean[] returning = {false,false}; // {Vertical col, Horizontal col}
		
		int diffX = (int)ballx - originX,
		    diffY = (int)bally - originY,
		    i[] = {diffY/spacingY,(diffY + balld)/spacingY},
		    j[] = {diffX/spacingX,(diffX + balld)/spacingX};
		
		
		if(diffX + balld <= 0 || diffY + balld <= 0 || diffX >= spacingX*col || diffY >= spacingY*row)
		{
			return returning;
		}
		
		boolean v_stacked = i[1] != i[0],
		        h_stacked = j[1] != j[0];


		limit(i,row);
		limit(j,col);
		
		boolean v_stack_state = bricks[i[0]][j[0]].state && bricks[i[0]][j[1]].state || bricks[i[1]][j[0]].state && bricks[i[1]][j[1]].state,
		        h_stack_state = bricks[i[0]][j[0]].state && bricks[i[1]][j[0]].state || bricks[i[0]][j[1]].state && bricks[i[1]][j[1]].state; 
		
		for (int k = 0; k<2 - (i[0] == i[1]?1:0); k++)
		{
			for (int l = 0; l<2 - (j[0] == j[1]?1:0); l++)
			{
				brick col_brick = bricks[i[k]][j[l]];
				
				if(col_brick.state)
				{            	   		

    				col_brick.state = false;
    				score++;
    				returning[0]= v_stacked && (!h_stacked || v_stack_state || !(h_stack_state||(k == 1 ^ ballS)));
    				returning[1]= h_stacked && (!v_stacked || h_stack_state || !(v_stack_state||(l == 1 ^ ballE))); 
    				sound brick_hit = returning[0]?brick_hit_horizontal:brick_hit_vertical;
    				brick_hit.start();
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
            	
            	if(bricks[i][j].state)
            	{
            		count++;
            	}
            }
        }
		return count;
	}
	
	void limit(int i[],int Hlim)
	{
		if (i[0] < 0)
		{
			i[0] = 0;
			i[1]=0;
		}
		if (i[1] >= Hlim)
		{
			i[0] = Hlim-1;
			i[1] = Hlim-1;
		}
	}

}
