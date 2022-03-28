import java.util.Scanner;

 public class getUserFirstWord{
      //   public static void main(String[] args){
      //   getUserFirstWord userInput = new getUserFirstWord();
        // userInput.userInput();
    // }
    // use args processor to get users first word
    public String userInput(){
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