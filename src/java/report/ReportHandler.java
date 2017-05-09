package report;

import callRecord.CallRecordDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Request handler class for the Report source package
 * 
 * @author Ryan Spurgetis
 */
@WebServlet(name = "ReportHandler", urlPatterns = {"/ReportHandler"})
public class ReportHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String task = request.getParameter("reportType");
        String nextLocation = "/clerk/reportMaker.jsp";

        String reportType;

        //String callTypeName;
        int agentId;
        String agentIdStr;
        ReportDAO reportDAO;
        ReportMaker reportMaker;
        ArrayList<CallRecordDTO> reportList;

        if (task == null) {
            task = "";
        }
        switch (task) {

            case "Call type report":
                nextLocation = "clerk/reports/callType.jsp";
                String postedCallType = request.getParameter("callTypeName");
                if (null == postedCallType) {
                    postedCallType = ""; // first visit, just redirect to page
                    nextLocation = "clerk/reports/callType.jsp";
                } else { // form submitted, get the data
                    nextLocation = "clerk/reports/callType.jsp";
                    reportMaker = new ReportMaker();
                    reportMaker.setCallType(postedCallType);
                    reportList = reportMaker.getCallTypeReport();
                    session.removeAttribute(postedCallType);
                    session.setAttribute("reportBean", reportMaker);
                    nextLocation = "clerk/reports/callType.jsp";
                }
//            case "Call by agent report":
//                nextLocation = "clerk/reports/callAgent.jsp";
//                String postedAgentId = request.getParameter("agentId");
//                if (null == postedAgentId) {
//                    postedCallType = ""; // first visit, just redirect to page
//                    nextLocation = "clerk/reports/callAgent.jsp";
//                } else {
//                    nextLocation = "clerk/reports/callAgent.jsp";
//                    reportMaker = new ReportMaker();
//                    reportMaker.setAgentId(postedAgentId);
//                    reportList = reportMaker.getCallAgentReport();
//                    session.removeAttribute(postedAgentId);
//                    session.setAttribute("reportBean", reportMaker);
//                    nextLocation = "clerk/reports/callAgent.jsp";
//                }
        }

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
