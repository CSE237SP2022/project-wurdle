package test;

import org.junit.jupiter.api.BeforeEach;


import constructGame.Wurdle;
import constructGame.WurdleBoard;



import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TestWurdleCreation {
	private Wurdle game;
	private Scanner scan;
	@BeforeEach
	void setup()
		
	{	  
		String input = "hello";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
		scan = new Scanner(System.in);
    	 game = new Wurdle(scan);
 
	}
  
//TEST IF USER WON
   @Test 
   void testDidUserWin_NoMoreGuesses(){
       int roundNum = 7;
       game.isUserWordCorrect=false;
       Boolean ranOutOfGuesses = game.didUserWin(roundNum);
       
       assertFalse(ranOutOfGuesses);
   
   	}
   @Test 
   void testDidUserWin_WinGame(){
       int moreRoundsLeft = 2;
       game.isUserWordCorrect=true;
       Boolean wonGame = game.didUserWin(moreRoundsLeft);
       
       assertTrue(wonGame);

    }
    
    //TEST RUNNING USER ROUNDS
   @Test
   void testRunNextRound() {
	   int roundNum=1; 
	   Boolean correctGuessOnFirstRound = game.runNextRound(roundNum);
	   assertFalse(correctGuessOnFirstRound);
	   
   } 

//TEST READING IN WORDS
   @Test 
       void testReadWurdleWordsFromFile() throws FileNotFoundException{
   		int originalWordList = game.word_list.size();
   		game.readWurdleWordsFromFile();
   		int addedToWordList = game.word_list.size();
   		assertEquals(originalWordList+16, addedToWordList);
          
   }
//TEST CHOOSING WORD
   @Test 
       void testChooseRandomWord() throws FileNotFoundException{
   		game.randomWurdleWord="startingWord";
   		String startingWord = game.randomWurdleWord;
   		game.readWurdleWordsFromFile();
   		game.chooseRandomWord();
   		String newWordHasBeenChosen = game.randomWurdleWord;
   		
   		Boolean newWordChosen = startingWord.equals(newWordHasBeenChosen);
   		
   		assertFalse(newWordChosen);
   		
          
   }
}
   
