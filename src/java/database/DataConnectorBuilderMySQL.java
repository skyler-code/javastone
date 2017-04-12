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
public class DataConnectorBuilderMySQL implements DataConnectorBuilder{

    @Override
    public Connection getConnection(String databaseName, String userName, String password) throws SQLException, ClassNotFoundException, IllegalArgumentException {
        return this.getConnection("localhost", 3306, databaseName, userName, password);
    }

    @Override
    public Connection getConnection(String databaseUrl, String databaseName, String userName, String password) throws SQLException, ClassNotFoundException, IllegalArgumentException {
        return this.getConnection(databaseUrl, 3306, databaseName, userName, password);
    }

    @Override
    public Connection getConnection(String databaseUrl, Integer databasePort, String databaseName, String userName, String password) throws SQLException, ClassNotFoundException, IllegalArgumentException {
        Connection conn;
        Class.forName("com.mysql.jdbc.Driver");
        String connString = "jdbc:mysql://" 
                + databaseUrl
                + ":"
                + databasePort
                + "/"
                + databaseName
                + "?useSSL=false"
                + "&noAccessToProcedureBodies=true"
                + "&user="
                + userName
                + "&password="
                + password;
        conn = DriverManager.getConnection(connString);
        return conn;
    }
    
}
