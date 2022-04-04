package compare;

public class CompareUserWord {

    public boolean compare_words(String user_input, String generated_word) {
        for(int charInString=0; charInString<user_input.length(); charInString++){
            if(user_input.charAt(charInString) == generated_word.charAt(charInString)){
                System.out.println(user_input.charAt(charInString));
            }
            for(int index=0; index<generated_word.length(); index++){
                
            if(user_input.charAt(charInString) == generated_word.charAt(index)){
                System.out.println(charInString);

            }
            }
        }
        boolean check; 
        if(user_input.equals(generated_word)){
            check = true;
            System.out.println(check); 
            return true;
        } else {
            check = false; 
            System.out.println(check); 
            return false;
        }
    }
    

  }