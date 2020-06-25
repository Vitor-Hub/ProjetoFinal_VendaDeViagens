/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.UserDAO;
import dominio.Address;
import dominio.CreditCard;
import dominio.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clement
 */
public class SettingsController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String option = null;
        try (PrintWriter out = response.getWriter()) {
            option = request.getParameter("option");
            String user = request.getParameter("user");
            User userInfo = null;
            
            if(option!= null){
                switch(option){
                    case "Username":
                        String username = request.getParameter("usernameS");
                        UserDAO.getInstance().updateUsername(username, user);
                         userInfo = UserDAO.getInstance().findInfoUser(username);
                        request.setAttribute("userInfo", userInfo);
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("user", username);
                        break;
                    case "Email":
                        String email = request.getParameter("email");
                        UserDAO.getInstance().updateEmail(email, user);
                        break;
                    case "Password":
                        String password = request.getParameter("password");
                        UserDAO.getInstance().updatePassword(password, user);
                        break;
                }
                RequestDispatcher rd = request.getRequestDispatcher("settings.jsp");
                rd.forward(request, response);
            }else{
                userInfo = UserDAO.getInstance().findInfoUser(user);
                request.setAttribute("userInfo", userInfo);
                RequestDispatcher rd = request.getRequestDispatcher("settings.jsp");
                rd.forward(request, response);
            }
            
            

        }catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
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
