import java.util.Scanner;
import java.util.ArrayList;

public class Main extends Change{
  private ArrayList<Subject> start = new ArrayList<Subject>(); 

  @Override
  public void addInArrayList(Scanner scnr) {
    System.out.println("Enter a subject name: "); 
    String name = scnr.nextLine();
    start.add(new Subject(name));
    System.out.println("Subject added.");
  }

  @Override
  public void deleteInArrayList(Scanner scnr) {
    System.out.println("Please enter the subject you would like to delete." );
    String taskName = scnr.nextLine();
    for (int i = 0; i < start.size(); i++) { 
      if (start.get(i).getName().equals(taskName)) { 
          start.remove(i);
          System.out.println("Deleted.");  
          return; 
      }
    }
    System.out.println("Could not find."); 
  }

  @Override
  public void goIn(Scanner scnr) {
    System.out.println("Enter a subject name to search for: "); 
    String name = scnr.nextLine();
    int currentTaskLooking = -1;
    for (int i = 0; i < start.size(); i++) { 
        if (start.get(i).getName().equals(name)) { 
            currentTaskLooking = i;
            start.get(i).interact(scnr); 
        }
      }
    if (currentTaskLooking == -1){
        System.out.println("Not found.");
    }
  }


  @Override
  public void printArrayList() {
    if (start.size() == 0) { 
      System.out.println("No subjects inside."); 
   }
   else {
    for (Subject s: start){
      System.out.println(s.getName()); 
    }
    }
  }

   //Starts interacting 
  
     public void interact(Scanner scnr){
      System.out.println(" First please choose what you want to do with subjects. 1. Go to a subject, 2. Add subject, 3. Delete subject, 4. See all subjects, 5. Quit");
      while (scnr.hasNextLine()) { 
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
                  System.out.println("See you again!"); 
                  System.exit(0); 
              default: 
                  System.out.println("Please enter a valid input");
                  scan = scnr.nextLine();
                  break; 
          }
      }
  }
    
    public static void main( String[]args) {
        Scanner scnr = new Scanner(System.in);  
        System.out.print("This can track your progress. You can modify all subjects, topics, and questions if you like."); 
        Main read = new Main(); 
        read.interact(scnr); 
      scnr.close();
    }

    
}

