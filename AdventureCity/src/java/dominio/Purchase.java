/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author clement
 */
public class Purchase {
    private int id;
    private String user_name;
    private String product_name;
    private Date date_purchase;
    private String image_route;
    private String city;
    
    public Purchase(){
        
    }
    
    public Purchase(String user_name, String product_name,String image_route, String city){
        this.user_name = user_name;
        this.product_name = product_name;
        this.image_route = image_route;
        this.city = city;
    }
    
    public Purchase(int id,String user_name, String product_name, Date date_purchase, String image_route, String city){
        this.id = id;
        this.user_name = user_name;
        this.product_name = product_name;
        this.date_purchase = date_purchase;
        this.image_route = image_route;
        this.city = city;
    }
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getUser_name(){
        return user_name;
    }
    
    public void setUser_name( String user_name){
        this.user_name = user_name;
        
    }
    
    public String getProduct_name(){
        return product_name;
    }
    
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    
    public Date getDate_purchase(){
        return date_purchase;
    }
    
    public void setDate_purchase(Date date_purchase){
        this.date_purchase = date_purchase;
    }
    
    public String getImage_route(){
        return image_route;
    }
    
    public void setImage_route(String image_route){
        this.image_route = image_route;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
}