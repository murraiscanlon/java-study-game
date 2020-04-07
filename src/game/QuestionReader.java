package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class to read in Question file
 *   
 * @author Team 30
 *
 */
public class QuestionReader {
	
	//instance variables
	static ArrayList<Question> questions = new ArrayList<Question>();
	
	
    /**
     * Reads in Java Questions to be answered during game play 
     * @return ArrayList of Questions/Answers/Hints
     */
    public static ArrayList<Question> readCSVFile(){
        
        File questionsFile = new File("jquestions0.csv");
        
        try {
            Scanner fileReader = new Scanner(questionsFile);
            fileReader.nextLine(); // skip title row
            
            while (fileReader.hasNextLine()) {
                
                String line = fileReader.nextLine();
                String[] lineComponents = line.split(",");//may need to add parameters 
                String question = lineComponents[0];
                String answer1 = lineComponents[1];
                String answer2 = lineComponents[2];
                String answer3 = lineComponents[3];
                String hint = lineComponents[4];
                String correctAnswer = lineComponents[5];
                //check file for parseInt issues
                //add another try/catch block if needed
                                
                Question questionAndAnswer = new Question(question, answer1, answer2, answer3, hint, correctAnswer);
                questions.add(questionAndAnswer);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
        return questions;
    }
    
    //main method for testing purposes only
    public static void main(String[] args) {
    	

    	
    	
    	
    	
    }

}