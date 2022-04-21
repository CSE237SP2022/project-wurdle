package userPlay;

import java.util.ArrayList;
import java.util.Scanner;
import constructGame.*;



public class GamePlay {
   
     public String correctLetterAndSpot = "correct letter, correct space";
     public String incorrectLetterAndSpot = "letter not used";
     public String correctLetterWrongSpot = "correct letter, wrong space";
     public String allFeedback;
     public String currentFeedback;

     public String userInputWord;
     public String alreadyUsedString;
     public int arrlistIterator;
     public Scanner scan;
     public boolean compareLetters;
     public int correctLetterCounter;
     public boolean letterInCorrectSpot;
     public String keyboardFeedback;

    public GamePlay(Scanner scan){
        this.alreadyUsedString="";
        this.userInputWord = "";
        this.arrlistIterator = 0;
        this.scan=scan;
        this.compareLetters=false;
        this.correctLetterCounter = 0;
        this.letterInCorrectSpot = false;
        this.keyboardFeedback="";
        this.currentFeedback = "";
        this.allFeedback = "";
    }

     public String getUserInput(int roundIterator, ArrayList<String> guesses){

        this.userInputWord = useScanner().toLowerCase();
        
        this.arrlistIterator = 0;  
        if(roundIterator == 1 && this.userInputWord.length() == 5){
            guesses.add(this.userInputWord);
           // System.out.println("in first round");
        }
        while (guesses.size()>arrlistIterator && roundIterator>1){
           // System.out.println("round iterator " + roundIterator); 
           // System.out.println("arrlist iterator " + arrlistIterator);
            alreadyUsedString = guesses.get(arrlistIterator); 
            //System.out.println("already used string in getuserinput " + alreadyUsedString);
            Boolean inputIsValid = checkValidInput();
            this.arrlistIterator++;
            //System.out.println(guesses.size()); 
            if ((roundIterator - arrlistIterator == 1)){
              //  System.out.println("in if statement");
                if (inputIsValid){
                    guesses.add(this.userInputWord); 
                }
                break;}
       
        }
        return this.userInputWord; 

    }

    public Boolean checkValidInput(){
   
        while (this.userInputWord.equals(alreadyUsedString)){
            //System.out.println("already used string in checkvalid input " + alreadyUsedString);
            System.out.println("try again, must be a unique word");
            this.userInputWord = useScanner();
           
        }
        
        while (this.userInputWord.length() != 5){
            System.out.println("try again, must be 5 letters");
            this.userInputWord = useScanner();
        }
        return true;
    }

    public String useScanner(){
        this.userInputWord = this.scan.nextLine(); 
        return this.userInputWord;
    }
  


    public boolean compare_words(String generated_word, ArrayList<Character> incorrectLetters, ArrayList<String> feedback, ArrayList<String> guesses) {
       
    
        for(int charInUser=0; charInUser<this.userInputWord.length(); charInUser++){
            this.compareLetters = false;
            this.letterInCorrectSpot = false;
            this.currentFeedback = "";
            System.out.print(this.userInputWord.charAt(charInUser) + ": ");
            this.allFeedback += (this.userInputWord.charAt(charInUser)) + ": ";

            for(int charInGeneratedWord=0; charInGeneratedWord<generated_word.length(); charInGeneratedWord++){
                if((this.userInputWord.charAt(charInUser) == generated_word.charAt(charInGeneratedWord))){
                    this.compareLetters = true;
                    
                    if((charInUser == charInGeneratedWord)){
                        updateFeedback(correctLetterAndSpot, true, charInUser);
                    }
                    else if(!this.letterInCorrectSpot){
                        updateFeedback(correctLetterWrongSpot, false, charInUser);
                    }
                }
            }

            if(!compareLetters){
                falseComparison(incorrectLetters, this.userInputWord.charAt(charInUser));
            }

            System.out.print(this.currentFeedback);
           
        } 
        
        returnUserKeyboard(incorrectLetters);
        feedback.add(this.keyboardFeedback);
        WurdleBoard gameBoard = new WurdleBoard();
        gameBoard.printBoard(guesses, feedback);

        if(correctLetterCounter == 5){
            System.out.println("you are correct!");
            return true;
        }
        else{
            System.out.println("you are incorrect, try again");
            return false;
        }
    
}
    public void updateFeedback(String updateWithCorrectOrIncorrect, Boolean correct, int charInUser){
        this.allFeedback += updateWithCorrectOrIncorrect + System.lineSeparator();
        this.currentFeedback = updateWithCorrectOrIncorrect + System.lineSeparator();
        if(correct){
            this.letterInCorrectSpot = true;
            this.keyboardFeedback += Character.toString((this.userInputWord.charAt(charInUser)));
            this.correctLetterCounter ++;
        }
        else{
            this.keyboardFeedback += "-";
        }
       
    }
    public void falseComparison(ArrayList<Character> incorrectLetters, char userWordCharacter){
        incorrectLetters.add(userWordCharacter);
        this.allFeedback += incorrectLetterAndSpot + System.lineSeparator();
        
        System.out.println(incorrectLetterAndSpot);
        this.keyboardFeedback += "x";
       
    }

    

   

    public void returnUserKeyboard(ArrayList<Character> incorrectLetters){
        String alphabet = new String("qwertyuiop\nasdfghjkl\nzxcvbnm\n");
        ArrayList<Character> updatedUserKeyboard = new ArrayList<Character>();
 
        for(int i = 0; i<alphabet.length(); i++){
            updatedUserKeyboard.add(alphabet.charAt(i));
        }
   
        for (int j=0; j<incorrectLetters.size(); j++){
            for(int i=0; i<updatedUserKeyboard.size(); i++){
                if(incorrectLetters.get(j) == updatedUserKeyboard.get(i)){
                    updatedUserKeyboard.set(i,'-');
                }
            }
        }
        for (int i=0; i<updatedUserKeyboard.size(); i++){
            System.out.print(updatedUserKeyboard.get(i));
            
        
        }
        
    }

     

  }