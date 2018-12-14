/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import javax.swing.JOptionPane;
/**
 *
 * @author tony1
 */
public class UploadStudentFileError extends Exception{
    
    public UploadStudentFileError(String s){super("Error: " + s);}
    
}
