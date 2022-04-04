package randomWordGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import compare.*;
import getFirstWord.GetUserFirstWord;


public class RandomWordGenerator{

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

    return word;
    }
}