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
/**
 *
 * @author tony1
 */
public class DownloadWindow extends JFrame  {
    //all JFrame components for the 
    JLabel filenameLabel;
    JTextField filename;
    JButton downloadButton;
    //arraylist of students
    ArrayList<Student>Students = new ArrayList<>();
    
    //creates window and gives class the list of sudents
    public DownloadWindow(ArrayList<Student> s)
    {
        Students = s;
        int WINDOW_WIDTH = 200;
        int WINDOW_HIGHT = 400;
        setTitle("Download Student Statistics");
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
        downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ButtonListener());
        
        panel.add(filenameLabel);
        panel.add(filename);
        panel.add(downloadButton);
        add(panel);
        
        
        
    }
    //when download button is pushed, all the students in arraylist students is download to user defined file
    private class ButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 if(e.getActionCommand().equals("Download"))
                 {
                    String Name;
                    String Email;
                    String BannerID;
                    String StudentType;
                    Major stuMajor;
                    double remBalance;
                     try
                     {
                     PrintWriter pw = new PrintWriter(new File(filename.getText()));
                     for(Student s: Students){
                         Name = s.getFullname();
                         Email = s.getEmail();
                         BannerID = s.getBannerID();
                         StudentType = s.getStudetnType();
                         stuMajor = s.getMajor();
                         remBalance = s.getRemBalance();
                         pw.println(Name + ", " + Email + ", " + BannerID + ", " + StudentType + ", " + stuMajor.toString() + ", " + remBalance);
                     }
                     pw.close();
                     JOptionPane.showMessageDialog(null, "File Downloaded");
                     }
                     catch(Exception exc)
                     {
                         JOptionPane.showMessageDialog(null, exc.getMessage());
                     }
                     
                 }
            }
        }
    
}
