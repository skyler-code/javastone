/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import callRecord.CallType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dan Brown
 */
public class CallTypeList {
    
    ArrayList<CallType> callTypeList = null;

    public CallTypeList() throws SQLException, ClassNotFoundException {
        CallTypeDAO callTypeDAO = new CallTypeDAO();
        this.callTypeList = callTypeDAO.retrieveCallTypeList();
    }

    public ArrayList<CallType> getCallTypeList() {
        return callTypeList;
    }
    
    
}
