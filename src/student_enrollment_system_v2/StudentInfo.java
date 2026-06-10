/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system_v2;

/**
 *
 * @author river
 */
public class StudentInfo {
    private int Student_ID;
    private String First_Name;
    private String Last_Name;
    private int Age;
    private String Email;

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    
    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public int getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }
    
    
}
