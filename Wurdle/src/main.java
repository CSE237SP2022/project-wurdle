//main file that runs the code//main file that runs the code
import randomWordGenerator.*;
import printBoard.*;
import compare.*;
import getFirstWord.GetUserFirstWord;
import java.io.FileNotFoundException;



public class main {
    public static void main(String[] args){

         // then get random wurdle word
         
        RandomWordGenerator getWord = new RandomWordGenerator();
         try {
             
           getWord.MakeRandomWordGenerator();
              } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
        // get user input 

       // getUserFirstWord userInput = new getUserFirstWord();
        
       // String user_input = userInput.userInput();

        //compare board
        //compare c = new compare(user_input, generated_word);
       // compare c = new compare();
       // c.compare_words(user_input, generated_word);

        //start off with printing the board
        PrintWordleBoard wordleBoard = new PrintWordleBoard();
        wordleBoard.board();

    }
}
