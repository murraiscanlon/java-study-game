package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionsTest {

	// Test to confirm that getCurrentQuestion increments the question index
	// Expected and actual should NOT be the same object
	@Test
	void testGetCurrentQuestion() {//testing method as is
		Questions q1 = new Questions();
		Question expected = q1.getCurrentQuestion();
		Question actual = q1.getCurrentQuestion();
		assertNotSame(expected, actual);
	}
	
	// Test basic shuffling of 3 questions - do not expect three questions to be in their original order
	// Note that it is possible that the questions show up in the correct order
	@Test
	void testShuffleQuestions() {//testing shuffled questions three at a time. Testing the bounds of randomness!
		Questions q1 = new Questions();
		q1.shuffleQuestions();
		String[] qs = new String[3];
		
		String match = null;
		String noMatch = null;
		String actual = null;
		
		for (int i = 0; i < 3; i++ ) {
			q1.getQuestionCounter();
			qs[i] = q1.getCurrentQuestion().getQuestion();
			//System.out.println(qs[i]);
			}
		
		if (qs[0].equals(qs[1]) && qs[1].equals(qs[2])) {
			match = "All three random questions match";
			actual = match;		
		} else {
			noMatch = "Atleast two of the random questions do not match";
			actual = noMatch;
		}
		//System.out.println(actual);
		assertEquals(noMatch, actual);
	}
	
	@Test
	void testGetQuestion() {//testing each question object below this point
		Questions q1 = new Questions();
		String expected =  "What is the value of x? int x = (3 + 4) * 2";
		String actual = q1.getCurrentQuestion().getQuestion();
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void testGetHint() {
		Questions q1 = new Questions();
		String expected =  "PEMDAS";
		String actual = q1.getCurrentQuestion().getHint();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer1() {
		Questions q1 = new Questions();
		String expected =  "7";
		String actual = q1.getCurrentQuestion().getAnswer1();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer2() {
		Questions q1 = new Questions();
		String expected =  "11";
		String actual = q1.getCurrentQuestion().getAnswer2();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer3() {
		Questions q1 = new Questions();
		String expected =  "14";
		String actual = q1.getCurrentQuestion().getAnswer3();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer4() {
		Questions q1 = new Questions();
		String expected =  "24";
		String actual = q1.getCurrentQuestion().getAnswer4();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCorrectAnswer() {
		Questions q1 = new Questions();
		int expected =  3;
		int actual = q1.getCurrentQuestion().getCorrectAnswer();
		assertEquals(expected, actual);
		
	}
	

	


}
