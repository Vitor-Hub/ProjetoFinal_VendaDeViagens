/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ProductDAO;
import dominio.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clement
 */
public class FilterController extends HttpServlet {

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
            String city = null;
            String range = null;
        try (PrintWriter out = response.getWriter()) {
            city = request.getParameter("city");
            range = request.getParameter("prices");
            Collection<Products> productList = null;
            
            if(range.equals("all") && !city.equals("all")){
                productList = ProductDAO.getInstance().findByCity(city);
                request.setAttribute("productList", productList);                
            }else if(city.equals("all") && !range.equals("all")){
                switch(range)
                {
                    case "range1":
                        productList = ProductDAO.getInstance().findByRANGE(0,50);
                        request.setAttribute("productList", productList);  
                        break;
                    case "range2":
                        productList = ProductDAO.getInstance().findByRANGE(50,100);
                        request.setAttribute("productList", productList);
                        break;
                    case "range3":
                        productList = ProductDAO.getInstance().findByRANGE(100,150);
                        request.setAttribute("productList", productList);
                        break;
                    case "range4":
                        productList = ProductDAO.getInstance().findByRANGE(150,1000);
                        request.setAttribute("productList", productList);
                        break;
                }
            }else if(!city.equals("all") && !range.equals("all")){
                switch(range)
                {
                    case "range1":
                        productList = ProductDAO.getInstance().findByCityRANGE(city,0,50);
                        request.setAttribute("productList", productList);  
                        break;
                    case "range2":
                        productList = ProductDAO.getInstance().findByCityRANGE(city,50,100);
                        request.setAttribute("productList", productList);
                        break;
                    case "range3":
                        productList = ProductDAO.getInstance().findByCityRANGE(city,100,150);
                        request.setAttribute("productList", productList);
                        break;
                    case "range4":
                        productList = ProductDAO.getInstance().findByCityRANGE(city,150,1000);
                        request.setAttribute("productList", productList);
                        break;
                }           
            }
            else{
                productList = ProductDAO.getInstance().findAllProducts();
                request.setAttribute("productList", productList);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("productlist.jsp");
            rd.forward(request, response);
            
        }
        catch (ClassNotFoundException ex) 
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
