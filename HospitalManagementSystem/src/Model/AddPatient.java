/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;

public class AddPatient {
    Statement stmt;
    
    public void Patients(String patientID, String patientName, String dob, 
        String contactNumber, String medicalHistory)
    {
        try{
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate
            ("INSERT INTO patients (patientID, name, dateofbirth, contactNumber, "
                    + "medicalHistory) VALUES('"+ patientID +"', '"
                    + patientName +"', '"+ dob +"', '"+ contactNumber +"', '"
                    + medicalHistory +"')");
            System.out.println("Patient Record added Successfull");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
