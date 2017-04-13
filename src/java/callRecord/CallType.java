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
    private String callTypeName;
    
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public CallType(String call_type_name, String description) {
        this.callTypeName = call_type_name;
        this.description = description;
    }
    
    /**
     * @return the callTypeName
     */
    public String getCallTypeName() {
        return callTypeName;
    }

    /**
     * @param callTypeName the callTypeName to set
     */
    public void setCallTypeName(String callTypeName) {
        this.callTypeName = callTypeName;
    }
    
    
    
}
