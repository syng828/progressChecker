

public class Question { //Singular question
    private String question; 
    private String answer; 
    private String guess; 
    private boolean correct; 

    public Question (String question, String answer) {
        this.question = question; 
        this.answer = answer; 
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getCorrect() { 
        return correct;
    }
    
    //check if correct
    public void check(String guess) {
        if (guess.equals(answer)) { 
            correct = true; 
        }
        else {
            correct = false;
        }
    }
}
