/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

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
    
    public void ReadInUsers() {
        
        JSONParser parser = new JSONParser();
        
        try 
        {
            Object obj = parser.parse(new FileReader("src\\JSONFiles\\Users.json"));
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
                
                if(match.find()){
                    UserID = users.substring(0,match.start());
                    Password = users.substring(match.end());
                }
                
                System.out.println("userid " + UserID);  
                System.out.println("password " + Password);
                
                
                iterator.next();
                i++;
            
            }
            
            System.out.println("All users have been read in");
            System.out.println(usersArray);
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}  
    }
}
