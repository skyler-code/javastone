/*
 * 
 * 
 * Robert Forbes
 */
package login;

import agent.Agent;
import agent.Role;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Robert Forbes
 */
public interface LoginDAO {
    Agent getAgentByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException;
    ArrayList<Role> RetrieveUsersRoles(int userID) throws SQLException, ClassNotFoundException;
    boolean UpdatePassword(int userID, String oldPassword, String newPassword)throws SQLException, ClassNotFoundException;
}
