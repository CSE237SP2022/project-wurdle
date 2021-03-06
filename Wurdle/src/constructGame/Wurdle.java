package constructGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import userPlay.*;



public class Wurdle {

    public Scanner scan;
    public String randomWurdleWord;
    public Boolean isUserWordCorrect;
    public ArrayList<Character> incorrectLetters;
    public ArrayList<String> guesses;
    public ArrayList<String> feedback;
    public ArrayList<String> word_list;

    public Wurdle(Scanner scan) {
        this.randomWurdleWord = "null";
        this.isUserWordCorrect = false;
        this.incorrectLetters = new ArrayList<Character>();
        this.scan = scan;
        this.feedback = new ArrayList<String>();
        this.guesses = new ArrayList<String>();
        this.word_list = new ArrayList<String>(21);
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Wurdle game = new Wurdle(scan);
        game.play();
    }

    public void play() {

        try {
            readWurdleWordsFromFile();
            chooseRandomWord();
            
            int roundIterator = 1;
            System.out.println("Welcome to Wurdle! Please enter your guesses in all lowercase :)");
            System.out.println("Each time you make a guess, your feedback will be represented in words "
                    + "explaining if the letter is correct or not as well as a visual representation on the board."+
                    "On the board, the feedback will consist of 'x' and '-' where 'x' is an incorrect letter and '-' is "
                    + "a letter that is used elsewhere in the word. If the letter is in the correct spot"
                    +" the letter will be given as feedback instead of an 'x' or '-'.");
            
            while (!isUserWordCorrect) {
                isUserWordCorrect = runNextRound(roundIterator);
                roundIterator++;
                if (roundIterator > 6 || isUserWordCorrect) {
                	didUserWin(roundIterator);
                    break;
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace(); 
        }
    }

    
    public Boolean didUserWin(int roundIterator) {
        if (roundIterator > 6 && !this.isUserWordCorrect) {
            System.out.println("Sorry, you ran out of guesses. The correct word was " + randomWurdleWord);
            return false;
        }
        if (this.isUserWordCorrect) {
            roundIterator = 10;
            System.out.println("Congrats! GAME OVER");
            return true;
        }
        return false;
    }
    

    public Boolean runNextRound(int roundIterator) {
        System.out.println("Please enter your guess");
        GamePlay userTurn = new GamePlay(scan, this.guesses, this.feedback, this.incorrectLetters);
        return userTurn.didUserGuessCorrectly(roundIterator, this.randomWurdleWord);
    }
     
    
    public void readWurdleWordsFromFile() throws FileNotFoundException{
        File inputFile = new File("src/constructGame/word_list.txt");
        if (inputFile.exists()){
        	
            Scanner fileReader = new Scanner(inputFile);
            for(int i = 0; i<16; i++){
                String nextWord = fileReader.nextLine();
                    this.word_list.add(nextWord);
            }

        fileReader.close();
    
        } 
    }

    public void chooseRandomWord(){
        double randomIndex = Math.round(Math.random() * 15);
        this.randomWurdleWord = this.word_list.get((int)randomIndex);
    }
}