import java.awt.Graphics;
import javax.swing.ImageIcon;

//Class Knight is a subclass of Piece and includes the Knight image and valid moves
//Knights can move in an L shape
public class Knight extends Piece
{
	public Knight(boolean position, String side)
	{
		//The color (black or white) indicates which ImageIcon to use
		color = side;
		if(color.equals("black"))
		{
			ImageIcon knightIcon = new ImageIcon(this.getClass().getResource("bknight.gif"));
			pieceImage = knightIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon knightIcon = new ImageIcon(this.getClass().getResource("wknight.gif"));
			pieceImage = knightIcon;
		}
	}
	
	//Method canMove is an abstract inherited method from Piece
	//Inputs: the current coordinates and the destination coordinates
	//Outputs: boolean value of whether or not the piece can move to the destination
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//Making sure that the destination is either empty or has an opponent's piece
		//Making sure the path is also empty
		if(Chess.position[destY][destX]!=null && Chess.position[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		
		//Make sure the destination does not have the same x or y coordinates as the origin
		if(destY == originY || destX == originX)
		{
			return canPieceMove = false;
		}
		
		//Make sure they aren't diagonal
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			return canPieceMove = false;
		}	
		
		//The destination X and Y should be no more than 2 spaces away from the origin
		if(destX==originX+1 || destX == originX-1 || destX == originX-2 || destX == originX+2)
		{
			if(destY == originY+1 || destY == originY-1 || destY == originY-2 || destY == originY+2)
			{
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