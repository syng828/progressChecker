import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Main {
  public static void fileScan (Scanner scnr)  { 
    System.out.println("This can track your progress. You can modify all subjects, topics, and questions if you like."); 
    System.out.println("First, please indicate if you would like to open an old save file, or create a new file. (O/N). Keep in mind that the file will be saved to your home directory."); 
    String choice = scnr.nextLine(); 

    boolean foundValid = false;
    File dirf;  
    dirf = new File(System.getProperty("user.home"));
    File file;

        while (!foundValid){    //loops until gives wanted input.
        try {                                        
          if (choice.equals("O")){                //Opens old file 
            foundValid = true; 

            System.out.println("Please enter the name of the file."); 
            choice = scnr.nextLine();
            file = new File(dirf, choice + ".txt");
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream objectIn = new ObjectInputStream(fis);
            Start read = (Start) objectIn.readObject();      
            read.interact(scnr); 

            file = new File(dirf, choice + ".txt");
            FileOutputStream fos = new FileOutputStream(file); //Rewrites the file 
            ObjectOutputStream objectOut = new ObjectOutputStream(fos); 

            objectOut.writeObject(read); 

            objectOut.close(); 
            objectIn.close();
          }

          else if (choice.equals("N")){        //Creates a new file 
                                                        
            foundValid = true;
            
            System.out.println("Please enter a name for your file.");
            choice = scnr.nextLine(); 
            file = new File(dirf, choice + ".txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fos);

            Start read = new Start(); 
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
          System.out.println("File not found. Please input O/N again if you would like to open another file or create a new file.");
          foundValid = false; 
          choice = scnr.nextLine(); 
        }
        catch (EOFException e) { 
          e.getMessage(); 
        }
        catch (IOException e) { 
          e.getMessage();
        }
        catch (ClassNotFoundException e){ 
          e.getMessage();
        }
       catch (Exception e) { 
          System.out.println(e.getMessage());
          choice = scnr.nextLine();   
       }
      }
       scnr.close(); 
        
    }

    public static void main( String[]args) {  

        Scanner scnr = new Scanner(System.in);  
        fileScan(scnr); 
    
    }
}