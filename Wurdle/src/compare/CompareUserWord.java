package compare;
import printKeyboard.*;
import java.util.ArrayList;
public class CompareUserWord {

    public String allFeedback = " ";
    public boolean compare_words(String user_input, String generated_word) {
        boolean compareLetters;
        int correctLetterCounter = 0;
        String correctLetterAndSpot = "correct letter, correct space";
        String incorrectLetterAndSpot = "letter not used";
        String correctLetterWrongSpot = "correct letter, wrong space";
        String currentFeedback;
        boolean correctSpot;


       ArrayList<Character> incorrectLetterArr = new ArrayList<Character>();

       //multipleLetters = false;
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
                        allFeedback += correctLetterAndSpot + System.lineSeparator();
                        currentFeedback = correctLetterAndSpot + System.lineSeparator();
                        correctSpot = true;
                      
                        
                    }
                    else if(!correctSpot){
                        allFeedback += correctLetterWrongSpot + System.lineSeparator();
                        currentFeedback = correctLetterWrongSpot + System.lineSeparator();
                    }
                    
                }
                
                
            }

            if (!compareLetters){
                incorrectLetterArr.add(user_input.charAt(charInUser));
                allFeedback += incorrectLetterAndSpot + System.lineSeparator();
                System.out.println(incorrectLetterAndSpot);

            }
            System.out.print(currentFeedback);
           
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

    

  }