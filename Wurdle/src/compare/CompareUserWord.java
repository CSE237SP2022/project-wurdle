package compare;

public class CompareUserWord {

    public boolean compare_words(String user_input, String generated_word) {
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