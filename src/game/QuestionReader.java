package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read in Question file
 * 
 * @author Team 30
 *
 */
public class QuestionReader {

	/**
	 * Reads in Java Questions from jquestions2.csv to be answered during game play
	 * 
	 * @return ArrayList of Questions/Answers/Hints
	 */
	public static ArrayList<Question> readCSVFile() {
		ArrayList<Question> questions = new ArrayList<Question>();
		File questionsFile = new File("jquestions2.csv");

		try {
			Scanner fileReader = new Scanner(questionsFile);
			fileReader.nextLine(); // skip title row

			while (fileReader.hasNextLine()) {

				String line = fileReader.nextLine();
				String[] lineComponents = line.split(",");
				String question = lineComponents[0];
				String answer1 = lineComponents[1];
				String answer2 = lineComponents[2];
				String answer3 = lineComponents[3];
				String answer4 = lineComponents[4];
				String hint = lineComponents[5];
				int correctAnswer = -1;
				try {
					correctAnswer = Integer.parseInt(lineComponents[6]);
				} catch (NumberFormatException e) {
					System.out.println("Bad input for correctAnswer <" + lineComponents[6] + ">");
					System.exit(0);
				}
				// Create the Question object and add it to the ArrayList
				Question questionAndAnswer = new Question(question, answer1, answer2, answer3, answer4, hint,
						correctAnswer);
				questions.add(questionAndAnswer);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0); // If the file is not found, exit the game
		}
		return questions;
	}
}
