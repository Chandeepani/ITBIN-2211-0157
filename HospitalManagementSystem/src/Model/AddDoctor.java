/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;

public class AddDoctor {
    Statement stmt;

    public void addDoctor(String doctorID, String fullName, String specialization, 
        String phoneNumber, String yearsOfExperience) {
        try {
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate(
                "INSERT INTO doctors (doctorID, doctorFullName, specialization, contactNumber, "
                        + "yearsOfExperience) VALUES('"+ doctorID + "', '"
                        + fullName + "', '"+ specialization + "', '"+ phoneNumber + "', '"
                + yearsOfExperience + "')"
            );
        System.out.println("doctor Record added Successfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
