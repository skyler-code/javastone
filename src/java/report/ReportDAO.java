package report;

import java.util.ArrayList;
import callRecord.CallRecordDAO;
import callRecord.CallRecordDTO;
import java.sql.SQLException;

/**
 * Data Access Object class for the Report source package
 * 
 * @author Ryan Spurgetis
 */
public interface ReportDAO {
    
    /**
     * 
     * @param callTypeName
     * @return 
     * @throws java.sql.SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    ArrayList<CallRecordDTO> getCallsByCallType(String callTypeName) throws SQLException, ClassNotFoundException;
    
    /**
     * 
     * @param userId
     * @return 
     * @throws java.sql.SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    ArrayList<CallRecordDTO> getCallsByAgent(int userId) throws SQLException, ClassNotFoundException;
    
}
