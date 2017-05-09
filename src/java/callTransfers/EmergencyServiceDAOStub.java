package callTransfers;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Takrama
 */
public class EmergencyServiceDAOStub implements EmergencyServiceLogDAO {

    /**
     * A list of Emergency Services
     *
     * @return arraylist of emergency services
     */
    @Override
    public ArrayList<EmergencyRoute> getEmergencyServiceLog() {
        ArrayList<EmergencyRoute> list = new ArrayList<>();

        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();

        try {
            Connection conn = factory.getConnection(DatabaseType.MYSQL);

            CallableStatement statement = conn.prepareCall("call sp_retrieve_emergencylog");
            ResultSet resultSet = statement.executeQuery();
            int ServiceProviderId;
            int UserId;
            LocalDate TransferTime;
            String Note;
            while (resultSet.next()) {
                ServiceProviderId = resultSet.getInt(1);
                UserId = resultSet.getInt(2);
                TransferTime = resultSet.getDate(3).toLocalDate();
                Note = resultSet.getString(4);
                list.add(new EmergencyRoute(ServiceProviderId, UserId, TransferTime, Note));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmergencyServiceDAOStub.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
//        ArrayList<EmergencyService> emergencyservices = new ArrayList<>();
//        
//        emergencyservices.add(new EmergencyService(1, "EMS 1", "Most responsive", "Mental" ));
//        emergencyservices.add(new EmergencyService(2, "EMS 2", "Best in town", "Suicide" ));
//        emergencyservices.add(new EmergencyService(3, "EMS 3", "Law enforcement", "Crime" ));
//        
//        return emergencyservices; 
    }

    @Override
    public int createEmergencyServiceLogEntry(EmergencyRoute routeData) {
        int rowsAffected = 0;

        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn;
        try {
            conn = factory.getConnection(DatabaseType.MYSQL);
            CallableStatement statement = conn.prepareCall("call sp_create_new_emergencylog(?,?,?,?)");

            statement.setInt(1, routeData.getServiceProviderId());
            statement.setInt(2, routeData.getUserId());
            statement.setDate(3, java.sql.Date.valueOf(routeData.getTransferTime()));
            statement.setString(4, routeData.getNote());

            rowsAffected = statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmergencyServiceDAOStub.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowsAffected;
    }

}
