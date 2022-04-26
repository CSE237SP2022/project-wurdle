package test;

import org.junit.jupiter.api.BeforeEach;


import constructGame.Wurdle;
import constructGame.WurdleBoard;
import userPlay.GamePlay;


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

public class unitTestsTest {
	private Wurdle game;
	private Scanner scan;
	private GamePlay testPlay;
	@BeforeEach
	void setup()
		
	{	  
		String input = "hello";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
		scan = new Scanner(System.in);
		
    	 game = new Wurdle(scan);
    	 ArrayList<String> guesses = new ArrayList<String>();
    	 ArrayList<String> feedback = new ArrayList<String>();
    	 ArrayList<Character> incorrectLetters = new ArrayList<Character>();
    	 testPlay = new GamePlay(scan, guesses, feedback, incorrectLetters);
 
	}
  
   @Test
   void testUserSidePlay() {
	   int roundNum=1; 
	   String randomWord = "washu";
	   Boolean correctGuessOnFirstRound = testPlay.userSidePlay(roundNum, randomWord);
	   assertFalse(correctGuessOnFirstRound);
	   
   }
   @Test
   void testUserSidePlay_wonGame() {
	   int roundNum=1; 
	   String randomWord = "hello";
	   Boolean correctGuessOnFirstRound = testPlay.userSidePlay(roundNum, randomWord);
	   assertTrue(correctGuessOnFirstRound);
	   
   }
   @Test
   void testMakeFirstGuess() {


		int originalNumGuesses = testPlay.userGuesses.size();

		ArrayList<String> returnedGuesses = testPlay.makeGuesses(1);

	
		assertEquals(originalNumGuesses+1, returnedGuesses.size());

   }
   @Test
   void testAddGuesses() {
		
		int originalNumGuesses = testPlay.userGuesses.size();
		
		testPlay.userInputWord = "washu";
		testPlay.addUserGuess();
		
		int updatedNumGuesses = testPlay.userGuesses.size();
		assertEquals(originalNumGuesses+1, updatedNumGuesses);

   }
   
	 //TEST VALIDITY
   @Test 
   void testValidLengthInput() {
		testPlay.userInputWord = "washu";

		Boolean isValidLength = testPlay.checkValidInput();
	    
		assertTrue(isValidLength);


   }


   @Test
       void testInvalidInputTooFewLetters() {
   
   		testPlay.userInputWord = "wa";
   	
   		Boolean isValidLength = testPlay.checkValidInput();
   
   		assertFalse(isValidLength);
  

       }
   @Test
   void testInvalidInputTooManyLetters() {

		testPlay.userInputWord = "washington";
	
		Boolean isValidLength = testPlay.checkValidInput();

		assertFalse(isValidLength);


   }

   @Test
       void testInvalidInputDuplicateWord(){
	    	testPlay.userInputWord = "shook";
	    	testPlay.alreadyUsedString="shook";
	    	
			Boolean isUniqueWord = testPlay.checkValidInput();
	
			assertFalse(isUniqueWord);
           
   	}
   
   @Test
   void testValidNonDuplicateWords(){
	   	testPlay.userInputWord = "shook";
	   	testPlay.alreadyUsedString="shack";
   	
		Boolean isUniqueWord = testPlay.checkValidInput();

		assertTrue(isUniqueWord);
       
	}
   
   //TEST COMPARE WORDS
   @Test
   void compareUserAndWurdleWords_singleSameChar_rightSpot() {
	   testPlay.userInputWord="workd";
	   String generatedWord = "washu";  
	   
	   String correctFeedback = "wxxxx";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   int originalSize = testPlay.userFeedback.size();
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	  
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	 
	   assertEquals(originalSize+1, testPlay.userFeedback.size());
	  
	   
   }
   @Test
   void compareUserAndWurdleWords_singleSameChar_wrongSpot() {
	   testPlay.userInputWord="porks";
	   String generatedWord = "washu"; 
	   
	   String correctFeedback = "xxxx-";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	   
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	   
	   
   }
   @Test
   void compareUserAndWurdleWords_multipleSameChar_rightSpot() {
	   testPlay.userInputWord="warkd";
	   String generatedWord = "washu"; 
	   
	   String correctFeedback = "waxxx";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	   
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	   
	   
   }
   @Test
   void compareUserAndWurdleWords_multipleSameChar_wrongSpot() {
	   testPlay.userInputWord="sorka";
	   String generatedWord = "washu"; 
	   
	   String correctFeedback = "-xxx-";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	   
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	   
	   
   }
   @Test
   void compareUserAndWurdleWords_allCorrect() {
	   testPlay.userInputWord="washu";
	   String generatedWord = "washu"; 
	   
	   String correctFeedback = "washu";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	   
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	   
	   
   }
   @Test
   void compareUserAndWurdleWords_allInorrect() { 
	   testPlay.userInputWord="retin";
	   String generatedWord = "washu"; 
	   
	   String correctFeedback = "xxxxx";
	   ArrayList<String> correctFeedbackForBoard = new ArrayList<String>();
	   correctFeedbackForBoard.add(correctFeedback);
	   
	   ArrayList<String> feedbackReturned = testPlay.compareUserAndWurdleWords(generatedWord);
	   
	   assertEquals(correctFeedbackForBoard, feedbackReturned);
	   
	   
   }
   //TEST UPDATE FEEDBACK
   @Test
   void testUpdateFeedback_correctLetterAndSpot() {
	   //for this test, we do not need to input the random word. let's say it is washu here
	   Boolean letterMatchesGeneratedLetter = true;
	   int indexInEnteredWord = 0;
	   testPlay.userInputWord="wordl";
	   int numCorrectLetters = testPlay.correctLetterCounter;
	   
	   testPlay.letterInCorrectSpot=false; 
	   
	  
	   testPlay.updateFeedback(testPlay.correctLetterAndSpot, letterMatchesGeneratedLetter, indexInEnteredWord);
	   
	   assertTrue(testPlay.letterInCorrectSpot);
	   
	   String letterPositionFeedback = "correct letter, correct space" + System.lineSeparator();
	   assertEquals(testPlay.currentFeedback, letterPositionFeedback);
	   
	   assertEquals(numCorrectLetters+1, testPlay.correctLetterCounter); 
	   
	   assertEquals(testPlay.feedbackOnBoard, "w");
   }
   
   @Test
   void testUpdateFeedback_correctLetterWrongSpot() {
	 //for this test, we do not need to input the random word. let's say it is washu here
	   Boolean letterMatchesGeneratedLetter = false;
	   int indexInEnteredWord = 0;
	   testPlay.userInputWord="rowen";
	   int numCorrectLetters = testPlay.correctLetterCounter;
	   
	  
	   testPlay.updateFeedback(testPlay.correctLetterWrongSpot, letterMatchesGeneratedLetter, indexInEnteredWord);
	   
	   assertFalse(testPlay.letterInCorrectSpot);
	   
	   String letterPositionFeedback = "correct letter, wrong space" + System.lineSeparator();
	   assertEquals(testPlay.currentFeedback, letterPositionFeedback);
	   
	   assertEquals(numCorrectLetters, testPlay.correctLetterCounter); 
	    
	   assertEquals(testPlay.feedbackOnBoard, "-");
   }
   
   @Test
   void testGiveUserFeedbackOnEntireWord_correctWord() {
	   testPlay.correctLetterCounter = 5;
	   Boolean guessIsCorrect = testPlay.giveUserFeedbackOnEntireWord();
	   assertTrue(guessIsCorrect);
   }
   
   @Test
   void testGiveUserFeedbackOnEntireWord_incorrectWord() {
	   testPlay.correctLetterCounter = 2;
	   Boolean guessIsCorrect = testPlay.giveUserFeedbackOnEntireWord();
	   assertFalse(guessIsCorrect);
   } 
   
    


    @Test 
        void testUpdateFalseLetters(){
            char userWordCharacter = 'm';
            int originalIncorrectLetterSize = testPlay.incorrectLetters.size();
            testPlay.updateFalseLetters(userWordCharacter);
            
            assertEquals(originalIncorrectLetterSize+1, testPlay.incorrectLetters.size());
            assertEquals(testPlay.feedbackOnBoard, "x");
            
            
    	}

 

}