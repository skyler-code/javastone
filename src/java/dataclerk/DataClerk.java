/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclerk;

import agent.Role;
import java.util.ArrayList;

/**
 *
 * @author NH228U23
 */
public class DataClerk {
    /**
     * The data clerk's user id
     */
    private int userId;
    
    /**
     * The data clerk's username
     */
    private String username;
    
    /**
     * The data clerk's first name
     */
    private String firstName;
    
    /**
     * The data clerk's lastName
     */
    private String lastName;
    
    /**
     * The data clerk's phone number
     */
    private String phoneNumber;
    
    /**
     * The data clerk's address
     */
    private String address;
    
    /**
     * The data clerk's city
     */
    private String city;
    
    /**
     * The data clerk's state
     */
    private String state;
    
    /**
     * The data clerk's zip code
     */
    private String zipCode;
    
    /**
     * The role of data Clerk
     */
    private ArrayList<Role> roles;

    public DataClerk() {
        this.userId = 0;
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.roles = new ArrayList<>();
    }
    
    

    public DataClerk(int userId, String username, String firstName, String lastName, String phoneNumber, String address, String city, String state, String zipCode, ArrayList<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.roles = roles;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the roles
     */
    public ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
    
    
}
