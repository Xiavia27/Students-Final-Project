/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author tony1
 */
public class UploadStudentFileWindow extends JFrame {
    //all components needed for window
    JLabel filenameLabel;
    JTextField filename;
    JButton uploadButton;
    //students list
    ArrayList<Student>Students = new ArrayList<>();
    public UploadStudentFileWindow(ArrayList<Student> s)
    {
        Students = s;
        int WINDOW_WIDTH = 200;
        int WINDOW_HIGHT = 400;
        setTitle("Upload Student File");
        setSize(WINDOW_WIDTH, WINDOW_HIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createWindow();
        setVisible(true);
    }
    
    //creates the window 
    public void createWindow()
    {        
        JPanel panel = new JPanel();
        filenameLabel = new JLabel("File name");
        filename = new JTextField(10);
        uploadButton = new JButton("Upload");
        uploadButton.addActionListener(new ButtonListener());
        
        panel.add(filenameLabel);
        panel.add(filename);
        panel.add(uploadButton);
        add(panel);
    }
    //runs through the file and does validation then adds student to list if all clear. Throws exception if not with line number
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Upload")){
            try{
            String lastName;
            String firstName;
            String Email;
            String BannerID;
            String Password;
            String StudentType;
            String stuMajor;
            Major studentMajor;
            String remBalance;

            
            boolean flag = true;
            int counter = 0;
            File file = new File(filename.getText());
            Scanner inFile = new Scanner(file);
            inFile.useDelimiter(",");
            while(inFile.hasNext())
            {
                lastName = inFile.next();
                firstName = inFile.next();
                Email = inFile.next();
                BannerID = inFile.next();
                Password = inFile.next();
                StudentType = inFile.next();
                stuMajor = inFile.next();
                remBalance = inFile.next();
                if(Double.valueOf(remBalance) < 0) //checks that the number is above 0 and a number
                    throw new UploadStudentFileError("Remaining Balance error at" + counter + " line");
                if(listedMajor(stuMajor)) //sends string to meathod listedMajor which returns true or false
                    throw new UploadStudentFileError("Major is not appliable on line " + counter);
                else 
                    studentMajor = Major.valueOf(stuMajor.toUpperCase());
                
                Student a = new Student(lastName, firstName, Email, BannerID, Password, StudentType, studentMajor, Double.parseDouble(remBalance));
                Students.add(a);
                    
                
                
            }
            JOptionPane.showMessageDialog(null, "File Uploaded");
            }
            catch(Exception exc)
            {
                JOptionPane.showMessageDialog(null, "ERROR: " + exc.toString());
            }
            }

        }
    }
    //takes a string from file and checks it is usuable major
    public boolean listedMajor(String s){
        for(Major a : Major.values())
        {
            if(a.name().equalsIgnoreCase(s))
                return false;
        }
        return true;
    }
}
