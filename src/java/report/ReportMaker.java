package report;

import callRecord.CallRecordDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 * Report Maker class for report source package
 * 
 * @author Ryan Spurgetis
 */
public class ReportMaker {

    private String reportName;

    private int callId;

    private int userId;

    private LocalDateTime callStart;

    private LocalDateTime callEnd;

    /**
     * Call Type from Clerk Reports
     */
    private String callType;
    
    /**
     * Agent ID from Clerk Reports
     */
    private String agentId;
    private int agentID;

    public ReportMaker() {
    }

    public ReportMaker(String reportName, int callId, int userId, LocalDateTime callStart, LocalDateTime callEnd, String callType) {
        this.reportName = reportName;
        this.callId = callId;
        this.userId = userId;
        this.callStart = callStart;
        this.callEnd = callEnd;
        this.callType = callType;
    }

    public void setCallType(String callTypePosted) {
        callType = callTypePosted;
        
    }
    
    public void setAgentId(String agentIdPosted){
        agentId = agentIdPosted;
        agentID = Integer.parseInt(agentId);
    }

    public List<String> getReports() {
        List<String> reportsList = new ArrayList<>();

        reportsList.add("Call type report");
        reportsList.add("Call by agent report");

        return reportsList;
    }

    public ArrayList<CallRecordDTO> getCallTypeReport() {
        ArrayList<CallRecordDTO> callTypeReport = new ArrayList<>();
        ReportDAO reportDAO = new ReportDAODB();
        try {
            callTypeReport = reportDAO.getCallsByCallType(callType);
        } catch (SQLException|ClassNotFoundException se) {
            //callTypeReport.add(new CallRecordDTO(12345, 00025, se.getMessage(), "","", LocalDateTime.now(), LocalDateTime.now()));
        }
        //callTypeReport.add(new CallRecordDTO(12345, 00025, "after try-catch", "","", LocalDateTime.now(), LocalDateTime.now()));
        return callTypeReport;
    }

    public ArrayList<CallRecordDTO> getCallAgentReport() {
        ArrayList<CallRecordDTO> callAgentReport = new ArrayList<>();
        ReportDAO reportDAO = new ReportDAODB();
        try {
            callAgentReport = reportDAO.getCallsByAgent(agentID);
        } catch (SQLException|ClassNotFoundException se){
            
        }
        return callAgentReport;
    }
}
