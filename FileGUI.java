import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileGUI extends JFrame {
    private JFileChooser fileChooser;
    private int fileChooserVal; 

    File readFile;  
    private FileOutputStream fos; 
    private FileInputStream fis; 
    private Scanner scnr = new Scanner(System.in);

    FileGUI() { 
        fileChooser = new JFileChooser();
    }

    public void createFileWindow(){ 
        fileChooserVal = fileChooser.showSaveDialog(this); 

        try {
            if (fileChooserVal == JFileChooser.APPROVE_OPTION){
                readFile = fileChooser.getSelectedFile(); 
                readFile.createNewFile();
                if (readFile.canWrite()) { 
                    fos = new FileOutputStream(readFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos); 

                    Start read = new Start(); 
                    read.interact(scnr); 
                    oos.writeObject(read);
                    JOptionPane.showMessageDialog(this, "Successfully written into a file."); 
        
                    fos.close();
                }
            } 
            else  { 
                JOptionPane.showMessageDialog(this, "Cannot save the file!");
            }
        }
        catch(FileNotFoundException e) { 
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
        catch (IOException e) { 
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }

   public void openFileWindow(){ 

        try {
            fileChooserVal = fileChooser.showOpenDialog(this); 

            if (fileChooserVal == JFileChooser.APPROVE_OPTION){ 
                readFile = fileChooser.getSelectedFile(); 

                if (readFile.canRead()){ 
                    fis = new FileInputStream(readFile); 
                    ObjectInputStream objectIn = new ObjectInputStream(fis);
                    Start read = (Start) objectIn.readObject();      

                    objectIn.close(); 
                    read.interact(scnr); 

                    fos = new FileOutputStream(readFile); //Rewrites the file 
                    ObjectOutputStream objectOut = new ObjectOutputStream(fos); 

                    objectOut.writeObject(read); 
                    objectOut.close(); 
                    JOptionPane.showMessageDialog(this, "File saved."); 
                } 
                else { 
                    JOptionPane.showMessageDialog(this, "Can't read the file!");
                }
            }
        }

        catch (IOException x) { 
            JOptionPane.showMessageDialog(this, x.getMessage());
        }
        catch (ClassNotFoundException x){ 
            JOptionPane.showMessageDialog(this, x.getMessage());
        }
        catch (Exception x) { 
            JOptionPane.showMessageDialog(this, x.getMessage()); 
        } 
     }
    
}
