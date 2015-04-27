import java.awt.Graphics;
import javax.swing.ImageIcon;

//Class King is a subclass of Piece and includes the King image and valid moves
//Kings can move one space in any direction
public class King extends Piece
{
	public King(boolean position, String side)
	{
		//The color (black or white) indicates which ImageIcon to use
		color = side;
		if(color.equals("black"))
		{
			ImageIcon kingIcon = new ImageIcon(this.getClass().getResource("bking.gif"));
			pieceImage = kingIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon kingIcon = new ImageIcon(this.getClass().getResource("wking.gif"));
			pieceImage = kingIcon;
		}
		
	}
	
	//Method canMove is an abstract inherited method from Piece
	//Inputs: the current coordinates and the destination coordinates
	//Outputs: boolean value of whether or not the piece can move to the destination
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//Check if vertical one space move
		if(destX==originX && Math.abs(destY-originY) ==1)
		{
			//Making sure that the destination is either empty or has an opponent's piece
			//Making sure the path is also empty
			if( Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.position[destY][destX] != null &&  Chess.position[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
		}
		//Check if horizontal one space move
		if(destY==originY && Math.abs(destX-originX) == 1)
		{
			//Making sure that the destination is either empty or has an opponent's piece
			//Making sure the path is also empty
			if( Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.position[destY][destX] != null &&  Chess.position[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
		}
		//Check if diagonal one space move
		if(Math.abs(destX-originX) == 1 && Math.abs(destY-originY) == 1)
		{
			//Making sure that the destination is either empty or has an opponent's piece
			//Making sure the path is also empty
			if( Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.position[destY][destX] != null &&  Chess.position[destY][destX].color != color)
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

