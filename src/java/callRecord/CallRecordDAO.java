/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import database.DatabaseConnectionFactory;
import database.DatabaseType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dan Brown
 */
public class CallRecordDAO {
    
    /**
     * Retrieve a list of all call types
     * @return
     */
    public ArrayList<CallRecordDTO> getListCallRecords() throws SQLException {
        
        ArrayList<CallRecordDTO> callRecords = new ArrayList<>();
        
        //Code to retrieve list of all call types from the db
        
        return callRecords;
    }
    
    /**
     * 
     * Retrieve calls that are still ongoing (no end time)
     * @author Ethan Jorgensen
     * @return 
     */
    public static ArrayList<CallRecordDTO> getOngoingCalls() {
        ArrayList<CallRecordDTO> calls = new ArrayList<>();
        
        Random rng = new Random();
        
        // would query database for any call with non-null start and null end
        // but this would make it really long when we demonstrate
        
        // int callId, int agentId, String callDescription, String callTypeName, LocalDateTime startTime, LocalDateTime endTime
        calls.add(new CallRecordDTO(100001, 100001, "100001", "In Progress", "Test", LocalDateTime.now()
                .minus(rng.nextInt(8),  ChronoUnit.MINUTES).minus(rng.nextInt(60), ChronoUnit.SECONDS), null));
        calls.add(new CallRecordDTO(100002, 100001, "100002", "In Progress", "Test", LocalDateTime.now()
                .minus(rng.nextInt(12), ChronoUnit.MINUTES).minus(rng.nextInt(60), ChronoUnit.SECONDS), null));
        calls.add(new CallRecordDTO(100003, 100002, "100003", "In Progress", "Test", LocalDateTime.now()
                .minus(rng.nextInt(16), ChronoUnit.MINUTES).minus(rng.nextInt(60), ChronoUnit.SECONDS), null));
        calls.add(new CallRecordDTO(100004, 100002, "100004", "In Progress", "Test", LocalDateTime.now()
                .minus(rng.nextInt(2),  ChronoUnit.MINUTES).minus(rng.nextInt(60), ChronoUnit.SECONDS), null));
        calls.add(new CallRecordDTO(100005, 100004, "100005", "In Progress", "Test", LocalDateTime.now()
                .minus(rng.nextInt(4),  ChronoUnit.MINUTES).minus(rng.nextInt(60), ChronoUnit.SECONDS), null));
        
        return calls;
    }
    
    /**
     * @author Dan Brown
     * Submits a single call record to the database
     * 
     * @param record
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static int SubmitCallRecord(CallRecordDTO record) throws SQLException, ClassNotFoundException{
        int rowsAffected = 0;
        
        //Call the stored procedure
        DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
        Connection conn = factory.getConnection(DatabaseType.MYSQL);
        CallableStatement statement = conn.prepareCall("call sp_create_call_record(?,?,?,?,?)");
    
        // Set the paraments
        statement.setInt(1, record.getAgent_id());
        statement.setString(2, record.getCall_description());
        statement.setString(3, record.getCall_type_name());
        statement.setString(4, record.getCaller_Id());
        statement.setTimestamp(5, Timestamp.valueOf(record.getStart_time()));
        rowsAffected = statement.executeUpdate();
        System.out.println(rowsAffected);
        
        
        return rowsAffected;
    }
}
