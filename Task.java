import java.util.ArrayList;
import java.util.Scanner;

public class Task { //Singular task 
    private String taskName;
    private ArrayList<Topic> topic = new ArrayList<>();

    public Task (String taskName){
        this.taskName = taskName; 
    }
    public String getTaskName() { 
        return taskName;
    }
    public void setTaskName(String taskName) { 
        taskName = this.taskName;
    }
    public void addTopic(Scanner scnr) { 
        System.out.println("Please enter a topic: ");
        String newTopic = scnr.nextLine(); 
        Topic t = new Topic(newTopic); 
        topic.add(t);
    }
    
    public void printTopic() { 
        for (Topic t : topic){ 
            System.out.println(t.getTopicName()); 
        }
    }
}
