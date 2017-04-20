/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calls;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nh228u24
 */
public class IncomingCallList {
    
    ArrayList<IncomingCall> incomingCallList = null;

    public IncomingCallList() throws SQLException, ClassNotFoundException {
        IncomingCallDAO incomingCallDao = new IncomingCallDAO();
        incomingCallList = incomingCallDao.getIncomingCalls();
    }

    public ArrayList<IncomingCall> getIncomingCallList() {
        return incomingCallList;
    }

    public void setIncomingCallList(ArrayList<IncomingCall> incomingCallList) {
        this.incomingCallList = incomingCallList;
    }
    
    
    
    
}
