/*
 * 
 * 
 * Robert Forbes
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Robert Forbes
 */
public class DatabaseConnectionBuilderMySQL {
    public static final String DEFAULT_URL = "localhost";
    
    public static final int DEFAULT_PORT = 3306;
    
    public static Connection getConnection(String databaseName, String userName
                                    , String password) throws SQLException
                                    , ClassNotFoundException
                                    , IllegalArgumentException {
        return getConnection(DEFAULT_URL, DEFAULT_PORT, databaseName
                            , userName, password);
    }
    
    
    public static Connection getConnection(String databaseUrl, String databaseName
                                    , String userName, String password) 
                                      throws SQLException
                                    , ClassNotFoundException
                                    , IllegalArgumentException {
        return getConnection(databaseUrl, DEFAULT_PORT, databaseName
                            , userName, password);
    }
    
    
    public static Connection getConnection(String databaseUrl, Integer databasePort, String databaseName, String userName, String password) 
            throws SQLException, ClassNotFoundException, IllegalArgumentException {
        String connectionString = "jdbc:mysql://" + databaseUrl + ":" 
                + databasePort
                + "/" + databaseName 
                + "?useSSL=false"
                +"&user=" + userName + "&password="
                + password;
        
        return DriverManager.getConnection(connectionString);
    }
}
