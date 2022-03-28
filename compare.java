
public class compare {
    //public static void main(String[] args) {
      //  compare c = new compare();
        //var user_input = "hello";
        //var generated_word = "hello";
        //System.out.print(c.compare_words(user_input, generated_word));
    
    //}


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