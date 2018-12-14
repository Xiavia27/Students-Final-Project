/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author tony1
 */
public class Student {
    //All variabls needed for a student
    private String LastName;
    private String FirstName;
    private String Email;
    private String Password;
    private String BannerID;
    private String StudentType;
    private Major stuMajor;
    private double remBalance;
    
    //creating empty student
    public Student(){}
    //creting student with manual fields
    public Student(String ln, String fn, String Em, String pss, String BID, String ST, Major sM, double rB)
    {
        LastName = ln;
        FirstName = fn;
        Email = Em;
        Password = pss;
        BannerID = BID;
        StudentType = ST;
        stuMajor = sM;
        remBalance = rB;
    }
    //creating a copy of a student
    public Student(Student s)
    {
         LastName = s.getLastName();
         FirstName = s.getFirstName();
         Email = s.getEmail();
         Password = s.getPassword();
         BannerID = s.getBannerID();
         StudentType = s.getStudetnType();
         stuMajor = s.getMajor();
         remBalance = s.getRemBalance();
    }
    
    //All getters for student variables
    public String getLastName(){return LastName;}
    public String getFirstName(){return FirstName;}
    public String getFullname(){return FirstName + " " + LastName;}
    public String getEmail(){return Email;}
    public String getPassword(){return Password;}
    public String getBannerID(){return BannerID;}
    public String getStudetnType(){return StudentType;}
    public Major getMajor(){return stuMajor;}
    public double getRemBalance(){return remBalance;}
    
    //Copy meathod allows you to copy a student
     public void copy(Student s)
     {
         LastName = s.getLastName();
         FirstName = s.getFirstName();
         Email = s.getEmail();
         Password = s.getPassword();
         BannerID = s.getBannerID();
         StudentType = s.getStudetnType();
         stuMajor = s.getMajor();
         remBalance = s.getRemBalance();
         
     }
     //checks if 2 studetns are the same
    public boolean equals(Student s)
    {
        return LastName.equals(s.getLastName()) &&
                FirstName.equals(s.getFirstName())&&
                Email.equals(s.getEmail()) &&
                Password.equals(s.getPassword()) &&
                BannerID.equals(s.getBannerID()) &&
                StudentType.equals(s.getStudetnType()) &&
                stuMajor.equals(s.getMajor()) &&
                remBalance == s.getRemBalance();
    }
    //turns student into readable format
    @Override
    public String toString()
    {
        String str = FirstName;
        str += " " + LastName + "\n";
        str += "Email: " + Email + "\n";
        str += "Banner ID: " + BannerID + "\n";
        str += "Student Type: " + StudentType + "\n";
        str += "Major: " + stuMajor.toString() + "\n";
        str += "Remaining Balance: " + remBalance;
        return str;
    }
     
     
            
}
