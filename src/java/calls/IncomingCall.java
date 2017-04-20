/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calls;

/**
 *
 * @author nh228u24
 */
public class IncomingCall {
    
    /**
     * Number of the phone calling the call center
     */
    private String PhoneNumber = "";

    public IncomingCall(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public IncomingCall() {
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    
}
