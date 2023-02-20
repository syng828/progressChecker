import java.util.Scanner;

public class Question { //Singular question
    private String question; 
    private String answer; 
    private boolean correct = false; 

    public Question (String question, String answer) {
        this.question = question; 
        this.answer = answer; 
    }
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(Scanner scnr) {
        System.out.println("Please enter the new answer.");
        String answer = scnr.nextLine(); 
        this.answer = answer;
        System.out.println("Answer set."); 
    }

    public boolean getCorrect() { 
        return correct;
    }
    
    //check if correct
    public void check(Scanner scnr) {
        System.out.println("Please enter your guess."); 
        String guess = scnr.nextLine(); 
        if (guess.equals(answer)) { 
            correct = true;
            System.out.println("Correct!");
        }
        else {
            correct = false;
            System.out.println("Wrong!");
        }
    }

    //Interact with question
    public void interact(Scanner scnr) { 
        System.out.println("Please select what you would like to edit in the questions. 1. Get the question, 2. Guess the answer, 3. Get the answer, 4. Set the answer, 5. Go back, 6. Quit"); 
        while (scnr.hasNextLine()){
        String scan = scnr.nextLine();
            switch(scan){  
                case "1":
                    System.out.println(question);
                    break;
                case "2": 
                    check(scnr); 
                    break; 
                case "3": 
                    System.out.println(answer);
                    break;
                case "4": 
                    setAnswer(scnr);
                    break;
                case "5": 
                    System.out.println("Please select what you would like to do with questions 1. Go to a question, 2. Add a question, 3. Delete a question, 4. See questions and answers, 5. See questions only, 6. Look at progress, 7. Go back, 8. Quit");
                    return; 
                case "6": 
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
