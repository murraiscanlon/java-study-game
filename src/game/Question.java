package game;

public class Question {
    /**
     * Contains the question and multiple choice answers 
     * Player must correctly answer to retrieve Treasures
     * Fairy GodTA will provide hints on request
     * @author Team 30
     */
    
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String correctAnswer;
    private String hint;
    
    /**
     * Constructor
     * @param question
     * @param answer1
     * @param answer2
     * @param answer3
     * @param hint
     */
    public Question (String question, String answer1, String answer2,
                     String answer3, String hint, String correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
    }

     public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
     * Getters and Setters
     * @return
     */
    
    public String getQuestion() {
        return question;
    }


    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
    
    @Override
    public String toString() {
    	return "Question [question= " + question + "answer1= " + answer1 + " answer2= " + answer2 + 
    			" answer3= " + answer3 + "correctAnswer= " + correctAnswer + " hint= " + hint + "]";
    	
       // return "Treasure [treasureType=" + treasureType + ", points=" + points + ", roomName=" + roomName + "]";
    }
    

}