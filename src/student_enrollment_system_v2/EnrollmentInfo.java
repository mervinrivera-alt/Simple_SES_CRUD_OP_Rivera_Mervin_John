/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system_v2;

/**
 *
 * @author river
 */
public class EnrollmentInfo {
    private int enrollID;
    private int studentID;
    private int courseID;
    private Object date;

    public void setEnrollID(int enrollID) {
        this.enrollID = enrollID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public int getEnrollID() {
        return enrollID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public Object getDate() {
        return date;
    }
    
    
}
