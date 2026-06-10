/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system_v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author river
 */
public class CourseCRUD {
    public void addCourse(CourseInfo course) {
    String sql = "INSERT INTO mydb.`course table` (`Course_Name`, `Course_Description`, `Credits`) VALUES (?, ?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setString(1, course.getCourseName());
         stmt.setString(2, course.getCourseDetails());
         stmt.setDouble(3, course.getCredits());
         stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
}
    public List<CourseInfo> getAllCourse() {
    List<CourseInfo> courses = new ArrayList<>();
    String sql = "SELECT * FROM mydb.`course table`";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            CourseInfo course = new CourseInfo();
            course.setCourseid(rs.getInt("Course_ID"));
            course.setCourseName(rs.getString("Course_Name"));
            course.setCourseDetails(rs.getString("Course_Description"));
            course.setCredits(rs.getDouble("Credits"));
            courses.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return courses;
}
    public void updateCourse(CourseInfo course) {
        String sql = "UPDATE mydb.`course table` SET `Course_Name` = ?, `Course_Description` = ?, `Credits` = ? WHERE `Course_ID` = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Set the NEW values
        stmt.setString(1, course.getCourseName());
        stmt.setString(2, course.getCourseDetails());
        stmt.setDouble(3, course.getCredits());
        stmt.setInt(4, course.getCourseid());

        int rowsUpdated = stmt.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Update successful for Student ID: " + course.getCourseid());
        } else {
            System.out.println("No student found with ID: " + course.getCourseid());
        }

    } catch (SQLException e) {
         e.printStackTrace();
       }
    }
   public void deleteStudent(int courseid) {
    String sql = "DELETE FROM mydb.`course table` WHERE `Course_ID` = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1, courseid);

         int rowsDeleted = stmt.executeUpdate();
        
         if (rowsDeleted > 0) {
            System.out.println("Successfully deleted student with ID: " + courseid);
         } else {
            System.out.println("No student found with ID: " + courseid + " (Nothing was deleted)");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
 }
}
