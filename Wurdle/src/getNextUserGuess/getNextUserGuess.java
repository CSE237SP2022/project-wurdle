package getNextUserGuess;
import java.util.Scanner;

public class getNextUserGuess {
    // get user next guess

    public String userInput2(){
    
     Scanner scanner = new Scanner(System.in);
     String userInputWord2; 

     //prints to terminal to prompt user to input second guess
     System.out.println("Please input your second guess");

     //stores the words by user into variable userInputWord2
     userInputWord2 = scanner.nextLine();
     // close the scanner
     scanner.close();

     return userInputWord2; 
    }
    
   
}
