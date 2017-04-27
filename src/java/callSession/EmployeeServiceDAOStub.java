
package callSession;

import java.util.ArrayList;

/**
 *
 * @author Michael Takrama
 */
public class EmployeeServiceDAOStub implements EmployeeServiceDAO {
    
    /**
     * A list of Emergency Services
     * @return arraylist of emergency services
     */
    @Override
    public ArrayList<EmergencyService> getEmergencyServices()
    {
        ArrayList<EmergencyService> emergencyservices = new ArrayList<>();
        
        emergencyservices.add(new EmergencyService(1, "EMS 1", "Most responsive", "Mental" ));
        emergencyservices.add(new EmergencyService(2, "EMS 2", "Best in town", "Suicide" ));
        emergencyservices.add(new EmergencyService(3, "EMS 3", "Law enforcement", "Crime" ));
        
        return emergencyservices; 
    }
    
}
