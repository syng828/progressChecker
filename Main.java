/* 
Quick TODOs: 
@TODO: Next time working on this, I'll move it all to another class, and the file reader make it a static method above. 
@TODO: And perhaps save the files to an actual directory, so that can delete. 

@TODO: UI creation. */


import java.util.Scanner;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Main extends Change {
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

  public void printAll() { 
    for (int i = 0 ; i < start.size(); i++) { 
      System.out.println("Subject: " + start.get(i).getName()); 
      ArrayList <Topic> gotten = start.get(i).getArrayList();
      for (int j = 0; j <gotten.size(); j++) { 
        System.out.println (" Topic: " + gotten.get(j).getName() + " | " + gotten.get(j).getProgress()); 
      }
    }

  }
   //Starts interacting 
  
     public void interact(Scanner scnr){
      System.out.println("Would you like to see all your information? Please enter Y if so."); 
      String scan = scnr.nextLine(); 
      if (scan.equals("Y")) { 
        printAll(); 
      }

      System.out.println(" You are currently looking at all the subjects. Please choose what you want to do with subjects. 1. Go to a subject, 2. Add subject, 3. Delete subject, 4. See all subjects, 5. Quit");
      boolean stillLooking = true; 
      while (stillLooking) { 
        scan = scnr.nextLine();       
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
                  stillLooking = false; 
                  break;
              default: 
                  System.out.println("Please enter a valid input");
                  break; 
          }
      }
  }
    
    public static void main( String[]args) throws IOException {  

        Scanner scnr = new Scanner(System.in);  
      
        System.out.println("This can track your progress. You can modify all subjects, topics, and questions if you like."); 
        System.out.println("First, please indicate if you would like to open an old save file, or create a new file. (O/N)"); 
        String choice = scnr.nextLine(); 

        boolean foundValid = false; 

        while (!foundValid){    //loops until gives wanted input.
        try {                                        
          if (choice.equals("O")){                //Opens old file 
            foundValid = true; 

            System.out.println("Please enter the name of the file."); 
            choice = scnr.nextLine(); 
            FileInputStream fis = new FileInputStream(choice + ".txt"); 
            ObjectInputStream objectIn = new ObjectInputStream(fis);
            Main read = (Main) objectIn.readObject();      
            read.interact(scnr); 

            FileOutputStream fos = new FileOutputStream(choice + ".txt"); //Rewrites the file 
            ObjectOutputStream objectOut = new ObjectOutputStream(fos); 

            objectOut.writeObject(read); 

            objectOut.close(); 
            objectIn.close();
          }

          else if (choice.equals("N")){        //Creates a new file 
                                                        
            foundValid = true; 

            System.out.println("Please enter a name for your file");
            choice = scnr.nextLine(); 
            FileOutputStream fos = new FileOutputStream(choice + ".txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fos);

            Main read = new Main(); 
            read.interact(scnr); 
            objectOut.writeObject(read);
            System.out.println("Successfully written into a file.");

            objectOut.close(); 

          }
          else {  //Invalid input
            throw new Exception("Please enter a valid input.");
          }
        }

        //Exceptions
        catch (FileNotFoundException e) {  
          System.out.println("File not found. Please input O again if you would like to open another file.");
          foundValid = false; 
          choice = scnr.nextLine(); 
        }
        catch (EOFException e) { 
          e.printStackTrace(); 
        }
        catch (IOException e) { 
          e.printStackTrace();
        }
       catch (Exception e) { 
          System.out.println(e.getMessage());
          choice = scnr.nextLine();   
       }
      }
       scnr.close(); 
        
    }

    
}

