/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

/**
 *
 * @author Dan Brown
 */
public class CallType {
    
    /**
     * The type of call being answered
     */
    private String call_type_name;

    public CallType(String call_type_name) {
        this.call_type_name = call_type_name;
    }
    
    /**
     * @return the call_type_name
     */
    public String getCall_type_name() {
        return call_type_name;
    }

    /**
     * @param call_type_name the call_type_name to set
     */
    public void setCall_type_name(String call_type_name) {
        this.call_type_name = call_type_name;
    }
    
    
    
}
