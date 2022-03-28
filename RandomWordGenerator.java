import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RandomWordGenerator{
  //  public static void main(String[] args){
       // RandomWordGenerator getWord = new RandomWordGenerator();
       // try {
      //      getWord.MakeRandomWordGenerator();
       // } catch (FileNotFoundException e) {
      //      // TODO Auto-generated catch block
      //      e.printStackTrace();
     //   }
  //  }

    public String MakeRandomWordGenerator() throws FileNotFoundException{
        String word = "null";
         List<String> word_list = new ArrayList<String>(21);
       
         // load data from file
        File inputFile = new File("word_list.txt");
        
        if (inputFile.exists()){
    
        Scanner fileReader = new Scanner(inputFile);
        for(int i = 0; i<21; i++){
            String line = fileReader.nextLine();
                word_list.add(line);
            
           
        }
        fileReader.close();
        double newIndex = Math.round(Math.random() * 21);
    
        word = word_list.get((int)newIndex);


    } 
    System.out.println("Random WUrdle word: " + word); 
    getUserFirstWord userInput = new getUserFirstWord();
    String user_input = userInput.userInput();
    compare c = new compare();
        //var user_input = "hello";
        //var generated_word = "hello";
       c.compare_words(user_input, word);


    return word;
    }
}