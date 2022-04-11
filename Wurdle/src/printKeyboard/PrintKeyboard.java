package printKeyboard;

import java.util.ArrayList;



public class PrintKeyboard{
    public static void returnUserKeyboard(ArrayList<Character> incorrectLetter){
        String words = new String("qwertyuiop\nasdfghjkl\nzxcvbnm\n");
        ArrayList<Character> keyboardArr = new ArrayList<Character>();
 
        for(int i = 0; i<words.length(); i++){
            keyboardArr.add(words.charAt(i));
        }
   
        for (int j=0; j<incorrectLetter.size(); j++){
            for(int i=0; i<keyboardArr.size(); i++){
                if(incorrectLetter.get(j) == keyboardArr.get(i)){
                    keyboardArr.set(i,'-');
                }
            }
        }
        for (int i=0; i<keyboardArr.size(); i++){
            System.out.print(keyboardArr.get(i));
            
        
        }
        
    }
}