/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wolfb
 */
public class CallTypeDAO {
    
    /**
     * Retrieve a list of all callTypes
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<CallType> retrieveCallTypeList() throws SQLException, ClassNotFoundException{
        ArrayList<CallType> callTypes = new ArrayList<>();
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_retrieve_call_type_list");
        ResultSet resultSet = statement.executeQuery();
        
        String callTypeName;
        String description;
        
        while(resultSet.next()){
            callTypeName = resultSet.getString(1);
            description = resultSet.getString(2);
            CallType callTypeObject = new CallType(callTypeName, description);
            callTypes.add(callTypeObject);
        }
        
        
        //For now we'll send test data
//        CallType type1 = new CallType("Self Harm");
//        CallType type2 = new CallType("Domestic Abuse");
//        CallType type3 = new CallType("Child Abuse");
//        CallType type4 = new CallType("Drug Abuse");
//        
//        callTypes.add(type1);
//        callTypes.add(type2);
//        callTypes.add(type3);
//        callTypes.add(type4);
        
        return callTypes;
    }
    
    
}
