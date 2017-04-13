/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import java.util.ArrayList;

/**
 *
 * @author wolfb
 */
public class CallTypeDAO {
    
    /**
     * Retrieve a list of all callTypes
     * @return
     */
    public ArrayList<CallType> retrieveCallTypeList(){
        ArrayList<CallType> callTypes = new ArrayList<>();
        
        //Call the stored procedure
        
        
        //For now we'll send test data
        CallType type1 = new CallType("Self Harm");
        CallType type2 = new CallType("Domestic Abuse");
        CallType type3 = new CallType("Child Abuse");
        CallType type4 = new CallType("Drug Abuse");
        
        callTypes.add(type1);
        callTypes.add(type2);
        callTypes.add(type3);
        callTypes.add(type4);
        
        return callTypes;
    }
    
    
}
