/*
 * 
 * 
 * Robert Forbes
 */
package login;

import agent.Agent;
import agent.Role;
import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAODB implements LoginDAO {

    /**
     * @author Robbie Forbes
     * @param username
     * @param password
     * @return Agent
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
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
            Username = resultSet.getString("username");
            firstName = resultSet.getString("first_name");
            lastName = resultSet.getString("last_name");
            phoneNumber = resultSet.getString("phone_number");
            address = resultSet.getString("address");
            city = resultSet.getString("city");
            state = resultSet.getString("state");
            zipCode = resultSet.getString("zip_code");

            agent = new Agent(userId, Username, firstName, lastName, phoneNumber, address, city, state, zipCode);
        }

        return agent;
    }

    /**
     * @author Skyler Hiscock
     * @param userID
     * @return List of Roles
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<Role> RetrieveUsersRoles(int userID) throws SQLException, ClassNotFoundException {
        ArrayList<Role> roles = new ArrayList<>();
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();

        Connection conn = factory.getConnection(DatabaseType.MYSQL);

        CallableStatement statement = conn.prepareCall("call sp_retrieve_users_roles(?)");
        statement.setInt(1, userID);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            switch (resultSet.getString("role_name")) {
                case "Administrator":
                    roles.add(Role.ADMINISTRATOR);
                    break;
                case "DataClerk":
                    roles.add(Role.DATACLERK);
                    break;
                case "Agent":
                    roles.add(Role.AGENT);
                    break;
                default:
                    break;
            }
        }
        return roles;
    }

    
    /**
     * Robert Forbes
     * 2017/04/25
     * @param userID
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public boolean UpdatePassword(int userID, String oldPassword, String newPassword) throws SQLException, ClassNotFoundException {
        int rowsAffected = 0;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_update_user_password(?,?,?)");
    
        // Set the paraments
        statement.setInt(1, userID);
        statement.setString(2, oldPassword);
        statement.setString(3, newPassword);
        rowsAffected = statement.executeUpdate();
        
        
        return rowsAffected >= 1;
    }

}
