package getFirstWord;

import java.util.ArrayList;
import java.util.Scanner;

 public class GetUserFirstWord{

    public static String userInput(int x, Scanner scanner, ArrayList<String> guesses){
        System.out.println("Please enter your guess");
        String userInputWord;
        userInputWord = scanner.nextLine().toLowerCase();
        
        int arrlistIterator = 0; 
        while (guesses.size()>arrlistIterator && x>1){
            String alreadyUsedString = guesses.get(arrlistIterator);
            while (userInputWord.equals(alreadyUsedString)){
                System.out.println("try again, must be a word you have not used already");
                userInputWord = scanner.nextLine(); 
            }
            arrlistIterator++;
        }

        while (userInputWord.length() != 5){
            System.out.println("try again, must be 5 letters");
            userInputWord = scanner.nextLine(); 
        }

        System.out.println("The user guessed: " + userInputWord); 
        guesses.add(userInputWord);
        return userInputWord; 

    }

}