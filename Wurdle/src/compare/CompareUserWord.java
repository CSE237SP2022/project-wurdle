package compare;

public class CompareUserWord {

    public boolean compare_words(String user_input, String generated_word) {
        boolean compareLetters;
        int correctLetterCounter = 0;
        for(int charInUser=0; charInUser<user_input.length(); charInUser++){
            compareLetters = false;

            System.out.print(user_input.charAt(charInUser) + ": ");

            for(int charInGeneratedWord=0; charInGeneratedWord<generated_word.length(); charInGeneratedWord++){
                
                if(user_input.charAt(charInUser) == generated_word.charAt(charInGeneratedWord)){
                    compareLetters = true;

                    if(charInUser == charInGeneratedWord){
                        ++correctLetterCounter;
                        System.out.println("correct letter, correct space");
                    }
                    else{
                        System.out.println("correct letter, wrong spot");
                    }
                }
            }

            if (!compareLetters){
             System.out.println("letter not used");
            }
           
        } 
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