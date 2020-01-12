/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author James
 */
public class WriteJSONFile {

    public void WriteJSONFile() {
        
        JSONArray Admins = new JSONArray();
        Admins.add("A");
        Admins.add("1");

        JSONArray Secretarys = new JSONArray();
        Secretarys.add("S");
        Secretarys.add("2");
        
        JSONArray Doctors = new JSONArray();
        Doctors.add("D");
        Doctors.add("3");
        
        JSONArray Patients = new JSONArray();
        Patients.add("P");
        Patients.add("4");
        Patients.add("John Doe");
        Patients.add("Plymouth");
        Patients.add(1);
        Patients.add(30);
        
        JSONObject users = new JSONObject();
        users.put("Admins", Admins);
        users.put("Secretarys", Secretarys);
        users.put("Doctors", Doctors);
        users.put("Patients", Patients);
        
        JSONObject obj = new JSONObject();
        //obj.put(users, "Patient");
        //obj.put("name", patientName);
        //obj.put("address", patientAddress);
        
        //obj.put("Admins", Admins);
        
        //obj.put("Users", users);
        //obj.put("id", 14);
        //obj.put("name", patient_name_txt.getText());
        //obj.put("address", patient_address_txt.getText());
        //obj.put("gender", patientgender_cBox.getSelectedItem());
        //obj.put("age", patientage_cBox.getSelectedItem());
        
        //JSONArray list = new JSONArray();
        //list.add("Java");
        //list.add("dasa");
        //list.add("djiasjd");
        
        //obj.put("Courses", list);
        
        try(FileWriter file = new FileWriter("myJSON.json"))
        {
          file.write(obj.toString());
          file.flush();
        } 
        catch (IOException e)
        {
           e.printStackTrace();
        }
        
        try(FileWriter file = new FileWriter("users.json"))
        {
          file.write("Users: \n" + users.toString());
          file.flush();
        } 
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }
    
    public void AddPatient(String name, String address){
        JSONArray Patients = new JSONArray();
        Patients.add(name);
        Patients.add(address);
        
        //WriteJSONFile(null, null, null, Patients);
    }
}
