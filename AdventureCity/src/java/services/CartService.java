/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProductDAO;
import dominio.Cart;
import dominio.Products;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CartService {
    private HttpServletRequest request;
    private Cart cart;
    
    public CartService(HttpServletRequest request){
        this.request = request;
    }
    
    private Cart getCart(){
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        
        return cart;
    }
    
    public void buy(int id) throws ClassNotFoundException, SQLException{
        
        ProductDAO dao = ProductDAO.getInstance();
        
        Products p = null;
        p = dao.findById(id);
        
        if(p!=null){
            getCart().addProduct(p);
        }     
    }
    
    public void remove(int id){
        Products p = new Products(id);
        getCart().removeProduct(p);
    }
    
    public void reset(){
        getCart().clear();
    }
    
    public void setCart(Cart cart){
        this.cart = cart;
    }
}
