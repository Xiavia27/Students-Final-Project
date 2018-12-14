/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author tony1
 */

public class FinalProject {
    
    
    
    public static void main(String[] args) {
        ArrayList<Student> Students = new ArrayList<>();
        Student a = new Student("LaTorre", "Anthony", "tony1latorre", "Password", "01675984", "Full-Time", Major.COMPUTER_SCIENCE, 102.25);
        Students.add(a);
        InitialWindow iw = new InitialWindow(Students);
    }
    
}
