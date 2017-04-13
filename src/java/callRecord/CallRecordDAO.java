/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Dan Brown
 */
public class CallRecordDAO {
    
    /**
     * Retrieve a list of all call types
     * @return
     */
    public ArrayList<CallRecordDTO> getListCallRecords(){
        
        ArrayList<CallRecordDTO> callRecords = new ArrayList<>();
        
        //Code to retrieve list of all call types from the db
        
        return callRecords;
    }
    
    /**
     * 
     * Retrieve calls that are still ongoing (no end time)
     * @author Ethan Jorgensen
     */
    public static ArrayList<CallRecordDTO> getOngoingCalls() {
        ArrayList<CallRecordDTO> calls = new ArrayList<>();
        
        // todo query database for any call with non-null start and null end
        
        // int callId, int agentId, String callDescription, String callTypeName, LocalDateTime startTime, LocalDateTime endTime
        calls.add(new CallRecordDTO(100001, 100001, "Test Call", "Test", LocalDateTime.now(), null));
        calls.add(new CallRecordDTO(100002, 100001, "Test Call", "Test", LocalDateTime.now(), null));
        calls.add(new CallRecordDTO(100003, 100002, "Test Call", "Test", LocalDateTime.now(), null));
        calls.add(new CallRecordDTO(100004, 100002, "Test Call", "Test", LocalDateTime.now(), null));
        calls.add(new CallRecordDTO(100005, 100004, "Test Call", "Test", LocalDateTime.now(), null));
        
        return calls;
    }
    
    
}
