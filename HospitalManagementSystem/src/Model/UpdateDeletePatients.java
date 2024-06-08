/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateDeletePatients {
         
    public static boolean updatePatient(String patientID, String patientName, String dob, 
        String contactNumber, String medicalHistory) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            
            String query = "UPDATE patients SET name=?, dateofbirth=?, contactNumber=?, medicalHistory=? WHERE patientID=?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, patientName);
            pstmt.setString(2, dob);
            pstmt.setString(3, contactNumber);
            pstmt.setString(4, medicalHistory);
            pstmt.setString(5, patientID);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                success = true;
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        
        return success;
    }
    
    public static boolean deletePatients(String patientID) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            String query = "DELETE FROM patients WHERE patientID=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, patientID);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return success;
    }
    
}
