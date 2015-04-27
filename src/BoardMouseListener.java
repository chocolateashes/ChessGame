import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Class BoardMouseListener implements MouseListener
//Looks at mouse events and runs methods based on them
public class BoardMouseListener implements MouseListener
{

	int initialX;
	int initialY;
	int finalX;
	int finalY;

	static Piece currentPosition;
	public static Piece piece;

	@Override
	public void mouseClicked(MouseEvent e) {}


	//Method mousePressed finds the coordinates of where the mouse was pressed
	public void mousePressed(MouseEvent e) 
	{		
		initialX = (e.getX()*8)/Chess.WIDTH;
		initialY = (e.getY()*8)/Chess.WIDTH;
		//currentPosition is the item in the position array that corresponds to the pressed coordinates
		currentPosition = Chess.position[initialY][initialX];		
	}

	//Method mouseReleased finds the coordinates of where the mouse was released
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		finalX = (e.getX()*8)/Chess.WIDTH;
		finalY = (e.getY()*8)/Chess.WIDTH;
		
		//Boolean variable Chess.turn keeps track of whose turn it is in the game
		//True means it's black's turn
		//False means it's white's turn
		if(Chess.turn==true)
		{
			Chess.whoseTurn = "black";
		}
		if(Chess.turn == false)
		{
			Chess.whoseTurn = "white";
		}
		
		//Once whoseTurn (the color equivalent of the boolean turn) is determined
		//Check whether the selected piece is the same color as whoseTurn
		if(Chess.gameOver==false){
		if(Chess.position[initialY][initialX].color.equals(Chess.whoseTurn))
		{
			//Can selected piece move to the destination coordinates?
			boolean isTrue = currentPosition.canMove(initialX, initialY, finalX, finalY);
			if(isTrue==true)
			{
				//If it can, then set final coordinates to the selected piece and initial coordinates to null
				if(Chess.position[finalY][finalX] instanceof King)
				{
					Chess.gameOver = true;
					Chess.position[finalY][finalX] = currentPosition; 
					Chess.position[initialY][initialX] = null;
				}
				//If the black pawn makes it to the end of the board, it can turn into a queen
				if(finalY == 7 && Chess.position[initialY][initialX] instanceof Pawn)
				{
					Chess.position[finalY][finalX] = new Queen(true, "black");
					Chess.position[initialY][initialX] = null;
				}
				else
				{
					Chess.position[finalY][finalX] = currentPosition; 
					Chess.position[initialY][initialX] = null;
				}
				//Repaint the board and switch the turn variable
				Chess.board.repaint();
				Chess.turn ^=true;
			}
		}
		
		else
		{
			System.out.println("Can't move there!");
		}}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
