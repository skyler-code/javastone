/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import agent.Agent;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robert Forbes
 */
public class UpdatePasswordHandler extends HttpServlet{
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
        String oldPassword = request.getParameter("OldPassword");
        String newPassword = request.getParameter("NewPassword");
        String confirmPassword = request.getParameter("ConfirmPassword");
        
        String nextLocation = "/changePassword.jsp";
        boolean result = false;
        String message = "";
        Agent agent = (Agent)session.getAttribute("authorizedUser");
        if(null == oldPassword || null == newPassword || null == confirmPassword || !newPassword.equals(confirmPassword)){
            message = "The password entered is not valid";
        }else if(agent == null){
            message = "Invalid user";
        }else {
            LoginDAO dao = new LoginDAODB();
            try{
                result = dao.UpdatePassword(agent.getUserID(), oldPassword, newPassword);
                if(result = false) {
                    message = "Your password could not be updated";
                } else {
                    message = "Your password was updated successfully";
                }
            } catch(SQLException | ClassNotFoundException ex) {
                message = ex.getMessage();
            }
        }
        session.setAttribute("message", message);
        
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
