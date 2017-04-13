/*
 * 
 * 
 * Robert Forbes
 */
package login;

import agent.Agent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class LoginHandler extends HttpServlet {
    
    
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
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        
        String nextLocation = "/index.jsp";
        
        String message = "Please enter your username and password";
        
        if(null == username || null == password){
            message = "Please enter your username and password.";
        } else {
            Agent agent = null;
            LoginDAO dao = new LoginDAODB();
            try{
                agent = dao.getAgentByUsernameAndPassword(username, password);
                if(null == agent) {
                    message = "Invalid username or password.";
                } else {
                    session.setAttribute("authorizedUser", agent);
                    nextLocation = "MainScreen.jsp";
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
