/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

/**
 *
 * @author jbridgman2
 */
public class PatientManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LogInUsers.LogInScreen().setVisible(true);
        
        WriteJSONFile file = new WriteJSONFile();
        System.out.println("System written to file");
    }
}
