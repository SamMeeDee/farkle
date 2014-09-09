import java.util.*;
import java.io.*;

public class main 
{
	public static void main(String[] args) 
	{
	    Player p1, p2;
	    DiceGame game = new DiceGame();
	    int playAgain;
	    boolean playAgain1 = true;
	    int p1Choice, p2Choice;
	    char p1Roll, p2Roll;
	    boolean p1Turn = true, p2Turn= false;
	    boolean p1HasHotDice = true, p2HasHotDice = true;
	    boolean p1ReRoll = false, p2ReRoll = false;
	    Scanner keyboard = new Scanner(System.in);
	    
	    System.out.println("Welcome to Farkle!"); 
	    
	    System.out.print("Player 1, please enter your name: ");
	    p1 = new Player (keyboard.nextLine());
	    
	    System.out.print("Player 2, please enter your name: ");
	    p2 = new Player (keyboard.nextLine());
	
	while (playAgain1 = true)
	{
		while (p1.getScore()<10000 && p2.getScore()<10000)
		{
		    p1:while (p1Turn == true && (p1HasHotDice == true || p1ReRoll == true))
		    {
		        System.out.print(p1.getName() + ", press y to roll your dice: ");
		        p1Roll = keyboard.nextLine().charAt(0);
		        if (p1Roll == 'y')
		        {
		            if (game.checkFarkle(p1.getDice()) == true)
		            {
		                System.out.println("You Farkled! You've lost all your points!");
	                    p1.setScore(0);
	                    p1HasHotDice = false;
	                    p1Turn = false;
	                    continue p1;
		            }
		            if (game.checkHotDice(p1.getDice()) == true)
		            {
		                System.out.println("You rolled hot dice! All your dice are scored,\nand you get to roll again!");
		                p1.setScore(game.returnHotScore()+p1.getScore());
		                p1HasHotDice = true;
		                game.resetHotScore();
		                p1.setDice();
		                continue p1;
		            }    
		            
		            p1HasHotDice = false;
		            
		            System.out.println("You rolled:" + "\n");
		            for (int x = 0; x < p1.getDice().length; x++){System.out.print(p1.getDice()[x] + " ");}
		            
		            p1.setScore(game.scoreDice(p1.getDice())+p1.getScore());
		            p1.setNumDice(game.reCountDice());
		            
		            System.out.println("Your score is: " + p1.getScore());
		            System.out.println("You have " + p1.getNumDice() + " dice remaining");
		            do
		            {
		               System.out.print("\n1. Reroll your remaining dice (warning: if you farkle, you will lose ALL your score)"+
		                                  "\n2. End your turn"+"\nEnter your choice: ");
		               p1Choice = keyboard.nextInt();
		            } while (p1Choice != 1 && p1Choice != 2);
		            
		            keyboard.nextLine();
		            
		            if (p1Choice == 1){p1ReRoll = true; p1.setDice(); continue p1;}
		            if (p1Choice == 2){p1Turn = false; continue p1;}
		    }    
		    
		}
	    
		p2Turn = true;

		p2:while (p2Turn == true && (p2HasHotDice == true || p2ReRoll == true))
		   {
		        System.out.print(p2.getName() + ", press y to roll your dice: ");
		        p2Roll = keyboard.nextLine().charAt(0);
		        if (p2Roll == 'y')
		        {
		            if (game.checkFarkle(p2.getDice()) == true)
		            {
		                System.out.println("You Farkled! You've lost all your points!");
	                    p2.setScore(0);
	                    p2HasHotDice = false;
	                    p2Turn = false;
	                    continue p2;
		            }
		            if (game.checkHotDice(p2.getDice()) == true)
		            {
		                System.out.println("You rolled hot dice! All your dice are scored,\nand you get to roll again!");
		                p2.setScore(game.returnHotScore()+p2.getScore());
		                game.resetHotScore();
		                p2HasHotDice = true;
		                p2.setDice();
		                continue p2;
		            }    
		            
		            p2HasHotDice = false;
		            
		            System.out.println("You rolled:" + "\n");
		            for (int x = 0; x < p2.getDice().length; x++){System.out.print(p2.getDice()[x] + " ");}
		            
		            p2.setScore(game.scoreDice(p2.getDice())+p2.getScore());
		            p2.setNumDice(game.reCountDice());
		            
		            System.out.println("Your score is: " + p2.getScore());
		            System.out.println("You have " + p2.getNumDice() + " dice remaining");
		            do
		            {
		               System.out.print("\n1. Reroll your remaining dice (warning: if you farkle, you will lose ALL your score)"+
		                                  "\n2. End your turn"+"\nEnter your choice: ");
		               p2Choice = keyboard.nextInt();
		            } while (p2Choice != 1 && p2Choice != 2);
		            
		            keyboard.nextLine();
		            
		            if (p2Choice == 1){p2ReRoll = true; p2.setDice(); continue p2;}
		            if (p2Choice == 2){p2Turn = false; continue p2;}
		        }    
		}
		p1Turn = true; p2Turn= false;
	    p1HasHotDice = true; p2HasHotDice = true;
	    p1ReRoll = false; p2ReRoll = false;
	    p1.setNumDice(6); p2.setNumDice(6);
	    p1.setDice(); p2.setDice();
	}
    
	if (p1.getScore() < 10000){System.out.println ("Congratulations " + p1.getName() + ", you won the game!!");}
	if (p2.getScore() < 10000){System.out.println ("Congratulations " + p2.getName() + ", you won the game!!");}   
	
	do
    {
		System.out.println("\n1. Play again"+
		                   "\n2. End the game"+"\nEnter your choice: ");
		playAgain = keyboard.nextInt();
    } while (playAgain == 1 || playAgain == 2);
		            
	if (playAgain == 1){playAgain1 = true; p1.setScore(0); p2.setScore(0); continue;}
	else if (playAgain == 2){playAgain1 = false; continue;}
}
}
}
