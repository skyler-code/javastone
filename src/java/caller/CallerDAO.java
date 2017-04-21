/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caller;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dan Brown
 */
public class CallerDAO {
    
    public Caller getCallerByPhone(String phoneNumber) throws SQLException, ClassNotFoundException{
        Caller caller = null;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_retrieve_caller_by_phone(?)");
        
        statement.setString(1, phoneNumber);
        
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next()){
            caller = new Caller();
            caller.setPhoneNumber(phoneNumber);
            caller.setCallerNotes(resultSet.getString(2));
            caller.setFirstname(resultSet.getString(3));
            caller.setLastname(resultSet.getString(4));
        }
        
        return caller;
    }
    
    public int createCallerRecord(String phoneNumber) throws SQLException, ClassNotFoundException{
        int rowsAffected = 0;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_create_caller(?)");
        
        statement.setString(1, phoneNumber);
        
        rowsAffected = statement.executeUpdate();        
        
        return rowsAffected;
    }
    
    public int updateCallerRecord(String phone, String notes, String firstname, String lastname) throws SQLException, ClassNotFoundException{
        int rowsAffected = 0;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_update_caller(?,?,?,?)");
        
        statement.setString(1, phone);
        statement.setString(2, notes);
        statement.setString(3, firstname);
        statement.setString(4, lastname);
        
        rowsAffected = statement.executeUpdate();
        
        
        return rowsAffected;
    }
}
