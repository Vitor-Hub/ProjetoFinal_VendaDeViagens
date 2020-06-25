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
import services.CartService;

/**
 *
 * @author clement
 */
public class ProductListController extends HttpServlet {

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
        String productSearch = null;
        String optionCart = "";
        try (PrintWriter out = response.getWriter()) {
            
            Collection<Products> productList = null;
            option = request.getParameter("option");
            productSearch = request.getParameter("product");
            String citySearch = request.getParameter("citySearch");
            int number = 0;
            optionCart = request.getParameter("optionCart");
            int id = 0;
            if(request.getParameter("id")!= null){
                id = Integer.parseInt(request.getParameter("id"));
            }
            if(request.getParameter("number")!= null){
                number = Integer.parseInt(request.getParameter("number"));
            }
            
            request.setAttribute("id", id);
            
            if(optionCart!=null){
                switch(optionCart){
                    case "buy":
                        for(int i=0; i<number; i++){
                        new CartService(request).buy(id);
                        }
                        break;
                    case "remove":
                        new CartService(request).remove(id);
                        break;
                    case "reset":
                        new CartService(request).reset();
                        break;
                }
            }
            
            if(option != null){
                if(option.equals("London")){
                    productList = ProductDAO.getInstance().findByCity("london");
                    request.setAttribute("productList", productList);
                }else if(option.equals("Paris")){
                    productList = ProductDAO.getInstance().findByCity("paris");
                    request.setAttribute("productList", productList);                    
                }else if(option.equals("Madrid")){
                    productList = ProductDAO.getInstance().findByCity("madrid");
                    request.setAttribute("productList", productList);                    
                }else if(option.equals("Prague")){    
                    productList = ProductDAO.getInstance().findByCity("prague");
                    request.setAttribute("productList", productList);                    
                }  
            }else if(productSearch != null){
                if(citySearch.equals("Cities")){
                    productList = ProductDAO.getInstance().findByName(productSearch);
                    request.setAttribute("productList", productList);                      
                }else
                productList = ProductDAO.getInstance().findByNameCity(productSearch, citySearch);
                request.setAttribute("productList", productList);  
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
