package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test class for Question
 * @author Team 30
 */

class QuestionTest {
	
	Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);

	/*
	 * The following tests check the getters for the Question Class
	 */

	@Test
	void testQuestion() {
		String expected = "What is the value of x? int x = (3 + 4) * 27111424PEMDAS3";
		String actual = q.getQuestion()+ q.getAnswer1() + q.getAnswer2() + q.getAnswer3() +  q.getAnswer4() + q.getHint() + q.getCorrectAnswer();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCorrectAnswer() {
		int expected = 3;
		int actual = q.getCorrectAnswer();
		assertEquals(expected, actual);
	}

	@Test
	void testGetQuestion() {
		String expected = "What is the value of x? int x = (3 + 4) * 2";
		String actual = q.getQuestion();
		assertEquals(expected, actual);
	}

	@Test
	void testGetAnswer1() {
		String expected = "7";
		String actual = q.getAnswer1();
		assertEquals(expected, actual);
	}

	@Test
	void testGetAnswer2() {
		String expected = "11";
		String actual = q.getAnswer2();
		assertEquals(expected, actual);
	}

	@Test
	void testGetAnswer3() {
		String expected = "14";
		String actual = q.getAnswer3();
		assertEquals(expected, actual);
	}


	@Test
	void testGetAnswer4() {
		String expected = "24";
		String actual = q.getAnswer4();
		assertEquals(expected, actual);
	}

	@Test
	void testGetHint() {
		String expected = "PEMDAS";
		String actual = q.getHint();
		assertEquals(expected, actual);
	}

}
