/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UpdateDeletePatients;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PatientsController {
    
public static void Patients(String patientID, String patientName, String dob, 
        String contactNumber, String medicalHistory) {
    new Model.AddPatient().Patients(patientID, patientName, dob, contactNumber, 
            medicalHistory);
    JOptionPane.showMessageDialog(null, "New Record has been inserted", 
            "Successfull", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean updatePatient(String patientID, String patientName, String dob, 
        String contactNumber, String medicalHistory) throws SQLException {
            boolean success = false;
            success = UpdateDeletePatients.updatePatient(patientID, patientName, dob, contactNumber, 
            medicalHistory);
            return success;
        }
    
    public static boolean deletePatients(String patientID) throws SQLException {
        boolean success = false;
        success = UpdateDeletePatients.deletePatients(patientID);
        return success;
    }
    
}
