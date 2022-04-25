package test;

import org.junit.jupiter.api.BeforeEach;

import constructGame.Wurdle;
import constructGame.WurdleBoard;
import userPlay.GamePlay;


import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class unitTestsTest {
	@BeforeEach
	void setup() {
        Scanner scan = new Scanner(System.in);
        Wurdle game = new Wurdle(scan);
        game.play();
	}
    
    @Test
    public void user_right_test() {
    	//fix 
        String user_word = "bears";
        String generated_word = "bears";
      
        assertEquals(user_right, true);

    }

    @Test
    void user_wrong_test() {
    	//fix
        String user_word = "bears";
        String generated_word = "bytes";

        
        
        assertEquals(user_wrong, true);

    }

    @Test
    void feedback_test() {
    	//fix
        String user_word = "bears";
        String generated_word = "bytes";

        CompareUserWord compare = new CompareUserWord();
        boolean user_wrong = compare.compare_words(user_word, generated_word);
        String feedback = compare.allFeedback;

        String correct_feedback = "b: correct letter, correct space\ne: correct letter, wrong space\na: letter not used\nr: letter not used\ns: correct letter, correct space";
        assertEquals(user_wrong,correct_feedback);

    }

    @Test
        void testInvalidInputTooFewLetters() {
    		//fix
            String user_word = "be";
            String generated_word = "bears";

            userPlay.GetUserFirstWord smallWord = new userPlay.GetUserFirstWord();
            boolean user_wrong = smallWord.invalidInput(user_word, generated_word);
            String feedback = smallWord.allFeedback;

            String correct_feedback = "b: correct letter, correct space\ne: correct letter, wrong space\na: letter not used\nr: letter not used\ns: correct letter, correct space";
            assertEquals(user_wrong,correct_feedback);

        }

    @Test
        void testCheckForNoDups(){
    		
            
    	}


    @Test
        void testupdateFeedback(){
            String updateWithCorrectOrIncorrect ="hello";
            Boolean correct = false;
            int charInUser = 1;

            //String correct_allFeedback = '--FILL IN---';

            //AssertEquals(correct_allFeedback, GamePlay.allFeedback)
                    
    	}

    @Test 
        void testFalseComparison(){
            //ArrayList<Character> incorrectLettersm ="--FILL IN---";
           // char userWordCharacter ="--FILL IN---";
            
           // String correct_allFeedback = "--FILL IN---";

            //AssertEquals(correct_allFeedback, GamePlay.allFeedback)
    	}

    @Test 
        void testGameOver(){
            //print method 
    
    	}

    @Test 
        void runNextRound(){
           
    }

    @Test 
        void readWurdleWordsFromFile(){
            
    }

    @Test 
        void chooseRandomWord(){
           
    }


    @Test 
        void testReturnUserKeyboard(){
           
    }
}