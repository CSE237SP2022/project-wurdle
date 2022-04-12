//main file that runs the code
import randomWordGenerator.*;
import printKeyboard.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;



public class main {
    public static void main(String[] args){

         // Get the Wurdle word
        RandomWordGenerator getWord = new RandomWordGenerator();
        try {
                String correctWord = getWord.MakeRandomWordGenerator();

                //For testing prints out the correct wurdle word
                System.out.println("Random WUrdle word: " + correctWord);

                //interator
                int x = 1;
                System.out.println("Welcome to Wurdle! Please enter your guesses in all lowercase :)");
                //Create boolean to see if use guesses correctly
                Boolean UserWordCorrect = false; 
                //While loop for the guess (goes for 6 times)

                while (UserWordCorrect == false){
                    UserWordCorrect = round(x, correctWord);
                    x++;
                    gameOver(x, UserWordCorrect, correctWord);

                }

             }
                

        catch (FileNotFoundException e) {
                 e.printStackTrace();
                }
        

    }

    public static boolean round(int x, String correctWord){
        //Gets user input
        String user_input = userInput(x);
        //compare user first word to the generated word
        //boolean to see if user got the word correct
        boolean UserWordCorrect = compare_words(user_input, correctWord);
        //create board
        board();
        //return to while loop if the user guessed correctly 
        return UserWordCorrect; 
    }

    public static void gameOver(int x, boolean UserWordCorrect, String correctWord){
        //Method to see if game should be ended 
        //If they ran out of guesses
        if(x>6 && UserWordCorrect != true){
         System.out.println("Sorry, you ran out of guesses. The correct word was " + correctWord);
        }
        //User guessed the correct word, then it is time to exit the while loop 
        if (UserWordCorrect){
        x=10;
        System.out.println("Congrats! GAME OVER");
        }
  
    }
    public static String userInput(int x){
        System.out.println("Please enter your guess");
        //create scanner for user input
        Scanner scanner = new Scanner(System.in);
        String userInputWord;
        userInputWord = scanner.nextLine(); 
        //test below to show what the user guessed 
        System.out.println("The user guessed: " + userInputWord); 
        return userInputWord; 
    }

    public static boolean compare_words(String user_input, String generated_word) {
        boolean compareLetters;
        int correctLetterCounter = 0;

        ArrayList<Character> incorrectLetterArr = new ArrayList<Character>();

    
        for(int charInUser=0; charInUser<user_input.length(); charInUser++){
            compareLetters = false;

            System.out.print(user_input.charAt(charInUser) + ": ");

            for(int charInGeneratedWord=0; charInGeneratedWord<generated_word.length(); charInGeneratedWord++){
                
                if(user_input.charAt(charInUser) == generated_word.charAt(charInGeneratedWord)){
                    compareLetters = true;

                    if(charInUser == charInGeneratedWord){
                        ++correctLetterCounter;
                        System.out.println("correct letter, correct space");
                    }
                    else{
                        System.out.println("correct letter, wrong spot");
                    }
                }
            }

            if (!compareLetters){
                incorrectLetterArr.add(user_input.charAt(charInUser));
                
                System.out.println("letter not used");

            }
           
        } 
        PrintKeyboard.returnUserKeyboard(incorrectLetterArr);
        if(correctLetterCounter == 5){
            System.out.println("you are correct!");
            return true;
        }
        else{
            System.out.println("you are incorrect, try again");
            return false;
        }
    }

    public static void returnUserKeyboard(ArrayList<Character> incorrectLetter){
        String words = new String("qwertyuiop\nasdfghjkl\nzxcvbnm\n");
        ArrayList<Character> keyboardArr = new ArrayList<Character>();
 
        for(int i = 0; i<words.length(); i++){
            keyboardArr.add(words.charAt(i));
        }
   
        for (int j=0; j<incorrectLetter.size(); j++){
            for(int i=0; i<keyboardArr.size(); i++){
                if(incorrectLetter.get(j) == keyboardArr.get(i)){
                    keyboardArr.set(i,'-');
                }
            }
        }
        for (int i=0; i<keyboardArr.size(); i++){
            System.out.print(keyboardArr.get(i));
            
        
        }
        
    }

    public static void board(){
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
