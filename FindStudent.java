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
public class FindStudent extends JFrame{
    //all JFrame components needed
    JTextField stuName;
    JButton findStudent;
    JLabel TFLabel;
    JLabel FoundStudent;
    //Array of students S
    ArrayList<Student> Students = new ArrayList<>();
    public FindStudent(ArrayList<Student> s){
        Students = s;
        int WINDOW_WIDTH = 200;
        int WINDOW_HIGHT = 400;
        setTitle("Find Student");
        setSize(WINDOW_WIDTH, WINDOW_HIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createWindow();
        setVisible(true);
    }
    //creates the window
    public void createWindow()
    {
        JPanel panel = new JPanel();
        TFLabel = new JLabel("Student Name");
        stuName = new JTextField(10);
        findStudent = new JButton("Find Student");
        findStudent.addActionListener(new buttonListen());
        FoundStudent = new JLabel();
        
        panel.add(TFLabel);
        panel.add(stuName);
        panel.add(findStudent);
        panel.add(FoundStudent);
        add(panel);
    }
    //when button is pushed sorts the ArrayList by last name and then displays the name of student if found
    private class buttonListen implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Collections.sort(Students, (a,b) -> a.getLastName().compareToIgnoreCase(b.getLastName()));
            int i = binarySearch(Students, stuName.getText());
            if(i == -1)
                FoundStudent.setText("Student Not Found.");
            else 
                FoundStudent.setText(Students.get(i).toString());
            
        }
    }
    //Searches the ArrayList with a binary search
    public static int binarySearch(ArrayList<Student> a, String b) {
        int low = 0;
        int high = a.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a.get(mid).getFullname().compareTo(b) < 0) {
                low = mid + 1;
            } else if (a.get(mid).getFullname().compareTo(b) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


}
