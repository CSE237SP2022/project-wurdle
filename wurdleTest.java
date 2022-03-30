import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class wurdleTest {

	@Test
	void testCompareSameWord() {
		String user_input = "tulip";
		String generated_word = "tulip";
		compare c = new compare();
		c.compare_words(user_input, generated_word);
		
	}
	
	@Test
	void testCompareDiffWord() {
		String user_input = "tulip";
		String generated_word = "wusas";
		compare c = new compare();
		c.compare_words(user_input, generated_word);
		
	}
	//not created yet as this is part of iteration 2!
	
	//test board printing out correctly after each letter
	//test correct letter in wrong space
	//test correct letter in right space
	//test completley incorrect letter
	//test number of guesses alllowed
	//test number of letters input
	

}
