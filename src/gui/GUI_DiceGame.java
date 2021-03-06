package gui;

import java.util.*;
import javax.swing.*;

public class GUI_DiceGame 
{
	int numDice;
	int hotScore;
	
	public GUI_DiceGame(){numDice = 0; hotScore = 0;}
    
    public boolean checkFarkle (int [] dice)
	{
		int neededDice[]={0,1,3, 3, 3, 1, 3};
	    int counter [] = {0,0,0,0,0,0,0};
	    int noScoreCount = 0;
	    
	    for (int count = 0; count < dice.length; count++)
	    {
	        counter[dice[count]]++;
	    }

	    for (int count = 1; count < 7; count ++)
	    {
	        if (counter[count]<neededDice[count]) {noScoreCount++;}
	    }
	    if (noScoreCount == 6){return true;}
	    else {return false;}
	}
	
	public int scoreDice (int [] dice)
	{
	    int score = 0;
		int [] counter = {0,0,0,0,0,0,0};
	    int [] scores = {0,100,50,1000,200,300,400,500,600};
	    boolean [] scorable  = new boolean [9];
	    Arrays.fill(scorable, Boolean.FALSE);
	    StringBuilder scoreChoicesString = new StringBuilder("");
	    StringBuilder diceString = new StringBuilder("");
	    String [] choices;
	    String [] scoreChoices = {"", "\n1. Each 1 ------ 100 points",
	                                  "\n2. Each 5 ------ 50 points",
	                                  "\n3. Three 1's --- 1000 points",
	                                  "\n4. Three 2's --- 200 points",
	                                  "\n5. Three 3's --- 300 points",
	                                  "\n6. Three 4's --- 400 points",
	                                  "\n7. Three 5's --- 500 points",
	                                  "\n8. Three 6's --- 600 points",};
	    
	    for (int x = 0; x < dice.length; x++) {counter[dice[x]]++;}
	    
	    for (int x = 0; x < dice.length; x++) {diceString.append(dice[x]+" ");}
	    
	    if (counter[1] == 2)
	    {
	        scores[1] = 200;
	    } 
	    
	    if (counter[5] == 2)
	    {
	        scores[2] = 100;
	    }  
	    
	    for (int x = 1; x < 7; x++)
	    {
	    	switch (counter[x])
	    	{
	    	   case 1:
	    	   if (x == 1)
	    	   {
	    		   scorable[1] = true;
	    		   break;		   
	    	   }
	    	   else if (x == 5)
	    	   {
	    		   scorable[2] = true;
	    		   break;
	    	   }
	    	   else 
	    	   {
	    		   break;
	    	   }
	    	   
	    	   case 2:
	    	   if (x == 1)
		       {
		    	  scorable[1] = true;
		    	  break;		   
		       }
		       else if (x == 5)
		       {
		    	  scorable[2] = true;
		    	  break;
		       }
		       else 
		       {
		    	  break;
		       }
	    	   
	    	   case 3:
	    	   scorable[x + 2] = true;
	    	   break;
	    	   
	    	   default:
	    	   break;
	    	}
	    } 
	    
	    
	    for (int x = 1; x < 9; x++)
	    {
	    	if (scorable[x] == true)
	    	{
	    		scoreChoicesString.append(scoreChoices[x]);

	    	}
	    }
	    
	    choices = JOptionPane.showInputDialog(null, "You rolled: "+diceString+scoreChoicesString+"\nEnter the number/numbers of the options you wish to choose."+
		                                                                                         "\nIf you make multiple selections, seperate each choice by "+
		                                                                                         "\na space: ", "Scoring Phase").split("\\s");
	    
	    int [] userChoices = new int [choices.length];
	    int foo;
	    
	    for (int x = 0; x < choices.length; x++)
	    {
	    	foo = Integer.parseInt(choices[x]);
	        userChoices[x] = foo;
	    }
	    for (int x = 0; x < userChoices.length; x++)
	    {
	    	score += scores[userChoices[x]];
	    }
	    
	    numDice = dice.length;
	    
	    for (int x = 0; x < userChoices.length; x++)
	    {
	        switch (userChoices[x])
	        {
	            case 1:
	            numDice -= counter[1];
	            break;
	            
	            case 2:
	            numDice -= counter[2];
	            break;
	            
	            case 3:
	            numDice -= counter[1];
	            break;
	            
	            case 4:
	            numDice -= counter[2];
	            break;
	            
	            case 5:
	            numDice -= counter[3];
	            break;
	            
	            case 6:
	            numDice -= counter[4];
	            break;
	            
	            case 7:
	            numDice -= counter[5];
	            break;
	            
	            case 8:
	            numDice -= counter[6];
	            break;
	        }
	    }
        return score;	
	}
	
	public boolean checkHotDice(int [] dice)
	{
	    hotScore = 0;
	    String[] choices;
	    int numDice1 = dice.length;
		int [] counter = {0,0,0,0,0,0,0};
	    int [] scores = {0,100,50,1000,200,300,400,500,600};
	    boolean [] scorable  = new boolean [9];
	    Arrays.fill(scorable, Boolean.FALSE);
	    
	    for (int x = 0; x < dice.length; x++) {counter[dice[x]]++;}
	    
	    if (counter[1] == 2)
	    {
	        scores[1] = 200;
	    } 
	    
	    if (counter[5] == 2)
	    {
	        scores[2] = 100;
	    }
	    
	    for (int x = 1; x < 7; x++)
	    {
	    	switch (counter[x])
	    	{
	    	   case 1:
	    	   if (x == 1)
	    	   {
	    		   scorable[1] = true;
	    		   break;		   
	    	   }
	    	   else if (x == 5)
	    	   {
	    		   scorable[2] = true;
	    		   break;
	    	   }
	    	   else 
	    	   {
	    		   break;
	    	   }
	    	   
	    	   case 2:
	    	   if (x == 1)
		       {
		    	  scorable[1] = true;
		    	  break;		   
		       }
		       else if (x == 5)
		       {
		    	  scorable[2] = true;
		    	  break;
		       }
		       else 
		       {
		    	  break;
		       }
	    	   
	    	   case 3:
	    	   scorable[x + 2] = true;
	    	   break;
	    	   
	    	   default:
	    	   break;
	    	}
	    }
	    
	    StringBuilder allChoices = new StringBuilder("");
	    
	    for (int x = 1; x < 9; x++)
	    {
	        if (scorable[x] == true)
	        {
	           allChoices.append(x+" ");
	        }   
	    }
	    
	    choices = allChoices.toString().split("\\s");
	    
	    int [] userChoices = new int [choices.length];
	    int foo;
	    
	    for (int x = 0; x < choices.length; x++)
	    {
	    	foo = Integer.parseInt(choices[x]);
	        userChoices[x] = foo;
	    }
	    for (int x = 0; x < userChoices.length; x++)
	    {
	    	hotScore += scores[userChoices[x]];
	    }
	    
	    for (int x = 0; x < userChoices.length; x++)
	    {
	        switch (userChoices[x])
	        {
	            case 1:
	            numDice1 -= counter[1];
	            break;
	            
	            case 2:
	            numDice1 -= counter[2];
	            break;
	            
	            case 3:
	            numDice1 -= counter[1];
	            break;
	            
	            case 4:
	            numDice1 -= counter[2];
	            break;
	            
	            case 5:
	            numDice1 -= counter[3];
	            break;
	            
	            case 6:
	            numDice1 -= counter[4];
	            break;
	            
	            case 7:
	            numDice1 -= counter[5];
	            break;
	            
	            case 8:
	            numDice1 -= counter[6];
	            break;
	        }
	    }
	    
	    if (numDice1 == 0)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
    }
    
    public int returnHotScore(){return hotScore;}
    
    public void resetHotScore() {hotScore = 0;}
    
    public int reCountDice(){return numDice;}
}



