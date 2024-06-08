/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBSearch {
    
    Statement stmt;
    ResultSet rs;
    
    public ResultSet searchLogin(String usName) {

            try {
      stmt = DBConnection.getStatementConnection();
      String name = usName;
    //Execute the Query
    rs = stmt.executeQuery("SELECT * FROM login where username='" + name + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }

    public ResultSet searchPatients() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM patients");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchPatientsDetailsByID(String patientID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE patientID = ?");
            statement.setString(1, patientID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for patients.", e);
        }
        return resultSet;
    }

    public ResultSet searchDoctors() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM doctors");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchDoctorDetailsByID(String doctorID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors WHERE doctorID = ?");
            statement.setString(1, doctorID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for doctors.", e);
        }
        return resultSet;
    }
    
}
