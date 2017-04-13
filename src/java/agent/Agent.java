/*
 * 
 * 
 * Robert Forbes
 */
package agent;

import java.util.ArrayList;

/**
 *
 * @author Robert Forbes
 */
public class Agent {
    private int UserID;
    private String Username;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Address;
    private String City;
    private String State;
    private String ZipCode;
    private ArrayList<Role> Roles;

    public Agent() {
        this.UserID = 0;
        this.Username = "";
        this.FirstName = "";
        this.LastName = "";
        this.PhoneNumber = "";
        this.Address = "";
        this.City = "";
        this.State = "";
        this.ZipCode = "";
        this.Roles = new ArrayList<>();
    }
    
    /**
     * Constructor for an agent that takes every field as parameters
     * @param UserID
     * @param Username
     * @param FirstName
     * @param LastName
     * @param PhoneNumber
     * @param Address
     * @param City
     * @param State
     * @param ZipCode 
     */
    public Agent(int UserID, String Username, String FirstName, String LastName, String PhoneNumber, String Address, String City, String State, String ZipCode) {
        this.UserID = UserID;
        this.Username = Username;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.ZipCode = ZipCode;
    }
    
    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     * @return the ZipCode
     */
    public String getZipCode() {
        return ZipCode;
    }

    /**
     * @param ZipCode the ZipCode to set
     */
    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    /**
     * @return the Roles
     */
    public ArrayList<Role> getRoles() {
        return Roles;
    }

    /**
     * @param Roles the Roles to set
     */
    public void setRoles(ArrayList<Role> Roles) {
        this.Roles = Roles;
    }
    
    
}
