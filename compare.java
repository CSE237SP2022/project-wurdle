
public class compare {
    public static void main(String[] args) {
        compare c = new compare();
        var user_input = "hello";
        var generated_word = "hello";
        System.out.print(c.compare_words(user_input, generated_word));
    
    }


    public boolean compare_words(String user_input, String generated_word) {
        if(user_input.equals(generated_word)){
            return true;
        } else {
            return false;
        }
            
    }
    

  }