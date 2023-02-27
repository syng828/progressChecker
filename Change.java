//the other classes share similarities to this. 
import java.io.Serializable;
import java.util.Scanner;

public abstract class Change implements Serializable{ 
    String name; 
    
    public abstract void goIn(Scanner scnr); 
    public abstract void addInArrayList(Scanner scnr);
    public abstract void deleteInArrayList(Scanner scnr); 
    public abstract void printArrayList();
    public abstract void interact(Scanner scnr); 

    public void setName(String name) { 
        this.name = name; 
    }

    public String getName() { 
        return this.name; 
    }
   

}