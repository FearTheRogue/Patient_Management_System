/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogInUsers;

/**
 *
 * @author jbridgman2
 */
public class User {
    
    private final String userID;
    private final String password;
    private final String username;
    //private final String gender;
    
    User (String userID, String password, String userName){
        this.userID = userID;
        this.password = password;
        this.username = userName;
    }
    
    //UserPatient (String userID, String password, String userName, String gender) {
    //    this.userID = userID;
    //    this.password = password;
    //    this.username = userName;
    //    this.gender = gender;
    //}
    
    String getUserID() {return userID;}
    String getPassword() {return password;}
    String getUserName() {return username;}
    //String getGender() {return gender;}
}
