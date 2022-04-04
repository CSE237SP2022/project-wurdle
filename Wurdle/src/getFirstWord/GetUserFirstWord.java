package getFirstWord;
import java.util.Scanner;

 public class GetUserFirstWord{

    // use scanner to get users first word
    public String userInput(){
        //changed to the script but commented out just in case it needs to be used again 
        //System.out.println("Please type in your first guess -- all lowercase");
        Scanner scanner = new Scanner(System.in);
        String userInputWord;
        userInputWord = scanner.nextLine(); 
        scanner.close();
     //test below
        System.out.println("The user guessed: " + userInputWord); 
        return userInputWord; 
    }

}