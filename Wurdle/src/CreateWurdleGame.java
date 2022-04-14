import randomWordGenerator.*;
import compare.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import getFirstWord.GetUserFirstWord;

public class CreateWurdleGame {

    public Scanner scan;
    public String correctWord;
    public Boolean userWordCorrect;
    public ArrayList<Character> incorrectLetterArr;
    public ArrayList<String> guesses;
    public ArrayList<String> feedback;

    public CreateWurdleGame(Scanner scan){
        this.correctWord = "";
        this.userWordCorrect = false;
        this.incorrectLetterArr = new ArrayList<Character>();
        this.scan = scan;
        this.feedback = new ArrayList<String>();
        this.guesses = new ArrayList<String>();
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        CreateWurdleGame game = new CreateWurdleGame(scan);
        game.play();
    }
    public  void play(){
        RandomWordGenerator getWord = new RandomWordGenerator();
        try {
                 this.correctWord = getWord.MakeRandomWordGenerator();
                System.out.println("Random WUrdle word: " + this.correctWord);

                int roundIterator = 1;
                System.out.println("Welcome to Wurdle! Please enter your guesses in all lowercase :)");

                while (!userWordCorrect){
                    userWordCorrect = updateRound(roundIterator);
                    roundIterator++;
                    if (roundIterator>6 || userWordCorrect){
                    gameOver(roundIterator);
                    break;
                    }
                }
             }
            

        catch (FileNotFoundException e) {
                 e.printStackTrace();
                }
    }


    public void gameOver(int roundIterator){

        if(roundIterator>6 && userWordCorrect != true){
        System.out.println("Sorry, you ran out of guesses. The correct word was " + correctWord);
        }
        if (userWordCorrect){
        roundIterator=10;
        System.out.println("Congrats! GAME OVER");
        }

    }

    public boolean updateRound(int roundIterator){
        String user_input = GetUserFirstWord.userInput(roundIterator, scan, guesses);
        boolean userWordCorrect = CompareUserWord.compare_words(user_input, this.correctWord, this.incorrectLetterArr, this.feedback, this.guesses);

        return userWordCorrect; 
    }
}