/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author James
 */
public class ReadJSONFile {

    public ReadJSONFile(int id) {
        
        JSONParser parser = new JSONParser();
        
        try 
        {
            Object obj = parser.parse(new FileReader("myJSON.json"));
            JSONObject jsonObject = (JSONObject) obj;
            id = (int)jsonObject.get("id");
            System.out.println("id is: "  + id);
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}  
    }
}
