import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

//This class draws the squares and the pieces in their current positions
public class BoardComponent extends JComponent 
{
	private Chess thechessmainobject;
	
	public BoardComponent(Chess chessmainobject) 
	{
		super();
		thechessmainobject = chessmainobject;
	}
	
	public void paintComponent(Graphics g)
	{		
		//creating the board
		Color c1 = new Color(177,113,24); //darker squares
		Color c2 = new Color(233,174,95); //lighter squares

		g.setColor(c1);
		
		g.fillRect(0, 0, Chess.WIDTH, Chess.WIDTH);	//fills the entire board with the darker color
		
		g.setColor(c2);
		for(int i = 0; i<8; i++)	//creates squares based on the width of the board and fills them
		{
			for(int j = 0; j<8; j++)
			{
				if(i%2==j%2)
				{
				g.fillRect(i*(Chess.WIDTH/8), j*(Chess.WIDTH/8), (Chess.WIDTH/8), (Chess.WIDTH/8));
				}
				
			}
		}
		
		//creates the initial structure of the pieces on the board
		//for loop goes through the position array and draws pieces where they are supposed to be
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(thechessmainobject.position[i][j]!=null)
				{
					thechessmainobject.position[i][j].drawPiece(((Chess.WIDTH/8)*j)+2, ((Chess.WIDTH/8)*i)+2, g);
				}
			}
		}	
	}
}
