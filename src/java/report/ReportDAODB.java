package report;

import callRecord.CallRecordDTO;
import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object Database class for the Report source package
 * 
 * @author Ryan Spurgetis
 */
public class ReportDAODB implements ReportDAO {

    @Override
    public ArrayList<CallRecordDTO> getCallsByCallType(String callTypeName) throws SQLException, ClassNotFoundException{
        ArrayList<CallRecordDTO> callList = new ArrayList<>();
        
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        
//        try {
            Connection conn = factory.getConnection(DatabaseType.MYSQL);
            
            CallableStatement statement = conn.prepareCall("call sp_retrieve_report_calls_by_call_type(?)");
            statement.setString(1, callTypeName);
            ResultSet resultSet = statement.executeQuery();
            int callId;
            int agentId;
            String callerId;
            String callDescription;
            String callType;
            Date startDate;
            java.sql.Time recordStartTime;
            java.sql.Date recordStartDate;
            java.sql.Time recordEndTime;
            java.sql.Date recordEndDate;
            LocalDateTime startTime;
            LocalDateTime endTime;
            while(resultSet.next()){
                callId = resultSet.getInt("Call_ID");
                agentId = resultSet.getInt("User_ID");
                callerId = resultSet.getString("Caller_Phone");
                callDescription = resultSet.getString("Call_Description");
                callType = resultSet.getString("Call_Type_Name");
                recordStartTime = resultSet.getTime("Start_Time");
                recordStartDate = resultSet.getDate("Start_Time");
                startTime = LocalDateTime.parse(recordStartDate + "T" + recordStartTime);
                recordEndTime = resultSet.getTime("End_Time");
                recordEndDate = resultSet.getDate("End_Time");
                endTime = LocalDateTime.parse(recordEndDate + "T" + recordEndTime);
                callList.add(new CallRecordDTO(callId, agentId, callerId, callDescription, callType, startTime, endTime));
            }
            
//        } catch (SQLException ex) {
//            Logger.getLogger(ReportDAODB.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ReportDAODB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        return callList;
    }

    @Override
    public ArrayList<CallRecordDTO> getCallsByAgent(int userId) throws SQLException, ClassNotFoundException{
        ArrayList<CallRecordDTO> callList = new ArrayList<>();
        
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        
        try {
            Connection conn = factory.getConnection(DatabaseType.MYSQL);
            
            CallableStatement statement = conn.prepareCall("call sp_retrieve_report_calls_by_agent(userId)");
            ResultSet resultSet = statement.executeQuery();
            int callId;
            int agentId;
            String callerId;
            String callDescription;
            String callType;
            Date startDate;
            java.sql.Time recordStartTime;
            java.sql.Date recordStartDate;
            java.sql.Time recordEndTime;
            java.sql.Date recordEndDate;
            LocalDateTime startTime;
            LocalDateTime endTime;
            while(resultSet.next()){
                callId = resultSet.getInt("Call_ID");
                agentId = resultSet.getInt("User_ID");
                callerId = resultSet.getString("Caller_Phone");
                callDescription = resultSet.getString("Call_Description");
                callType = resultSet.getString("Call_Type_Name");
                recordStartTime = resultSet.getTime("Start_Time");
                recordStartDate = resultSet.getDate("Start_Time");
                startTime = LocalDateTime.parse(recordStartDate + "T" + recordStartTime);
                recordEndTime = resultSet.getTime("End_Time");
                recordEndDate = resultSet.getDate("End_Time");
                endTime = LocalDateTime.parse(recordEndDate + "T" + recordEndTime);
                callList.add(new CallRecordDTO(callId, agentId, callerId, callDescription, callType, startTime, endTime));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return callList;
    }
    
}
