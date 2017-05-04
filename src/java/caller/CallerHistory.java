/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caller;

import java.time.LocalDateTime;

/**
 *
 * @author NH228U24
 */
public class CallerHistory {
    
    /**
     * The summary of the call
     */
    private String callDescription = "";
        
    /**
     * Date and time the call was answered
     */
    private LocalDateTime startTime = null;
    
    /**
     * Date and time the call was ended
     */
    private LocalDateTime endTime = null;

    public CallerHistory() {
    
    }
    
    public CallerHistory(String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.callDescription = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String getCallDescription() {
        return callDescription;
    }

    public void setCallDescription(String callDescription) {
        this.callDescription = callDescription;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    
    
    
    
}
