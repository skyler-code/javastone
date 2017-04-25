/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

/**
 *
 * @author Victor Algarin
 */
public interface AgentDAO {
    
    public int createNewAccount(String username, String fName, String lName, String phone, String address, String city, String state, String zip );
    
}
