/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UpdateDeleteDoctor;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DoctorsController {
    
    public static void Doctors(String doctorID, String fullName, String specialization, 
        String phoneNumber, String yearsOfExperience) {
    new Model.AddDoctor().addDoctor(doctorID, fullName, specialization, phoneNumber, yearsOfExperience);
    JOptionPane.showMessageDialog(null, "New Record has been inserted", 
            "Successfull", JOptionPane.INFORMATION_MESSAGE);
    }    
    
    public static boolean updateDoctor(String doctorID, String fullName, 
            String specialization, String phoneNumber, String yearsOfExperience) {
        boolean success = false;
        try {
            success = UpdateDeleteDoctor.updateDoctor(doctorID, fullName, specialization, 
                    phoneNumber, yearsOfExperience);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }
    
    public static boolean deleteDoctor(String doctorID) throws SQLException {
        boolean success = false;
        success = UpdateDeleteDoctor.deleteDoctor(doctorID);
        return success;
    }
    
}  
