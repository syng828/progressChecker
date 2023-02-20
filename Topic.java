import java.util.ArrayList;
import java.util.Scanner;

public class Topic extends Change{ 
    private ArrayList<Question> question = new ArrayList<>();

    //topic creation
    public Topic (String topicName) { 
        name = topicName; //name comes from the abstract class 
    }

    //Goes into question 
    @Override
    public void goIn(Scanner scnr) { 
        int currentQuestionLooking = -1;
        System.out.println("Enter a question name to search for: "); 
        String name = scnr.nextLine();
        for (int i = 0; i < question.size(); i++) { 
            if (question.get(i).getQuestion().equals(name)) { 
                currentQuestionLooking = i; 
                question.get(i).interact(scnr); 
            }
          }
        if (currentQuestionLooking == -1){
            System.out.println("Not found."); 
            return;
        }
    }

    //Editing arrayList of type Question
    @Override
    public void addInArrayList(Scanner scnr) {
        System.out.println("Please add a question: ");
        String addProblem = scnr.nextLine(); 
        System.out.println("Please state the correct answer: "); 
        String addAnswer = scnr.nextLine(); 
        Question newQuestion = new Question(addProblem, addAnswer); 
        question.add(newQuestion);
        System.out.println("Added.");
        
    }
    @Override
    public void printArrayList() {
        if (question.size() == 0 ) { 
            System.out.println("Nothing inside this topic."); 
        }
        else { 
        for (int i = 0; i < question.size(); i++){
            System.out.println(question.get(i).getQuestion());
            System.out.println(question.get(i).getAnswer());
        }
        }

    }
    @Override
    public void deleteInArrayList(Scanner scnr) {
        System.out.println("Please enter the question you would like to delete."); 
        String toDelete = scnr.nextLine();
        for (int i = question.size() - 1; i >= 0 ; i--) { 
            if (question.get(i).getQuestion().equals(toDelete)){
                question.remove(i); 
                System.out.print("Deleted."); 
                return; 
            }
        }
        System.out.println("Could not find."); 
    }

    //Extra methods exclusive to topic.
    //Returns all questions
    public void getQuestions () {
        if (question.size() == 0 ) { 
            System.out.println("Nothing inside this topic."); 
        }
        else { 
        for (int i = 0; i < question.size(); i++){
           System.out.println(question.get(i).getQuestion());
        }
        }
    }
    
    //Checks progress
    public void printProgress (){
        int total = question.size(); 
        int correct = 0;
        for (int i = 0; i < question.size(); i++){ 
            if (question.get(i).getCorrect()){
                correct++;
            }
        }
        if (total == 0) { 
            System.out.println("No questions inside."); 
        } 
        else { 
            System.out.println("Progress: " + ((double)correct/total * 100) + "%");
        }
    }

    //looks at the questions 
    @Override
    public void interact(Scanner scnr) {
        System.out.println("Please select what you would like to do with questions 1. Go to a question, 2. Add a question, 3. Delete a question, 4. See questions and answers, 5. See questions only, 6. Look at progress, 7. Go back, 8. Quit");
        while (scnr.hasNextLine()){
        String scan = scnr.nextLine();
            switch(scan){ 
                case "1": 
                    goIn(scnr); 
                   break; 
                case "2": 
                    addInArrayList(scnr); 
                    break;   
                case "3": 
                    deleteInArrayList(scnr);
                    break;
                case "4": 
                    printArrayList();
                    break;
                case "5": 
                    getQuestions();
                    break;
                case "6": 
                    printProgress();
                    break; 
                case "7": 
                    System.out.println("Please specify what you would like to do with the topics. 1. Go to a topic, 2. Add a topic, 3. Delete a topic, 4. See all topics, 5. Go back, 6. Quit"); 
                    return; 
                case "8": 
                    System.out.println("See you again!"); 
                    System.exit(0); 
                default: 
                    System.out.println("Please enter a valid input");
                    scan = scnr.nextLine();
                    break;
            }
           }
        
    }
    
}
