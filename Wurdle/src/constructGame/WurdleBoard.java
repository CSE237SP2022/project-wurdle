package constructGame;

import java.util.ArrayList;

public class WurdleBoard {
	
    public void printBoard(ArrayList<String> guesses, ArrayList<String> feedback){
        String spaces = "     ";
        printTop();

        for(int numGuessesAllowed = 0; numGuessesAllowed<6; numGuessesAllowed++){
            printGuessesAndFeedback(spaces);

            if(numGuessesAllowed<guesses.size()&&numGuessesAllowed<feedback.size()){
                printGuessesAndFeedback(guesses.get(numGuessesAllowed));
                printGuessesAndFeedback(feedback.get(numGuessesAllowed));
            }
            else{
                printGuessesAndFeedback(spaces);
                printGuessesAndFeedback(spaces);
            } 

            printBottom();
            printVerticalBars(true);
        }
    }


    public void printVerticalBars(Boolean needsSpacing){
        if(!needsSpacing){
            System.out.print("|");
        }
        else{
            System.out.println(" |");
        }
    }
    
    
    public void printGuessesAndFeedback(String boardContents){
        printVerticalBars(false);
        for (int emptySpotsGuesses = 0; emptySpotsGuesses<5; emptySpotsGuesses++){
            System.out.print(" "+ boardContents.charAt(emptySpotsGuesses)); 

        }
        printVerticalBars(true);
    
    }
    
    
    public void printTop(){
        for(int topLineDashes = 0; topLineDashes<6; topLineDashes++){
            System.out.print(" _");

        }
        System.out.println();
    }

    public void printBottom(){
        for (int separatorLines = 0; separatorLines<5; separatorLines++){
            if (separatorLines == 0){
                System.out.print("| _"); 
            }
            else{
            System.out.print(" _"); 
            }
        }
    } 
    
    
    public void updateUserKeyboard(ArrayList<Character> incorrectLetters){
        String alphabet = new String("qwertyuiop\nasdfghjkl\nzxcvbnm\n");
        ArrayList<Character> updatedUserKeyboard = new ArrayList<Character>();

        System.out.println("Letters remaining are: ");
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
        System.out.println("");
        
    }
}
