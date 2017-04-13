/*
 * 
 * 
 * Robert Forbes
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Robert Forbes
 */
public class DatabaseConnectionFactory {
    private final String databaseUrl;
    private final int databasePort;
    private final String databaseName;
    private final String userName;
    private final String password;
    
    private static DatabaseConnectionFactory instance;
    
    public static DatabaseConnectionFactory getInstance() {
        if(null == instance) {
            instance = new DatabaseConnectionFactory();
        }
        return instance;
    }
    
    private DatabaseConnectionFactory() {
        String bundleName = "database.DatabaseConnectionValues";
        ResourceBundle values = ResourceBundle.getBundle(bundleName, Locale.ENGLISH);
        this.databaseUrl = values.getString("databaseUrl");
        // Get the port, but throw the exception if it is not a number
        this.databasePort = Integer.parseInt(values.getString("databasePort"));
        this.databaseName = values.getString("databaseName");
        this.userName = values.getString("username");
        this.password = values.getString("password");
    }
    
    public Connection getConnection(DatabaseType databaseType) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        switch(databaseType) {
            case MYSQL:
                DataConnectorBuilderMySQL builder = new DataConnectorBuilderMySQL();
                conn = builder.getConnection(this.databaseUrl, this.databasePort
                        , this.databaseName, this.userName, this.password);
            break;
        }
        return conn;
    }
}
