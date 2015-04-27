import java.awt.Graphics;

import javax.swing.ImageIcon;

//Class Bishop is a subclass of Piece and includes the Bishop image and valid moves
//Bishops can move any number of spaces diagonally
public class Bishop extends Piece
{
	public Bishop(boolean position, String side)
	{
		//The color (black or white) indicates which ImageIcon to use
		color = side;
		if(color.equals("black"))
		{
			ImageIcon bishopIcon = new ImageIcon(this.getClass().getResource("bbishop.gif"));
			pieceImage = bishopIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon bishopIcon = new ImageIcon(this.getClass().getResource("wbishop.gif"));
			pieceImage = bishopIcon;
		}
	}
	
	//Method canMove is an abstract inherited method from Piece
	//Inputs: the current coordinates and the destination coordinates
	//Outputs: boolean value of whether or not the piece can move to the destination
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//This if statement checks to see whether or not the destination is diagonal from the origin
		if(Chess.position[destY][destX]!=null && Chess.position[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			if(destX>originX && destY>originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece
							//Making sure the path is also empty
							if(Chess.position[j][i]!=null)
							{
								return canPieceMove = false;
							}
						}
					}
					
				}
				return canPieceMove = true;
			}
			if(destX<originX && destY<originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece
							//Making sure the path is also empty
							if(Chess.position[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}
					}
				}
				return canPieceMove = true;
			}

			if(destX<originX && destY>originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece
							//Making sure the path is also empty
							if(Chess.position[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}	
					}
				}
				return canPieceMove = true;
			}
			if(destX>originX && destY<originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Math.abs(i-originX) == Math.abs(j - originY))
						{
							//Making sure that the destination is either empty or has an opponent's piece
							//Making sure the path is also empty
							if(Chess.position[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}
					}
				}
				return canPieceMove = true;
			}
		} 
		else
			canPieceMove = false;
		return canPieceMove;	
	}
	
	//Method drawPiece is an abstract inherited method from Piece
	//Inputs: integer coordinates and graphic input
	//Outputs: none
	@Override
	public void drawPiece(int x, int y, Graphics g) 
	{
		xpos = x;
		ypos = y;
		g.drawImage(pieceImage.getImage(), xpos, ypos, null);
	}

}