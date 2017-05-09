
package callTransfers;

import java.util.ArrayList;

/**
 *
 * @author Michael Takrama
 */
public interface EmergencyServiceLogDAO {
    ArrayList<EmergencyRoute> getEmergencyServiceLog();
    
    int createEmergencyServiceLogEntry(EmergencyRoute RouteData);
}
