package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test class for Question
 * @author Team 30
 */

class QuestionTest {
	

	@Test
	void testQuestion() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "What is the value of x? int x = (3 + 4) * 27111424PEMDAS3";
		String actual = q.getQuestion()+ q.getAnswer1() + q.getAnswer2() + q.getAnswer3() +  q.getAnswer4() + q.getHint() + q.getCorrectAnswer();
		assertEquals(expected, actual);
		
	}

	@Test
	void testGetCorrectAnswer() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		int expected = 3;
		int actual = q.getCorrectAnswer();
		assertEquals(expected, actual);
	}

	@Test
	void testGetQuestion() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "What is the value of x? int x = (3 + 4) * 2";
		String actual = q.getQuestion();
		assertEquals(expected, actual);

	}

	@Test
	void testGetAnswer1() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "7";
		String actual = q.getAnswer1();
		assertEquals(expected, actual);
	}

	@Test
	void testSetAnswer1() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "testAnswer1", "11", "14", "24", "PEMDAS", 3);
		String expected = "testAnswer1";
		String actual = q.getAnswer1();
		assertEquals(expected, actual);
	}
	

	@Test
	void testGetAnswer2() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "11";
		String actual = q.getAnswer2();
		assertEquals(expected, actual);
	}

	@Test
	void testSetAnswer2() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "testAnswer2", "14", "24", "PEMDAS", 3);
		String expected = "testAnswer2";
		String actual = q.getAnswer2();
		assertEquals(expected, actual);
	}

	@Test
	void testGetAnswer3() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "14";
		String actual = q.getAnswer3();
		assertEquals(expected, actual);
	}

	@Test
	void testSetAnswer3() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "testAnswer3", "24", "PEMDAS", 3);
		String expected = "testAnswer3";
		String actual = q.getAnswer3();
		assertEquals(expected, actual);
	}

	@Test
	void testGetHint() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "PEMDAS", 3);
		String expected = "PEMDAS";
		String actual = q.getHint();
		assertEquals(expected, actual);
	}

	@Test
	void testSetHint() {
		Question q = new Question("What is the value of x? int x = (3 + 4) * 2", "7", "11", "14", "24", "testHint", 3);
		String expected = "testHint";
		String actual = q.getHint();
		assertEquals(expected, actual);
	}

}
