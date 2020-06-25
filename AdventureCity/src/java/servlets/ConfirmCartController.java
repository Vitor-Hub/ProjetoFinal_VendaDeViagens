/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.AddressDAO;
import dao.CreditCardDAO;
import dao.ProductDAO;
import dao.PurchaseDAO;
import dominio.Address;
import dominio.Cart;
import dominio.CreditCard;
import dominio.Products;
import dominio.Purchase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import services.CartService;

/**
 *
 * @author clement
 */
public class ConfirmCartController extends HttpServlet {

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
        String confirmOrder = null;
        String optionRemove = null;
        
        try (PrintWriter out = response.getWriter()) {
            //we need to get all the value the user enter in the form
            int id = 0;
            //we use an if to avoid one NumberFormatException
            if(request.getParameter("id")!= null){
                id = Integer.parseInt(request.getParameter("id"));
            }
            String user = request.getParameter("user");
            confirmOrder = request.getParameter("confirmOrder");
            String card_number = request.getParameter("card_number");
            String card_name = request.getParameter("card_name");
            int cryptogram = 0;
            if(request.getParameter("cryptogram")!= null){
                cryptogram = Integer.parseInt(request.getParameter("cryptogram"));
            }
            String month = request.getParameter("month");
            int year = 0;
            if(request.getParameter("year")!= null){
                year = Integer.parseInt(request.getParameter("year"));
            }
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            String city = request.getParameter("city");
            int code = 0;
            if(request.getParameter("code")!= null){
                code = Integer.parseInt(request.getParameter("code"));
            }
            optionRemove = request.getParameter("optionRemove");
            
            //we check if our URL have one optionRemove which enable to add or remove quantity in the protucts.
            if(optionRemove!=null){
                    switch(optionRemove){
                    case "buy":
                        new CartService(request).buy(id);
                        break;
                    case "remove":
                        new CartService(request).remove(id);
                        break;
                    }
            }
            
            // if the option is about confirmOrder
            if(confirmOrder!= null){
                //Insert data from form in our table address 
                Address insertAdress = new Address(user, address, country, city, code);
                AddressDAO addressDAO = new AddressDAO();
                addressDAO.addAddress(insertAdress);
               //Insert data from form in our table credit card
                CreditCard insertCreditCart = new CreditCard(user, card_number,card_name, cryptogram, month,year);
                CreditCardDAO ccDao = new CreditCardDAO();
                ccDao.addCreditCard(insertCreditCart);
                
                //We get our session "cart" to insert data in our table purchase
                Cart cart = new Cart();
                HttpSession session = request.getSession();
                cart =(Cart) session.getAttribute("cart");
                Iterator it = cart.getProducts().iterator();
                while(it.hasNext()){
                    Object o = it.next();
                    Products p = (Products) o;
                    String product_name = p.getActivity_name();
                    String image_route = p.getImage_route();
                    String city1 = p.getCity();
                    System.out.println(city1);
                    int qty = cart.getQuantity(p);
                    Purchase purchase = new Purchase(user,product_name,image_route,city1);
                    PurchaseDAO pDAO = new PurchaseDAO();
                    pDAO.addPurchase(purchase);
                    ProductDAO qtyDAO = new ProductDAO();
                    qtyDAO.updateQty(qty, product_name);
                }
                //if everything works we send the user in the page final.jsp
                request.getRequestDispatcher("final.jsp").forward(request, response);
                
            }else{//when no option is use it
                RequestDispatcher rd = request.getRequestDispatcher("confirm_cart.jsp");
                rd.forward(request, response);  
            }
        }catch (SQLException ex) 
            {
            	ex.printStackTrace();
            }
        catch (ClassNotFoundException ex) 
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
