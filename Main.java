import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void lookAtTasks(Scanner scnr, ArrayList<Task>home){
        String scan = scnr.nextLine(); 
        while (!(scan.equals("q"))) { 
            int currentTaskLooking = -1; 
            switch(scan){      //@FIXME: Add all the case statements for tasks first, and test to see if they work. 
                case "1": 
                    System.out.println("Enter a task name: "); 
                    String name = scnr.nextLine();
                    for (int i = 0; i < home.size(); i++) { 
                        if (home.get(i).getTaskName().equals(name)) { 
                            currentTaskLooking = i;
                        }
                      }
                    if (currentTaskLooking == -1){
                        System.out.println("Not found."); 
                    }                  
                case "2": 
                case "3": 
                case "q": 
                default: 
                    System.out.println("Please enter a valid input");
                    scan = scnr.nextLine(); 
            }
        }

    }
    public static void main( String[]args) {
        Scanner scnr = new Scanner(System.in);  
        System.out.print("This can track your progress. You can modify all tasks, topics, and questions if you like."); 
        System.out.println("First please choose what you want to do with tasks. 1. Go to a task, 2. Add task, 3. Delete task");
        ArrayList<Task> start = new ArrayList<Task>(); 
        lookAtTasks(scnr, start); 
      scnr.close();
    }
}

//Suggestion: Some of them are repeated, I could probably make them an interface if I have a clearer idea of what it is. 