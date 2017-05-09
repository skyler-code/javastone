/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import agent.AgentDAODB;
import callRecord.CallType;
import callRecord.CallTypeDAO;
import callTransfers.EmergencyRoute;
import caller.Caller;
import caller.CallerDAO;
import caller.CallerHistory;
import caller.HistoryBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import serviceProviders.ServiceProviderDAO;
import serviceProviders.ServiceCategory;
import serviceProviders.ServiceCategoryList;
import serviceProviders.ServiceProvider;
import serviceProviders.ServiceProviderList;

/**
 *
 * @author Skyler Hiscock
 */
public class RequestHandler extends HttpServlet {

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
        String nextLocation = null;

        String nextLocationChoice = request.getParameter("task");

        switch (nextLocationChoice) {
            case "logCall":
                nextLocation = "/logCall.jsp";
                String phoneNumber = request.getParameter("caller_phone");

                // See if caller is already in the database. If not add, otherwise populate call log jsp
                Caller caller = null;
                try {
                    CallerDAO callerDAO = new CallerDAO();
                    caller = callerDAO.getCallerByPhone(phoneNumber);
                    if (caller == null) { //Caller does not exist in database. Create one now
                        callerDAO.createCallerRecord(phoneNumber);
                        caller = callerDAO.getCallerByPhone(phoneNumber);
                    }
                    session.setAttribute("caller", caller);
                } catch (Exception ex) {
                    nextLocation = "Oopsies!";
                    System.out.println(ex.getMessage());
                }

                break;
            case "dataClerkMain":
                nextLocation = "/dataClerkMain.jsp";
                break;
            case "viewCallerHistory":
                try {

                    nextLocation = "/callerHistory.jsp";
                    String callerNumber = request.getParameter("caller_phone");

                    HistoryBean historyBean = new HistoryBean();
                    historyBean.setCallerNumber(callerNumber);

                    session.setAttribute("history", historyBean);

                } catch (Exception ex) {

                }

                break;
            case "emergencyService":
                EmergencyRoute emergencyService = new EmergencyRoute();
                session.removeAttribute("emergencyService");
                session.setAttribute("emergencyService", emergencyService);
                nextLocation = "/emergencyservices.jsp";
                break;
            default:
                nextLocation = "/index.jsp";
        }

        // Redirect things back to the JSP specified in the switch statement
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
