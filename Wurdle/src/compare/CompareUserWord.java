package compare;
import printKeyboard.*;
import java.util.ArrayList;
import printBoard.*;

public class CompareUserWord {
   
    static String correctLetterAndSpot = "correct letter, correct space";
    static String incorrectLetterAndSpot = "letter not used";
    static String correctLetterWrongSpot = "correct letter, wrong space";
    static String allFeedback = " ";
    static String currentFeedback = "";



    public static boolean compare_words(String user_input, String generated_word, ArrayList<Character> incorrectLetterArr, ArrayList<String> feedback, ArrayList<String> guesses) {
       
      
        boolean compareLetters=false;
        int correctLetterCounter = 0;
        boolean correctSpot;
        String keyboardFeedback="";
     

        for(int charInUser=0; charInUser<user_input.length(); charInUser++){
            compareLetters = false;
            correctSpot = false;
            currentFeedback = "";
            System.out.print(user_input.charAt(charInUser) + ": ");
            allFeedback += (user_input.charAt(charInUser)) + ": ";

            for(int charInGeneratedWord=0; charInGeneratedWord<generated_word.length(); charInGeneratedWord++){
                if((user_input.charAt(charInUser) == generated_word.charAt(charInGeneratedWord))){
                    compareLetters = true;
                    
                    if((charInUser == charInGeneratedWord)){
                        ++correctLetterCounter;
                        updateFeedback(correctLetterAndSpot, true);
                        correctSpot = true;
     
                        keyboardFeedback += Character.toString((user_input.charAt(charInUser)));
                        
                    }
                    else if(!correctSpot){
                        updateFeedback(correctLetterWrongSpot, false);

                        keyboardFeedback += "-";
                    }
                }
            }

            if(!compareLetters){
                falseComparison(incorrectLetterArr, user_input.charAt(charInUser));
                keyboardFeedback += "x";
            }

            System.out.print(currentFeedback);
           
        } 
        PrintKeyboard.returnUserKeyboard(incorrectLetterArr);
        feedback.add(keyboardFeedback);
        PrintWordleBoard.board(guesses, feedback);
        if(correctLetterCounter == 5){
            System.out.println("you are correct!");
            return true;
        }
        else{
            System.out.println("you are incorrect, try again");
            return false;
        }
    
}
    public static void updateFeedback(String updateWithCorrectOrIncorrect, Boolean correct){
        allFeedback += updateWithCorrectOrIncorrect + System.lineSeparator();
        currentFeedback = updateWithCorrectOrIncorrect + System.lineSeparator();
       
    }
    public static void falseComparison(ArrayList<Character> incorrectLetterArr, char userWordCharacter){
        incorrectLetterArr.add(userWordCharacter);
        allFeedback += incorrectLetterAndSpot + System.lineSeparator();
        System.out.println(incorrectLetterAndSpot);
       
    }

    

  }