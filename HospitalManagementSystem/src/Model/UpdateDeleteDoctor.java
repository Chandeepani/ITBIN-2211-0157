/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateDeleteDoctor {
    
    public static boolean updateDoctor(String doctorID, String fullName, 
            String specialization, String phoneNumber, String yearsOfExperience) 
            throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            
            String query = "UPDATE doctors SET doctorFullName=?, specialization=?, contactNumber=?, yearsOfExperience=? WHERE doctorID=?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fullName);
            pstmt.setString(2, specialization);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, yearsOfExperience);
            pstmt.setString(5, doctorID);
            
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
    
    public static boolean deleteDoctor(String doctorID) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            String query = "DELETE FROM doctors WHERE doctorID=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, doctorID);
            
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
