/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import LogInUsers.User_Doctor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author James
 */
public class ReadJSONFile {
    public String users;
    public String UserID;
    public String Password;
    //private boolean isUser = false;
    
    public boolean ReadInUsers(String id, String pw) {
        
        JSONParser parser = new JSONParser();
        
        try 
        {
            Object obj = parser.parse(new FileReader("src\\JSONFiles\\RolesSystem.json"));
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray usersArray = (JSONArray) jsonObject.get("users");
            Iterator<String> iterator = usersArray.iterator();
            
            //String id = (String) jsonObject.get("id");
           //System.out.println("id is: "  + id);
            //String pass = (String) jsonObject.get("pass");
            //System.out.println("password is: " + pass);

            int i = 0;
            while(iterator.hasNext()){
                
                users = (String)usersArray.get(i);
                
                Pattern pat = Pattern.compile(", *");
                Matcher match = pat.matcher(users);
                
                //System.out.println(i + " " + users);
                
                if(match.find()){
                    UserID = users.substring(0,match.start());
                    Password = users.substring(match.end());
                }
                
                if(UserID.equals(id) && Password.equals(pw)){
                    System.out.println("Account " + UserID + " Has the password " + Password);
                    return true;
                } 
                
                //System.out.println("userid " + UserID);  
                //System.out.println("password " + Password);
                
                iterator.next();
                i++;
                
            }
            
            //System.out.println("All users have been read in");
            //System.out.println(usersArray);
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}
        return false;  
    }
    
        public void ReadInPatientsDetails(){
        String pUserID = null;
        String pUsername = null;
        String pAddress = null;
        String Gender = null;
        String Age = null;
        
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader("src\\JSONFiles\\UserDetails.json"));
            JSONObject jsonObject = (JSONObject)obj;
            
            JSONArray patientsArray = (JSONArray) jsonObject.get("Patients");
            Iterator<String> iterator = patientsArray.iterator();
            
            int i = 0;
            while(iterator.hasNext()){
                String details = (String)patientsArray.get(i);
                
                //System.out.println(details);
                
                Pattern pat = Pattern.compile(",,,,*");
                Matcher match = pat.matcher(details);
                
                //System.out.println(pat.match(details));
                
                if(match.find()){
                    pUserID = details.substring(0, match.start());
                    pUsername = details.substring(match.end());
                    pAddress = details.substring(match.end());
                    //Gender = details.
                }
                
                
                System.out.println("User: " + pUserID);
                System.out.println("Username: " + pUsername);
                System.out.println("Address: " + pAddress);
                System.out.println("Gender: " + Gender);
                System.out.println("Age: " + Age);
                
                //System.out.println(details);
                iterator.next();
                i++;
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}
    }
        
    public void ReadInDoctorsDetails(String ID, String Name, String Address){
        String dUserID = null;
        String dUsername = null;
        String dAddress = null;
        
        JSONParser parser = new JSONParser();
        
        try {
            //Object obj = parser.parse(new FileReader("src\\JSONFiles\\UserDetails.json"));
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader("src\\\\JSONFiles\\\\UserDetails.json"));
            
            JSONArray doctorsArray = (JSONArray) jsonObject.get("Doctors");
            Iterator<String> iterator = doctorsArray.iterator();
            
            System.out.println(doctorsArray);
            
            int i = 0;
            while(iterator.hasNext()){
                String id = (String)doctorsArray.get(i);
                String name = (String)doctorsArray.get(i);
                String address = (String)doctorsArray.get(i);
                
                
                //System.out.println(details);
                
                //Pattern pat = Pattern.compile(",,*");
                //Matcher match = pat.matcher(details);
                
                //System.out.println(pat.matcher(details));
                
                //if(match.find()){
                   // dUserID = details.substring(0, match.start());
                   // dUsername = details.substring(match.end());
                    //dAddress = details.substring(match.end());
                //}
                System.out.println("user " + i);
                id = iterator.next();
                name = iterator.next();
                address = iterator.next();
                
                System.out.println("id " + id);
                System.out.println("name " + name);
                System.out.println("address " + address);
                
                if(id.equals(ID)){
                    System.out.println("doctor id " + ID);
                    Name = name;
                    Address = address;
                    
                    return;
                }
                
                //System.out.println("id " +jsonObject.get("ID"));
                //System.out.println(jsonObject.get("Username"));
                //System.out.println(jsonObject.get("Address"));
                
                //System.out.println("User: " + dUserID);
                //System.out.println("Username: " + dUsername);
                //System.out.println("Address: " + dAddress);
                
                //System.out.println(details);
                //iterator.next();
                i++;
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}
    }
}
