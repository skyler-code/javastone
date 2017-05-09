/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callTransfers;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Michael Takrama
 * 04/27/2017
 */
public class EmergencyRoute {

    /**
     * Service Provider ID
     */
    private int ServiceProviderId;
    
    /**
     * User Id of initiator of route
     */
    private int UserId;
    
    /**
     * Transfer Time
     */
    private LocalDate TransferTime;
    
    /**
     * Note
     */
    private String Note;
    
    /**
     * Emergency Log
     */
    private ArrayList<EmergencyRoute> EmergencyRouteLog;
    


    /**
     * Full constructor
     * @param serviceId
     * @param userId
     * @param transferTime
     * @param note 
     */
    public EmergencyRoute(int serviceId, int userId, LocalDate transferTime, String note) {
        this.ServiceProviderId = serviceId;
        this.UserId = userId;
        this.TransferTime = transferTime;
        this.Note = note;
    }

    /**
     * Parameterless constructor
     */
    public EmergencyRoute() {
        this.ServiceProviderId = 0;
        this.UserId = 0;
        this.TransferTime = null;
        this.Note = "";
    }

    /**
     * @return the ServiceProviderId
     */
    public int getServiceProviderId() {
        return ServiceProviderId;
    }

    /**
     * @param ServiceProviderId the ServiceProviderId to set
     */
    public void setServiceProviderId(int ServiceProviderId) {
        this.ServiceProviderId = ServiceProviderId;
    }

    /**
     * @return the UserId
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * @param UserId the UserId to set
     */
    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    /**
     * @return the TransferTime
     */
    public LocalDate getTransferTime() {
        return TransferTime;
    }

    /**
     * @param TransferTime the TransferTime to set
     */
    public void setTransferTime(LocalDate TransferTime) {
        this.TransferTime = TransferTime;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return the EmergencyRoute
     */
    public ArrayList<EmergencyRoute> getEmergencyRouteLog() {
        EmergencyServiceLogDAO dao = new EmergencyServiceDAOStub();
        if ( null != dao) {
            return dao.getEmergencyServiceLog();
        }
        return null;
    }

    /**
     * @param EmergencyRoute the EmergencyRoute to set
     */
    public void setEmergencyRouteLog(ArrayList<EmergencyRoute> EmergencyRoute) {
        this.EmergencyRouteLog = EmergencyRoute;
    }
    

 
    /**
     * List of emergency services
     * @return the emergencyServices
     */
//    public ArrayList<EmergencyRoute> getEmergencyServices() {
//        if ( null == emergencyServices)
//        {
//            EmergencyServiceDAO dao = new EmergencyServiceDAOStub();
//            this.emergencyServices = dao.getEmergencyServiceLog();
//        }
//        return emergencyServices;
//    }

}
