//main file that runs the code
import randomWordGenerator.*;
import printBoard.*;
import compare.*;
import getFirstWord.GetUserFirstWord;
import java.io.FileNotFoundException;
import getNextUserGuess.getNextUserGuess;



public class main {
    public static void main(String[] args){

         // Get the Wurdle word
         
        RandomWordGenerator getWord = new RandomWordGenerator();
         try {
            getWord.MakeRandomWordGenerator();
              } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
        
        // create the wurdle word 

        PrintWordleBoard wordleBoard = new PrintWordleBoard();
        wordleBoard.board();

    }
}
