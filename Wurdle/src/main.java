//main file that runs the code
import randomWordGenerator.*;
import printBoard.*;
import compare.*;
import printKeyboard.*;
import getFirstWord.GetUserFirstWord;
import java.io.FileNotFoundException;



public class main {
    public static void main(String[] args){

         // Get the Wurdle word
       
        RandomWordGenerator getWord = new RandomWordGenerator();
        try {
           String correctWord = getWord.MakeRandomWordGenerator();
           System.out.println("Random WUrdle word: " + correctWord);
           GetUserFirstWord userInput = new GetUserFirstWord();
           String user_input = userInput.userInput();
       
           //compare user first word to the generated word
           CompareUserWord c = new CompareUserWord();
       
           c.compare_words(user_input, correctWord);
              } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
        
        // create the wudle word 

        PrintWordleBoard wordleBoard = new PrintWordleBoard();
        wordleBoard.board();

    }
}
