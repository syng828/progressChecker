import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainPageGUI extends JFrame implements ActionListener{ // main page 
        private JButton fileOpen; 
        private JButton fileCreate; 
        private JLabel introduction; 
        private JLabel introduction2;
       
    
        MainPageGUI() {
            GridBagConstraints layoutConst; 
            introduction = new JLabel(); 
            introduction.setText("This application helps track your progress. You can modify all subjects, topics, and questions if you like.");
    
            introduction2 = new JLabel(); 
            introduction2.setText("First, please indicate if you would like to open an old save file, or create a new save. Any edits you make to an old save file will automatically be saved.");
    
            fileOpen = new JButton("Open Saved File"); 
            fileOpen.addActionListener(this);
    
            fileCreate = new JButton("Create New Save"); 
            fileCreate.addActionListener(this);
    
            setTitle("Progress Checker");
            setLayout(new GridBagLayout()); 
            
            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0; 
            layoutConst.gridy = 0;
            layoutConst.insets = new Insets(10,10,10,10); 
            add(introduction, layoutConst);
    
            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0; 
            layoutConst.gridy = 1;
            layoutConst.insets = new Insets(10,10,10,10); 
            add(introduction2,layoutConst);
    
            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0; 
            layoutConst.gridy = 2;
            layoutConst.insets = new Insets(10,10,10,10); 
            add(fileOpen,layoutConst);
    
            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0; 
            layoutConst.gridy = 3;
            layoutConst.insets = new Insets(10,10,10,10); 
            add(fileCreate,layoutConst);

            setVisible(true);
     }
     
     @Override
     public void actionPerformed(ActionEvent e) {
        
         if (e.getSource()==fileOpen){ 
            FileGUI fg = new FileGUI();
            fg.openFileWindow();
         }
    
         if (e.getSource()==fileCreate){ 
            FileGUI fg = new FileGUI();
            fg.createFileWindow();
         }
        
     }


    public static void main (String[]args) { 
        MainPageGUI mp = new MainPageGUI(); 

        mp.pack();
        mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }
}