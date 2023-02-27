import java.util.ArrayList;
import java.util.Scanner;

public class Subject extends Change { 
    private ArrayList<Topic> topic = new ArrayList<>();

    //Topic creation
    public Subject (String name) { 
        setName(name); 
    }
    public Subject() { 
        setName(""); 
    }

    //Goes into topic 
    @Override 
    public void goIn(Scanner scnr) { 
        int currentTopicLooking = -1;
        System.out.println("Enter a topic name to search for: ");
        String name = scnr.nextLine();
        for (int i = 0; i < topic.size(); i++) { 
            if (topic.get(i).getName().equals(name)) { 
                currentTopicLooking = i; 
                topic.get(i).interact(scnr); 
            }
          }
        if (currentTopicLooking == -1){
            System.out.println("Not found."); 
            return;
        }
    }

    //Editing arrayList of type Topic 
    @Override
    public void addInArrayList(Scanner scnr) {
        System.out.println("Please enter the topic you wish to add: ");  
        String toAdd = scnr.nextLine();
        Topic newTopic = new Topic(toAdd); 
        topic.add(newTopic);
        System.out.println("Added.");
    }

    @Override
    public void deleteInArrayList(Scanner scnr) { 
        System.out.println("Please enter the topic you wish to delete: "); 
        String toDelete = scnr.nextLine();
        for (int i = topic.size() - 1; i >= 0 ; i--) { 
            if (topic.get(i).getName().equals(toDelete)){
                topic.remove(i); 
                System.out.println("Deleted.");  
                return; 
            }
        }
        System.out.println("Could not find."); 
    } 

    public ArrayList<Topic> getArrayList() { 
        return topic; 
    }
    @Override
    public void printArrayList() { 
        if (topic.size() == 0) { 
            System.out.println("No topics inside."); 
        }
        else { 
        for (Topic t : topic){ 
            System.out.println(t.getName()); 
        }
        }
    }

    //Starts reading the subject class. 
   
    public void interact(Scanner scnr) { 
        System.out.println(" You are currently looking at all the topics. Please specify what you would like to do with the topics. 1. Go to a topic, 2. Add a topic, 3. Delete a topic, 4. See all topics, 5. Go back");
        boolean stillLooking = true;  

        while (stillLooking){
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
                System.out.println(" First please choose what you want to do with subjects. 1. Go to a subject, 2. Add subject, 3. Delete subject, 4. See all subjects, 5. Quit");
                stillLooking = false; 
                break; 
            default: 
                System.out.println("Please enter a valid input");
                break;
        }
       }
    }

}
