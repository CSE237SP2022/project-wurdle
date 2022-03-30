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
	

	//will add more when we can. these will including test words and the way the board prints if it is correct or not

}
