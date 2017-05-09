/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caller;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author NH228U24
 */
public class HistoryBean {
 
    ArrayList<CallerHistory> history;
    
    String errorMessage;
    
    String callerNumber = "";
    
    public HistoryBean() {
        history = new ArrayList<>();
    }

    public ArrayList<CallerHistory> getHistory() {
        ArrayList<CallerHistory> callerHistory = new ArrayList<>();
        try{
            CallerDAO dao = new CallerDAO();
            history = dao.retrieveCallerHistory(callerNumber);
        }catch(Exception ex){
            history = callerHistory;
            errorMessage = ex.getMessage();
        }
        
        return history;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }
    
    public void setHistory(ArrayList<CallerHistory> history) {
        this.history = history;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCallerNumber() {
        return callerNumber;
    }
    
    
    
    
    
}
