/*
* Dan Brown
*/
package callRecord;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dan Brown
 */
public class CallRecordHandler extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        int agentId = Integer.parseInt(request.getParameter("agentId"));
        String phoneNumber = request.getParameter("callerPhone");
        String callDescription = request.getParameter("callDescription");
        String callTypeName = request.getParameter("callTypeName");
        LocalDateTime startTime = LocalDateTime.parse(request.getParameter("startTime"));
        
        String nextLocation = "/logCall.jsp";
        String logCallMessage = "";
        
        if(1 > agentId || phoneNumber.equals("") || phoneNumber == null || callDescription == null || callTypeName == null || callTypeName.equalsIgnoreCase("select") || callDescription.equals("")){
            logCallMessage = "Please ensure all fields are filled out";
        } else {
            CallRecordDTO callRecord = new CallRecordDTO();
                //callRecord.setCall_Id(callId);
                callRecord.setAgent_id(agentId);
                callRecord.setCaller_Id(phoneNumber);
                callRecord.setCall_description(callDescription);
                callRecord.setCall_type_name(callTypeName);
                callRecord.setStart_time(startTime);
            
            try{
                int rowsAffected = CallRecordDAO.SubmitCallRecord(callRecord);
                if(rowsAffected != 0) {
                    nextLocation = "/logCall.jsp";
                    logCallMessage = "Call Record Submitted Successfully.";
                } else {
                    nextLocation = "/logCall.jsp";
                    logCallMessage = "There was an error logging the call. Please try again.";
                }
            } catch(SQLException | ClassNotFoundException ex) {
                logCallMessage = "The phone number entered does not refer to a valid caller phone in the database.";
            }
        }
        session.setAttribute("logCallMessage", logCallMessage);
        
        // Redirect things back to the JSP specified in the logic above
        request.getRequestDispatcher(nextLocation).forward(request, response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}