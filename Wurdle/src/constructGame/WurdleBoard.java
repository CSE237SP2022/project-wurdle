package constructGame;

import java.util.ArrayList;

public class WurdleBoard {
    public void printBoard(ArrayList<String> guesses, ArrayList<String> feedback){
        System.out.println(feedback);
        System.out.println(guesses);
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


    public void printVerticalBars(Boolean spacing){
        if(!spacing){
            System.out.print("|");
        }
        else{
            System.out.println(" |");
        }
    }
    public void printGuessesAndFeedback(String boardFiller){
        printVerticalBars(false);
        for (int emptySpotsGuesses = 0; emptySpotsGuesses<5; emptySpotsGuesses++){
            System.out.print(" "+ boardFiller.charAt(emptySpotsGuesses)); //empty spaces REPLACE THESE WITH LETTER GUESSES

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
}
