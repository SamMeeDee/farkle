package gui;

import main.Player;
import javax.swing.*;

public class GUI_Driver 
{
	public static void main(String[] args) 
	{
		Player p1, p2;
	    GUI_DiceGame game = new GUI_DiceGame();
	    int playAgain;
	    boolean playAgain1 = true;
	    int p1Choice, p2Choice;
	    char p1Roll, p2Roll;
	    boolean p1Turn = true, p2Turn= false;
	    boolean p1HasHotDice = true, p2HasHotDice = true;
	    boolean p1ReRoll = false, p2ReRoll = false;
	    
	    p1 = new Player(JOptionPane.showInputDialog(null, "Player 1, enter your name:", "Welcome to Farkle", JOptionPane.QUESTION_MESSAGE));
	    p2 = new Player(JOptionPane.showInputDialog(null, "Player 2, enter your name:", "Welcome to Farkle", JOptionPane.QUESTION_MESSAGE));
	    
	    
	    
	    
	}

}
