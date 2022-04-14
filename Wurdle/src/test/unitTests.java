//unit tests here

package test;

import randomWordGenerator.*;
import printBoard.*;
import compare.*;
import printKeyboard.*;
import getFirstWord.GetUserFirstWord;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.Test;

public class unitTests {
    
    @Test
    public void user_right_test() {

        String user_word = "bears";
        String generated_word = "bears";
        CompareUserWord compare = new CompareUserWord();
        boolean user_right = compare.compare_words(user_word, generated_word);
        assertEquals(user_right, true);

    }

    @Test
    void user_wrong_test() {

        String user_word = "bears";
        String generated_word = "bytes";
        CompareUserWord compare = new CompareUserWord();
        boolean user_wrong = compare.compare_words(user_word, generated_word);
        assertEquals(user_wrong, true);

    }

    @Test
    void feedback_test() {

        String user_word = "bears";
        String generated_word = "bytes";
        CompareUserWord compare = new CompareUserWord();
        boolean user_wrong = compare.compare_words(user_word, generated_word);
        String feedback = compare.allFeedback;
        String correct_feedback = "b: correct letter, correct space\ne: correct letter, wrong space\na: letter not used\nr: letter not used\ns: correct letter, correct space";
        assertEquals(user_wrong,correct_feedback);

    }



}
