/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import callRecord.CallType;
import java.util.ArrayList;

/**
 *
 * @author Dan Brown
 */
public class CallTypeList {
    
    ArrayList<CallType> callTypeList = null;

    public CallTypeList() {
        callTypeList = new ArrayList<>();
    }
    
    public CallTypeList(ArrayList<CallType> list) {
        callTypeList = list;
    }

    public ArrayList<CallType> getCallTypeList() {
        return callTypeList;
    }

    public void setCallTypeList(ArrayList<CallType> callTypeList) {
        this.callTypeList = callTypeList;
    }
    
    
}
