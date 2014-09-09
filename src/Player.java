import java.util.Random;

public class Player 
{
	private String firstName;
	private int score;
	private int [] dice;
	private int numDice = 6;
	private Random rng = new Random(); 

	//constructor 
	public Player (String inF)
	{
		firstName = new String (inF);
		score = 0;	
		dice = rollDice();
	}
	
	public int [] rollDice ()
	{
		int [] dice1 = new int[numDice];
		
		for (int die = 0; die < numDice; die++)
		{
			dice1[die] = (rng.nextInt(numDice)) + 1; 
		}
		
		return dice1;
	}
	
	public int [] getDice()
	{
		return dice;
	}
	
	public void setDice() {dice = rollDice();}
	
	public int getNumDice()
	{
	    return numDice;
	}    
	
	public void setNumDice(int inNum)
	{
	    numDice = inNum;
	}
	
	public String getName ()
	{
		return firstName;
	}
	
	public int getScore ()
	{
		return score;
	}
	
	public void setScore (int inScore)
	{
		score = inScore;
	}

}
