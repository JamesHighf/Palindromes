/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pallendrome.project;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author James Highfield
 */
public class PallendromeProject {

   
    public static void main(String[] args) {   
        
    //this section deals entirely with buttons and other GUI things, and isn't particularly relevant to the project as a whole
    JFrame f= new JFrame("Palindrome Tester"); 
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTextField text1;
    text1=new JTextField("Please enter a string."); //Text field for string entry 
    text1.setBounds(950,400, 200,30);  
    JButton checkButton = new JButton("Test String"); //Check button for string submission
    JLabel labeltrue = new JLabel("is a palindrome");
        labeltrue.setBounds(1150, 405, 200, 20);
        f.add(labeltrue);
         JLabel labelfalse = new JLabel("is not a palindrome");
        labelfalse.setBounds(1150, 405, 200, 20);
        f.add(labelfalse);
    JToggleButton caseButton = new JToggleButton("Toggle case sensitivity"); //Toggle button for case
    caseButton.setBounds(970,600,165,30);    
    labelfalse.setVisible(false);
    labeltrue.setVisible(false);
    
    checkButton.setBounds(1000,500,110,30);
    f.add(checkButton);
    f.add(caseButton);
            
    f.add(text1);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    
    //
    
    checkButton.addActionListener((ActionEvent e) -> { //This listener has the method in it that checks for a palindrome
        Stack pStack = new Stack();
        String inputString = (text1.getText());
        String reversedStr = "";
        char[] chars = inputString.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            pStack.push(inputString.charAt(i)); 
        }
        //Reverses string
        while (!pStack.isEmpty()) {
            reversedStr += pStack.pop(); //LIFO principle allows this without further code. O(n) complexity.
        }
                
        //Compares string
        int results = 0;
        if (caseButton.isSelected()) {
        results = (inputString.compareTo(reversedStr));
        }
        else {
        results = (inputString.compareToIgnoreCase(reversedStr));    
        }
        //Uses comparison
        
        
        if (results == 0) {
       labelfalse.setVisible(false);
       labeltrue.setVisible(true);
        }
        else {
        labelfalse.setVisible(true);
       labeltrue.setVisible(false);
        }
        
        
           });
     
     
   
   
    }
}

