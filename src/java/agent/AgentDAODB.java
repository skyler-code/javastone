/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import database.DataConnectorBuilder;
import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor Algarin
 */
public class AgentDAODB implements AgentDAO {

    @Override
    public int createNewAccount(String username, String password, String fName, String lName, String phone, String address, String city, String state, String zip) throws SQLException, ClassNotFoundException {
        
        ResultSet resultSet;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_create_new_user(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, fName);
        statement.setString(4, lName);
        statement.setString(5, phone);
        statement.setString(6,address);
        statement.setString(7, city);
        statement.setString(8, state);
        statement.setString(9, zip);
        
        resultSet = statement.executeQuery();       
        int count = 0;
        
        if (resultSet.next()) {
            count = resultSet.getInt("affected");
        }
        
        return count;
    }
    
}
