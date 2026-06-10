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
public class EnrollmentCRUD {

    public void addEnrollment(EnrollmentInfo enroll) {
        String sql = "INSERT INTO mydb.`Enrollment table` (`Enrollment ID`, `Student Table_Student Id`, `Course Table_Course_ID`,`Enrollment_Date`) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, enroll.getEnrollID());
            stmt.setInt(2, enroll.getStudentID());
            stmt.setInt(3, enroll.getCourseID());
            stmt.setObject(4, enroll.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteEnrolment(int EnrollID) {
        String sql = "DELETE FROM mydb.`enrollment table` WHERE `Enrollment ID` = ?";

        try (Connection conn = DBConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setInt(1, EnrollID);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Successfully deleted with ID: " + EnrollID);
            } else {
                System.out.println("No Enrollment ID found with ID: " + EnrollID + " (Nothing was deleted)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public List<EnrollmentInfo> getAllEnroll() {
    List<EnrollmentInfo> enroll = new ArrayList<>();
    String sql = "SELECT * FROM mydb.`Enrollment table`";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            EnrollmentInfo Enroll = new EnrollmentInfo();
            Enroll.setEnrollID(rs.getInt("Enrollment ID"));
            Enroll.setStudentID(rs.getInt("Student Table_Student Id"));
            Enroll.setCourseID(rs.getInt("Course Table_Course_ID"));
            Enroll.setDate(rs.getObject("Enrollment_Date"));
            enroll.add(Enroll);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return enroll;
}
     public boolean isAlreadyEnrolled(int studentId, int courseId) {
    String query = "SELECT COUNT(*) FROM mydb.`enrollment table` WHERE `Student Table_Student ID` = ? AND `Course Table_Course_ID` = ?";
    
    try (java.sql.Connection conn = DBConnection.getConnection(); 
         java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, studentId);
        pstmt.setInt(2, courseId);
        
        try (java.sql.ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        }
    } catch (java.sql.SQLException ex) {
        ex.printStackTrace();
    }
    
    return false;
}
}
