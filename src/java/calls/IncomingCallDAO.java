/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calls;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dan Brown
 */
public class IncomingCallDAO {
    
    /**
     * Get a list of all incoming calls to the call center
     * @return 
     * @throws java.sql.SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    public ArrayList<IncomingCall> getIncomingCalls() throws SQLException, ClassNotFoundException{
        ArrayList<IncomingCall> callList = new ArrayList<>();
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_retrieve_calls");
        
        
        ResultSet results = statement.executeQuery();
        
        while(results.next()){
            IncomingCall call = new IncomingCall();
            call.setPhoneNumber(results.getString(1));
            callList.add(call);
        }
        
        
        return callList;
    }
    
    public boolean removeIncomingCall(String phoneNumber) throws SQLException, ClassNotFoundException {
        
        boolean result = false;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_remove_incoming_call(?)");
        statement.setString(1, phoneNumber);
        
        int rowsAffected = statement.executeUpdate();
        if(rowsAffected > 0){
            result = true;
        }
        
        return result;
    }
    
}
