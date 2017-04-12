/*
 * 
 * 
 * Robert Forbes
 */
package login;

import agent.Agent;
import java.sql.SQLException;

/**
 *
 * @author Robert Forbes
 */
public interface LoginDAO {
    Agent getAgentByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException;
}
