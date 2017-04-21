/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caller;

/**
 *
 * @author Dan Brown
 */
public class Caller {
    
    /**
     * The unique identifier. The number the Caller is using to contact us
     */
    private String phoneNumber = "";
    
    /**
     * Any notes in reference to this Caller
     */
    private String callerNotes = "";
    
    /*
    * The Caller's first name
    */
    private String firstname = null;
    
    /**
     * The Caller's last name
     */
    private String lastname = null;
    
    public Caller(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Caller() {
        this.phoneNumber = "";
        this.callerNotes = "";
        this.firstname = "";
        this.lastname = "";
    }
    
    public Caller(String phone, String notes, String first, String last) {
        this.phoneNumber = phone;
        this.callerNotes = notes;
        this.firstname = first;
        this.lastname = last;
    }

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallerNotes() {
        return callerNotes;
    }

    public void setCallerNotes(String callerNotes) {
        this.callerNotes = callerNotes;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    
}
