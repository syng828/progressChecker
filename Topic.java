import java.util.ArrayList;
import java.util.Scanner;

public class Topic { //A singular topic 
    private String topicName; 
    private ArrayList<Question> question = new ArrayList<>();

    public Topic (String topicName) { 
        this.topicName = topicName; 
    }
    public String getTopicName() { 
        return topicName;
    }
    //getters and setters 
    public void getQuestions (ArrayList<Question> q) {
        for (int i = 0; i < q.size(); i++){
            System.out.println(q.get(i).getQuestion());
        }
    }
    public void addQuestion(Scanner scnr) {
        System.out.println("Please add a question: ");
        String addProblem = scnr.nextLine(); 
        System.out.println("Please state the correct answer: "); 
        String addAnswer = scnr.nextLine(); 
        Question newQuestion = new Question(addProblem, addAnswer); 
        question.add(newQuestion);
    }
    
    //see progress
    public void printProgress (){
        int total = question.size(); 
        int correct = 0;
        int progress;
        for (int i = 0; i > question.size(); i++){ 
            if (question.get(i).getCorrect()){
                correct++;
            }
        }
        System.out.println("Progress: " + ((double)correct/total));
    }

    
}
