
package printBoard;

import java.util.ArrayList;

public class PrintWordleBoard {

    public static void board(ArrayList<String> guesses, ArrayList<String> feedback){

        String spaces = "     ";
        printTop();

        for(int numGuessesAllowed = 0; numGuessesAllowed<6; numGuessesAllowed++){
            emptySpaceLetterGuesses(spaces);

            if(numGuessesAllowed<guesses.size()&&numGuessesAllowed<feedback.size()){
                emptySpaceLetterGuesses(guesses.get(numGuessesAllowed));
                emptySpaceLetterGuesses(feedback.get(numGuessesAllowed));
            }
            else{
                emptySpaceLetterGuesses(spaces);
                emptySpaceLetterGuesses(spaces);
            }
    
           
            bottomBorder();
            verticalBars(true);
        }
    }


    public static void verticalBars(Boolean spacing){
        if(!spacing){
            System.out.print("|");
        }
        else{
            System.out.println(" |");
        }
    }
    public static void emptySpaceLetterGuesses(String boardFiller){
        verticalBars(false);
        for (int emptySpotsGuesses = 0; emptySpotsGuesses<5; emptySpotsGuesses++){
            System.out.print(" "+ boardFiller.charAt(emptySpotsGuesses)); //empty spaces REPLACE THESE WITH LETTER GUESSES
 
        }
        verticalBars(true);
      
    }
    public static void printTop(){
        for(int topLineDashes = 0; topLineDashes<6; topLineDashes++){
            System.out.print(" _");

        }
        System.out.println();
    }

    public static void bottomBorder(){
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