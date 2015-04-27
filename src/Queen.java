import java.awt.Graphics;

import javax.swing.ImageIcon;

//Class Queen is a subclass of Piece and includes the Queen image and valid moves
//Queens can move any number of spaces in any specific direction
public class Queen extends Piece
{
	public Queen(boolean position, String side)
	{
		//The color (black or white) indicates which ImageIcon to use
		color = side;
		if(color.equals("black"))
		{
			ImageIcon queenIcon = new ImageIcon(this.getClass().getResource("bqueen.gif"));
			pieceImage = queenIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon queenIcon = new ImageIcon(this.getClass().getResource("wqueen.gif"));
			pieceImage = queenIcon;
		}
	}
	
	//Method canMove is an abstract inherited method from Piece
	//Inputs: the current coordinates and the destination coordinates
	//Outputs: boolean value of whether or not the piece can move to the destination
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//If the destination isn't empty and has a piece of the same color, don't move
		if(Chess.position[destY][destX]!=null && Chess.position[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		
		//Moving diagonally
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			//Making sure there are no pieces in the way
			if(destX>originX && destY>originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(Chess.position[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//Making sure there are no pieces in the way
			if(destX<originX && destY<originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Chess.position[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//Making sure there are no pieces in the way
			if(destX<originX && destY>originY)
			{
				System.out.println("destX " + destX + "destY" + destY);

				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(Chess.position[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//Making sure there are no pieces in the way
			if(destX>originX && destY<originY)
			{
				System.out.println("destX " + destX + "destY" + destY);
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Chess.position[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
		} 
		
		//Moving vertically
		if(destY==originY)
		{
			//Making sure there are no pieces in the way
			if(destX>originX)
			{
				for(int i = originX+1; i < destX; i++)
				{
						if(Chess.position[destY][i]!=null)
						{	
							return canPieceMove = false;
						}
				}
				return canPieceMove = true;

			}
			//Making sure there are no pieces in the way
			if(destX<originX)
			{
				for(int i = originX-1; i > destX; i--)
				{
						if(Chess.position[destY][i]!=null)
						{
							return canPieceMove = false;
						}
				}
				return canPieceMove = true;
			}	
		}
		
		//Moving horizontally
		if(destX==originX)
		{
			//Making sure there are no pieces in the way
			if(destY>originY)
			{
				for(int i = originY+1; i < destY; i++)
				{
					if(Chess.position[i][destX]!=null)
					{
						return canPieceMove = false;
					}
				}
				return canPieceMove = true;
			}
			//Making sure there are no pieces in the way
			if(destY<originY)
			{
				for(int i = originY-1; i > destY; i--)
				{
					if(Chess.position[i][destX]!=null)
					{
						return canPieceMove = false;
					}
				}
				return canPieceMove = true;
			}
		}
		else
		{
			canPieceMove = false;
		}
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