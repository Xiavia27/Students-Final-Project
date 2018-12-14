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
/**
 *
 * @author tony1
 */
public class InitialWindow extends JFrame{
    //all JFrame components needed
    JButton Upload;
    JButton NewStudent;
    JButton Download;
    JButton Search;
    JButton Exit;
 
    JLabel Welcome;
    //ArrayList of Students recieved from main
    ArrayList<Student> Students = new ArrayList<>();
    public InitialWindow(ArrayList<Student> s)
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
    private void createWindow()
    {
        JPanel newPanel = new JPanel();
        Welcome = new JLabel("Welcome to MCC's Student Record System. Please choose one of the following options.");
        
        Upload = new JButton("Upload Student Records from file");
        Upload.addActionListener(new buttonListen());
        
        NewStudent = new JButton("Add new student");
        NewStudent.addActionListener(new buttonListen());
        
        Download = new JButton("Download statistics");
        Download.addActionListener(new buttonListen());
        
        Search = new JButton("Find student");
        Search.addActionListener(new buttonListen());
        
        Exit = new JButton("Exit");
        Exit.addActionListener(new buttonListen());
        
        newPanel.add(Welcome);
        newPanel.add(Upload);
        newPanel.add(NewStudent);
        newPanel.add(Download);
        newPanel.add(Search);
        newPanel.add(Exit);
        
        
        add(newPanel);
        
    }
    //opens the coresponding window depending on which button was pushed
    private class buttonListen implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                String ButtonPushed = e.getActionCommand();
                
                if(ButtonPushed.equals("Upload Student Records from file"))
                {
                    uploadWindow();
                }
                else if(ButtonPushed.equals("Add new student"))
                {
                    newStudentWindow();
                }
                else if(ButtonPushed.equals("Download statistics"))
                {
                    downloadWindow();
                }
                else if(ButtonPushed.equals("Find student"))
                {
                    findStudentWindow();
                }
                else if(ButtonPushed.equals("Exit"))
                {
                    dispose();
                }
            }
        }
    
    
    //functions to open windows, makes code clean
    public void findStudentWindow()
    {

        FindStudent fs = new FindStudent(Students);

    }
    
    public void downloadWindow()
    {
        DownloadWindow dw = new DownloadWindow(Students);
    }
    
    public void newStudentWindow()
    {
        AddStudentWindow asw = new AddStudentWindow(Students);
    }
    
    public void uploadWindow()
    {
        UploadStudentFileWindow usfw = new UploadStudentFileWindow(Students);
    }
}
