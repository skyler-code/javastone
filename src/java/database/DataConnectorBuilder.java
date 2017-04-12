/*
 * 
 * 
 * Robert Forbes
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Robert Forbes
 */
public interface DataConnectorBuilder {
    
    public Connection getConnection(String databaseName, String userName, String password) 
            throws SQLException, ClassNotFoundException, IllegalArgumentException;
    
    public Connection getConnection(String databaseUrl, String databaseName, String userName, String password) 
            throws SQLException, ClassNotFoundException , IllegalArgumentException;
    
    public Connection getConnection(String databaseUrl, Integer databasePort, String databaseName, String userName, String password) 
            throws SQLException, ClassNotFoundException, IllegalArgumentException;
}
