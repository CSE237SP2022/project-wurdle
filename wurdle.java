//main file that runs the code
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class wurdle {
    public static void main(String[] args){

         // then get random wurdle word
        RandomWordGenerator getWord = new RandomWordGenerator();
         try {
           String generated_word = getWord.MakeRandomWordGenerator();
              } catch (FileNotFoundException e) {
    //  // TODO Auto-generated catch block
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
