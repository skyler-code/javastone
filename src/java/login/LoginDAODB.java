/*
 * 
 * 
 * Robert Forbes
 */
package login;

import agent.Agent;
import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Robert Forbes
 */
public class LoginDAODB implements LoginDAO{

    @Override
    public Agent getAgentByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        Agent agent = null;

        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();

        Connection conn = factory.getConnection(DatabaseType.MYSQL);

        CallableStatement statement = conn.prepareCall("call sp_authenticate_user(?, ?)");
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        int userId;
        String Username;
        String firstName;
        String lastName;
        String phoneNumber;
        String address;
        String city;
        String state;
        String zipCode;
        if (resultSet.next()) {
            userId = resultSet.getInt("user_id");
            Username = resultSet.getString("last_name");
            firstName = resultSet.getString("first_name");
            lastName = resultSet.getString("last_name");
            phoneNumber = resultSet.getString("phone_number");
            address = resultSet.getString("address");
            city = resultSet.getString("city");
            state = resultSet.getString("state");
            zipCode = resultSet.getString("zip_code");
            
            agent = new Agent(userId, Username, firstName, lastName,  phoneNumber, address, city, state, zipCode);
        }

        return agent;
    }
    
}
