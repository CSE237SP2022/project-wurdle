package userPlay;

import java.util.ArrayList;
import java.util.Scanner;
import constructGame.*;



public class GamePlay {
   
     public String correctLetterAndSpot = "correct letter, correct space";
     public String incorrectLetterAndSpot = "letter not used";
     public String correctLetterWrongSpot = "correct letter, wrong space";
     public String currentFeedback;

     public String userInputWord;
     public String previousGuess;
     public int guessesIndex;
     public Scanner scan;
     public Boolean sameLetter;
     public int correctLetterCounter;
     public Boolean letterInCorrectSpot;
     public ArrayList<Character> incorrectLetters;
     public String feedbackOnBoard;
     public ArrayList<String> userGuesses;
     public ArrayList<String> userFeedback;
 

    public GamePlay(Scanner scan, ArrayList<String> userGuesses, ArrayList<String> userFeedback, ArrayList<Character> incorrectLetters){
        this.previousGuess="";
        this.userInputWord = "";
        this.guessesIndex = 0;
        this.scan=scan;
        this.sameLetter=false;
        this.correctLetterCounter = 0;
        this.letterInCorrectSpot = false;
        this.incorrectLetters= incorrectLetters;
        this.feedbackOnBoard = "";
        this.currentFeedback = "";
        this.userFeedback = userFeedback;
        this.userGuesses = userGuesses;
    }

    public Boolean didUserGuessCorrectly(int roundIterator, String randomWurdleWord) {
    	makeGuesses(roundIterator);
        
        System.out.println("You guessed: " + this.userGuesses.get(roundIterator-1)); 
        this.userFeedback = compareUserAndWurdleWords(randomWurdleWord);
        
        WurdleBoard gameBoard = new WurdleBoard();
        gameBoard.printBoard(this.userGuesses, this.userFeedback);
        gameBoard.updateUserKeyboard(this.incorrectLetters);
        
        return giveUserFeedbackOnEntireWord();
    }
    
    
     public ArrayList<String> makeGuesses(int roundIterator){
        useScanner();
        
        this.guessesIndex = 0;  

        if(roundIterator == 1 && this.userInputWord.length() == (5)){
            addUserGuess();            
        }  
        else{  
        	
             while(this.userGuesses.size()>this.guessesIndex && roundIterator>1){
            	 
                previousGuess = this.userGuesses.get(guessesIndex); 
                Boolean inputIsValid = checkValidInput();
                
                while(!inputIsValid) {
                	inputIsValid=checkValidInput();
                }
                
                this.guessesIndex++;
                if ((roundIterator - this.guessesIndex == 1)){
                    if (inputIsValid){
                    	addUserGuess();
                    }
                    break;
                }  
            }
         } 
        return this.userGuesses; 
    }
     
     
    public void addUserGuess() {
    	 this.userGuesses.add(this.userInputWord);
    }

    
    public Boolean checkValidInput(){
    	
        if (this.userInputWord.equals(previousGuess)){
            System.out.println("try again, must be a unique word");
            this.userInputWord = useScanner();
            return false;
        }

    	if(this.userInputWord.length() != 5) {
    		System.out.println("try again, must be 5 letters");
            this.userInputWord = useScanner();
            return false;
    		  
    	}
    	else {
    		return true;
    	}
    } 

    
    public String useScanner(){
        this.userInputWord = this.scan.nextLine(); 
        return this.userInputWord;
    }
  

    public ArrayList<String> compareUserAndWurdleWords(String generated_word) {
        for(int charInUser=0; charInUser<this.userInputWord.length(); charInUser++){
        	
        	resetVarsBetweenLetters();
            
            System.out.print(this.userInputWord.charAt(charInUser) + ": "); 

            for(int charInGeneratedWord=0; charInGeneratedWord<generated_word.length(); charInGeneratedWord++){
            	
                if((this.userInputWord.charAt(charInUser) == generated_word.charAt(charInGeneratedWord))){
                    this.sameLetter = true;
                    
                    if((charInUser == charInGeneratedWord)){
                        updateFeedback(correctLetterAndSpot, true, charInUser);
                    }
                    
                    else if(!this.letterInCorrectSpot){
                        updateFeedback(correctLetterWrongSpot, false, charInUser);
                    }
                }
            }
 
            if(!sameLetter){
                updateFalseLetters(this.userInputWord.charAt(charInUser));
            } 
            System.out.print(this.currentFeedback);
           
        } 
      
        this.userFeedback.add(this.feedbackOnBoard);
        return this.userFeedback;
}
    
    
    public void resetVarsBetweenLetters() {
    	  this.sameLetter = false;
          this.letterInCorrectSpot = false;
          this.currentFeedback = "";
    }
   
    
    
    public void updateFeedback(String letterPositionFeedback, Boolean lettersMatch, int charInUser){
        
        this.currentFeedback = letterPositionFeedback + System.lineSeparator();
        if(lettersMatch){
            this.letterInCorrectSpot = true;
            this.feedbackOnBoard += this.userInputWord.charAt(charInUser);
            this.correctLetterCounter ++;
        } 
        else{
            this.feedbackOnBoard += "-";  
        }
         
       
    }
    public Boolean giveUserFeedbackOnEntireWord() {
    	 if(this.correctLetterCounter == 5){
             System.out.println("You are correct!");
             return true;
         }
         else{
             System.out.println("Incorrect guess, please try again");
             return false;
         }
    }
    
    
    public void updateFalseLetters(char userWordCharacter){
        this.incorrectLetters.add(userWordCharacter);
        System.out.println(incorrectLetterAndSpot);
        this.feedbackOnBoard += "x";
    }

   
  }