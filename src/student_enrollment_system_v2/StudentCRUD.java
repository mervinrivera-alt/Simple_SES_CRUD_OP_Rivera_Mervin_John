/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system_v2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class StudentCRUD {
    
    public void addStudent(StudentInfo student) {
    String sql = "INSERT INTO mydb.`student table` (`First_Name`, `Last_Name`, `Age`, `Email`) VALUES (?, ?, ?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setString(1, student.getFirst_Name());
         stmt.setString(2, student.getLast_Name());
         stmt.setInt(3, student.getAge());
         stmt.setString(4, student.getEmail());
         stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
}
    public List<StudentInfo> getAllStudents() {
    List<StudentInfo> students = new ArrayList<>();
    String sql = "SELECT * FROM mydb.`Student table`";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            StudentInfo student = new StudentInfo();
            student.setStudent_ID(rs.getInt("Student Id"));
            student.setFirst_Name(rs.getString("First_Name"));
            student.setLast_Name(rs.getString("last_Name"));
            student.setAge(rs.getInt("Age"));
            student.setEmail(rs.getString("Email"));
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return students;
}
    public void updateStudent(StudentInfo student) {
        String sql = "UPDATE mydb.`student table` SET `First_Name` = ?, `Last_Name` = ?, `Age` = ?, `Email` = ? WHERE `Student ID` = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Set the NEW values
        stmt.setString(1, student.getFirst_Name());
        stmt.setString(2, student.getLast_Name());
        stmt.setInt(3, student.getAge());
        stmt.setString(4, student.getEmail());
        stmt.setInt(5, student.getStudent_ID());

        int rowsUpdated = stmt.executeUpdate();
        
        if (rowsUpdated > 0) {
            System.out.println("Update successful for Student ID: " + student.getStudent_ID());
        } else {
            System.out.println("No student found with ID: " + student.getStudent_ID());
        }

    } catch (SQLException e) {
         e.printStackTrace();
       }
    }
   public void deleteStudent(int studentId) {
    String sql = "DELETE FROM mydb.`student table` WHERE `Student Id` = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1, studentId);

         int rowsDeleted = stmt.executeUpdate();
        
         if (rowsDeleted > 0) {
            System.out.println("Successfully deleted student with ID: " + studentId);
         } else {
            System.out.println("No student found with ID: " + studentId + " (Nothing was deleted)");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
 }
}
