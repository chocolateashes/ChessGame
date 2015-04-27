import java.awt.Graphics;
import javax.swing.ImageIcon;

//Class Pawn is a subclass of Piece and includes the Pawn image and valid moves
//Pawns can only move 1 square forward unless it's their first move
//Pawns can move diagonally to kill
public class Pawn extends Piece
{
	public Pawn(boolean position, String side)
	{
		//The color (black or white) indicates which ImageIcon to use
		color = side;
		if(color.equals("black"))
		{
			ImageIcon pawnIcon = new ImageIcon(this.getClass().getResource("bpawn.gif"));
			pieceImage = pawnIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon pawnIcon = new ImageIcon(this.getClass().getResource("wpawn.gif"));
			pieceImage = pawnIcon;
		}
	}
	
	//Method canMove is an abstract inherited method from Piece
	//Inputs: the current coordinates and the destination coordinates
	//Outputs: boolean value of whether or not the piece can move to the destination
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//Pawn can move diagonally if the destination space has an opponent's piece
		//if(Math.abs(destX-originX) == 1 && Math.abs(destY-originY) == 1 && Chess.position[destY][destX]!= null && Chess.position[destY][destX].color != color)
		//{
			//return canPieceMove = true;
		//}
	
		//If the pawn's color is black, it can move down the chessboard
		//Pawn can move two spaces down when it's making its first move
		if(Chess.position[originY][originX].color.equals("black"))		
		{
			if(originY==1 && destX==originX && destY-originY ==2 && Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(destX==originX && destY-originY ==1 && Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(Math.abs(destX-originX) == 1 && destY-originY == 1 && Chess.position[destY][destX]!= null && Chess.position[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
			else
				return canPieceMove = false;
		}
		
		//If the pawn's color is white, it can move up the chessboard
		//Pawn can move two spaces down when it's making its first move
		if(Chess.position[originY][originX].color.equals("white"))
		{
			if(originY==6 && destX==originX && destY-originY ==-2 && Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(destX==originX && destY-originY == -1 && Chess.position[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(Math.abs(destX-originX) == 1 && destY-originY == -1 && Chess.position[destY][destX]!= null && Chess.position[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
			else
				return canPieceMove = false;
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