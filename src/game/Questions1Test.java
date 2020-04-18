package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Questions1Test {



	void testGetCurrentQuestion() {//testing method as is
		Questions1 q1 = new Questions1();
		Question expected = q1.getCurrentQuestion();
		Question actual = q1.getCurrentQuestion();
		assertNotSame(expected, actual);
	}
	
	
	@Test
	void testShuffleQuestions() {//testing shuffled questions three at a time. Testing the bounds of randomness!
		Questions1 q1 = new Questions1();
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
		Questions1 q1 = new Questions1();
		String expected =  "What is the value of x? int x = (3 + 4) * 2";
		String actual = q1.getCurrentQuestion().getQuestion();
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void testGetHint() {
		Questions1 q1 = new Questions1();
		String expected =  "PEMDAS";
		String actual = q1.getCurrentQuestion().getHint();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer1() {
		Questions1 q1 = new Questions1();
		String expected =  "7";
		String actual = q1.getCurrentQuestion().getAnswer1();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer2() {
		Questions1 q1 = new Questions1();
		String expected =  "11";
		String actual = q1.getCurrentQuestion().getAnswer2();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer3() {
		Questions1 q1 = new Questions1();
		String expected =  "14";
		String actual = q1.getCurrentQuestion().getAnswer3();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetAnswer4() {
		Questions1 q1 = new Questions1();
		String expected =  "24";
		String actual = q1.getCurrentQuestion().getAnswer4();
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCorrectAnswer() {
		Questions1 q1 = new Questions1();
		int expected =  3;
		int actual = q1.getCurrentQuestion().getCorrectAnswer();
		assertEquals(expected, actual);
		
	}
	

	


}
