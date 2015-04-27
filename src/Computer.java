import java.util.Random;

//Class Computer is the AI computer player
public class Computer {
	
	//coordinates
	public static int x1;
	public static int x2;
	public static int y1;
	public static int y2;
	
	//Method computerMove monitors the moves the computer makes
	//Computer scans through the position array to find an appropriate piece then does so again to choose a destination
	public static void computerMove()
	{
		Random rand = new Random();
		
		//Choosing a piece to move
		outer: for(int i = rand.nextInt(8) ; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(Chess.position[i][j] != null && Chess.position[i][j].color.equals("white"))
				{
					x1 = j;
					y1 = i;
					break outer;
					//break if the piece is white
					}
				}
			}
		
			//choosing a place to move
			outerloop: for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
					boolean isTrue = Chess.position[y1][x1].canMove(x1, y1, i, j);
					if(isTrue==true)
					{
						x2 = i;
						y2 = j;
						break outerloop;
						//break if the destination is valid
					}
				}
			}
		System.out.println("Computer moves " + Chess.position[y1][x1] +  Chess.position[y1][x1].color+ " to" + x2 + " " + y2);
	}		
}
