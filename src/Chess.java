import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

//Class Chess is main class of the program
public class Chess extends BoardMouseListener
{
	//Piece initialized
	public static Piece piece;
	public static King king;

	
	//Monitor whose turn it is
	public static  boolean turn=false;
	public static String whoseTurn;
	
	//Boolean variable for whether someone's won
	public static boolean gameOver = false;
	
	//Coordinates for computer's turns
	public static int y1;
	public static int x1;
	public static int y2;
	public static int x2;
	
	//BoardComponent initialized
	public static BoardComponent board;
	
	//Position array initialized
	public static Piece[][] position = new Piece[8][8];
	
	//Coordinates
	public static int xpos;
	public static int ypos;
	
	//Window width
	public static final int WIDTH = 400;
	
	
	public Chess()
	{
		//Position array
		position[0][0] = new Rook(true, "black");
		position[0][1] = new Knight(true, "black");
		position[0][2] = new Bishop(true, "black");
		position[0][3] = new Queen(true, "black");
		position[0][4] = new King(true, "black");
		position[0][5] = new Bishop(true, "black");
		position[0][6] = new Knight(true, "black");
		position[0][7] = new Rook(true, "black");
		for(int i=0; i<8; i++)
		{
			position[1][i] = new Pawn(true, "black");
		}
		for(int j=2; j<6; j++)
		{
			for(int i=0; i<8;i++)
			{
				position[j][i] = null;
			}
		}
		for(int i=0; i<8; i++)
		{
			position[6][i] = new Pawn(true, "white");
		}
		position[7][0] = new Rook(true, "white");
		position[7][1] = new Knight(true, "white");
		position[7][2] = new Bishop(true, "white");
		position[7][3] = new Queen(true, "white");
		position[7][4] = new King(true, "white");
		position[7][5] = new Bishop(true, "white");
		position[7][6] = new Knight(true, "white");
		position[7][7] = new Rook(true, "white");
		
		//Make window
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, WIDTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		board = new BoardComponent(this);
		board.addMouseListener(this);
		board.repaint();
		
		frame.add(board);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Chess();
		
		//Game
		while(gameOver==false)
		{
			
			//If it's black's turn, prompt user to play
			if(turn == true)
			{
				System.out.println("Your turn!");
			}
			//If it's white's turn, call method computerMove in class Computer
			if(turn == false)
			{
				Computer.computerMove();
				Chess.whoseTurn = "white";
				currentPosition = Chess.position[Computer.y1][Computer.x1];
				//Is the computer's selected piece white?
				if(currentPosition.color.equals("white"))
				{
					//Is the computer's selected destination valid?
					if(currentPosition.canMove(Computer.x1, Computer.y1, Computer.x2, Computer.y2))
					{
						if(Chess.position[Computer.y2][Computer.x2] instanceof King)
						{
							Chess.gameOver = true;
							Chess.position[Computer.y2][Computer.x2] = currentPosition; 
							Chess.position[Computer.y1][Computer.x1] = null;
						}
						if(Computer.y2 == 0 && Chess.position[Computer.y1][Computer.x1] instanceof Pawn)
						{
							Chess.position[Computer.y2][Computer.x2] = new Queen(true, "white");
							Chess.position[Computer.y1][Computer.x1] = null;
						}
						//If so, set destination with chosen piece and set initial coordinates of chosen piece to be null
						else
						{
							Chess.position[Computer.y2][Computer.x2] = currentPosition;
							Chess.position[Computer.y1][Computer.x1] = null;
						}
						//Repaint the board and switch turns
						Chess.board.repaint();
						Chess.turn ^=true;
			
					}
				}
			}
		}
		System.out.println("Game over!");
	}
}
