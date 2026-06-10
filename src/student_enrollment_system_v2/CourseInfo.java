/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system_v2;

/**
 *
 * @author river
 */
public class CourseInfo {
    private int courseid;
    private String CourseName;
    private String courseDetails;
    private double credits;

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public int getCourseid() {
        return courseid;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseDetails() {
        return courseDetails;
    }

    public double getCredits() {
        return credits;
    }
    
    
}
