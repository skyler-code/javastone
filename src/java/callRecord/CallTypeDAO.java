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
 * @author Dan Brown
 */
public class CallTypeDAO {
    
    /**
     * @author Dan Brown
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
        
        return callTypes;
    }
    
    
}
