/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author tony1
 */
public class AddStudentWindow extends JFrame{
    //All Labels needed
    JLabel LastNameLabel;
    JLabel FirstNameLabel;
    JLabel PasswordLabel;
    JLabel Password2Label;
    JLabel StudentTypeLabel;
    JLabel RemBalanceLabel;
    //all textfields needed
    JTextField LastNameText;
    JTextField FirstNameText;
    JTextField PasswordText;
    JTextField Password2Text;
    JTextField StudentTypeText;
    JTextField RemBalanceText;
    //button to add student
    JButton addStudent;
    //holds list of students
    ArrayList<Student> Students = new ArrayList<>();
    
    //create instance of window and give window list of students to work with
    public AddStudentWindow(ArrayList<Student> s)
    {
        Students = s;
        System.out.println(Students.toString());
        int WINDOW_WIDTH = 800;
        int WINDOW_HIGHT = 400;
        setTitle("Student Records");
        setSize(WINDOW_WIDTH, WINDOW_HIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createWindow();
        setVisible(true);
    }
    //creates the window
    public void createWindow(){
        JPanel panel = new JPanel();
        LastNameLabel = new JLabel("Last Name");
        FirstNameLabel = new JLabel("First Name");
        PasswordLabel = new JLabel("Password");
        Password2Label = new JLabel("Confirm Password");
        StudentTypeLabel = new JLabel("Student Type");
        RemBalanceLabel = new JLabel("Remaining Balance");

        LastNameText = new JTextField(10);
        FirstNameText = new JTextField(10);
        PasswordText = new JTextField(10);
        Password2Text = new JTextField(10);
        StudentTypeText = new JTextField(10);
        RemBalanceText = new JTextField(10);
        
        addStudent = new JButton("Add Student");
        addStudent.addActionListener(new buttonListener());
        
        panel.add(LastNameLabel);
        panel.add(LastNameText);
        panel.add(FirstNameLabel);
        panel.add(FirstNameText);
        panel.add(PasswordLabel);
        panel.add(PasswordText);
        panel.add(Password2Label);
        panel.add(Password2Text);
        panel.add(StudentTypeLabel);
        panel.add(StudentTypeText);
        panel.add(RemBalanceLabel);
        panel.add(RemBalanceText);
        panel.add(addStudent);
        add(panel);
        
    }
    
    //add student to list or tells user that info entered is incorrect
    private class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!passwordValidation(PasswordText.getText(), Password2Text.getText())) //checks that the password follows convention
            {
                try{
                PasswordText.setBackground(Color.red);
                throw new AddStudentException("Password is not allowed");
                }
                catch(Exception exc)
                {
                    JOptionPane.showMessageDialog(null, exc.getMessage());
                }
            }
            else{
                String Email = FirstNameText.getText().charAt(0) + LastNameText.getText() + "@mcc.edu";
                Student newStudent = new Student(LastNameText.getText(), FirstNameText.getText(), Email, PasswordText.getText(),
                                                    "0123456789", StudentTypeText.getText(), Major.NO_MAJOR, Double.parseDouble(RemBalanceText.getText()));
                JOptionPane.showMessageDialog(null, "You have been added to the system.\n" + newStudent.toString());
                PasswordText.setBackground(Color.white);
                clearOptions(); //sets all the textfields back to cleared
            }
            
        }
    }
    //if the passords dont match, the length isnt between 8 and 10, contains the first or last name, or doesnt have atleast 1 digit, uppercase/lowercase number returns false
    public boolean passwordValidation(String pass, String pass2)
    {
        int upCount = 0;
        int lowCount = 0;
        int numCount = 0;
        if(!pass.equals(pass2))
            return false;
        if(pass.length() > 11 || pass.length()< 7)
            return false;
        for(int i = 0; i < pass.length(); i++)
        {
            if(Character.isUpperCase(pass.charAt(i)))
                upCount++;
            if(Character.isLowerCase(pass.charAt(i)))
                lowCount++;
            if(Character.isDigit(pass.charAt(i)))
                numCount++;
        }
        if(upCount == 0 || lowCount == 0 || numCount == 0)
            return false;
        if(pass.toLowerCase().contains(FirstNameText.getText().toLowerCase()))
            return false;
        if(pass.toLowerCase().contains(LastNameText.getText().toLowerCase()))
            return false;
        
        return true;
        
    }
    //sets all the text to blank for a new student to be entered
    public void clearOptions(){
    LastNameText.setText("");
    FirstNameText.setText("");
    PasswordText.setText("");
    Password2Text.setText("");
    StudentTypeText.setText("");
    RemBalanceText.setText("");
    }
}
