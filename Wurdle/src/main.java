//main file that runs the code
import randomWordGenerator.*;
import printBoard.*;
import compare.*;
import getFirstWord.GetUserFirstWord;
import java.io.FileNotFoundException;



public class main {
    public static void main(String[] args){

         // Get the Wurdle word
         
        RandomWordGenerator getWord = new RandomWordGenerator();
        try {
           
                String correctWord = getWord.MakeRandomWordGenerator();
                System.out.println("Random WUrdle word: " + correctWord);

                //while loop for users to guess 6 times and print board
                int x = 1;

                 while (x<=6){
                      GetUserFirstWord userInput = new GetUserFirstWord();
                      String user_input = userInput.userInput();
       
                      //compare user first word to the generated word
                      CompareUserWord c = new CompareUserWord();
                      //boolean to see if user got the word correct
                      boolean UserWordCorrect = c.compare_words(user_input, correctWord);
                      
                      

                      PrintWordleBoard wordleBoard = new PrintWordleBoard();
                      wordleBoard.board();

                      //interator 
                      x++; 

                      //User used all six guesses and they did not find the correct word 
                      //Print out the statement below
                      if(x>6 && UserWordCorrect != true){
                          System.out.println("Sorry, you ran out of guesses. The correct word was " + correctWord);
                      }
                      //User guessed the correct word, then it is time to exit the while loop 
                      if (UserWordCorrect){
                        x=10;
                      }
                     }

            

              } 
              catch (FileNotFoundException e) {
                 e.printStackTrace();
                }
        
        // create the wudle word 

        

    }
}
