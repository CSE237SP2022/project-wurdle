
package printBoard;

public class PrintWordleBoard{

    public void board(){
        for(int topLineDashes = 0; topLineDashes<6; topLineDashes++){
            System.out.print(" _");

        }
        System.out.println();


        for(int numGuessesAllowed = 0; numGuessesAllowed<5; numGuessesAllowed++){
            
            System.out.print("|"); //first lefthand vertical bar
            for (int emptySpotsTop = 0; emptySpotsTop<5; emptySpotsTop++){
               
                System.out.print("  "); //empty spaces
                
            }
            System.out.println(" |"); //first right hand vertical bar

            System.out.print("|"); //second lefthand vertical bar
            for (int emptySpotsGuesses = 0; emptySpotsGuesses<5; emptySpotsGuesses++){
                
                System.out.print("  "); //empty spaces REPLACE THESE WITH LETTER GUESSES
                
            }
            System.out.println(" |"); //second right hand vertical bar

            for (int separatorLines = 0; separatorLines<5; separatorLines++){
               if (separatorLines == 0){
                   System.out.print("| _"); //third lefthand vertical bar
               }
               else{
                System.out.print(" _"); //bottom spots 
               }
            }
         
            System.out.println(" |"); //third righthand vertical bar
        }
    }


}