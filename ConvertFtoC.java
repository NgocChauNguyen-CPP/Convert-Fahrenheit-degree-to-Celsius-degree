//
//  Name:       Nguyen, Ngoc Chau
//  Project:    1
//  Due:        February 14th, 2024
//  Course:     CS-2450-01-SP24
//
//  Description:
//              Implement a simple application class named "ConvertFtoC"
//              that will convert temperature from Fahrenheit to Celcius
//              using Java Swing GUI.
//              Conversion occurs after the user hits enter in the text field.
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ConvertFtoC implements ActionListener
{
    //INSTANCE VARIABLE
    private JLabel degreesC;
    private JTextField myTextField;

    //CONSTRUCTOR
    public ConvertFtoC()
    {
        JFrame myFrame = new JFrame("Temperature Converter");
        myFrame.setSize(240, 120); 
        myFrame.setLayout(new BorderLayout());
    
        //CREATE COMPONENTS
        JLabel nameLabel = new JLabel("by N. Nguyen", JLabel.CENTER);
        JLabel enterLabel = new JLabel("Enter: ");
        myTextField = new JTextField(10);
        myTextField.setHorizontalAlignment(JTextField.RIGHT);
        
        JLabel degreesF = new JLabel("degress F");
        degreesC = new JLabel("_degrees C",JLabel.RIGHT);
        
        //ADD COMPONENTS TO THE FRAME
        myFrame.add(nameLabel, BorderLayout.NORTH);
        myFrame.add(enterLabel, BorderLayout.WEST);
        myFrame.add(myTextField, BorderLayout.CENTER);
        myFrame.add(degreesF, BorderLayout.EAST);
        myFrame.add(degreesC, BorderLayout.SOUTH);
       
        //ADD ACTION LISTENER TO TEXTFIELD
        myTextField.addActionListener(this);
        
        //TERMINATE APPLICATION  WHEN USERS CLICK EXIT
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
    
    //Override abstract method "actionPerformed (ActionEvent)
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String userInput = myTextField.getText();
        
        try
        {
           double FDegree = Double.parseDouble(userInput);
         
            degreesC.setText(Math.round(((FDegree - 32) * 5.0 / 9.0) * 100.0) / 100.0 + " degress C");
        }
        catch(NumberFormatException e)
        {
            degreesC.setText("Invalid input");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater
                (() -> new ConvertFtoC());
    }
    
}
