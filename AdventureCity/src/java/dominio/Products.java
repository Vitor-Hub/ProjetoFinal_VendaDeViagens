/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author clement
 */
public class Products {
    private int id;
    private String activity_name;
    private String city;
    private double price;
    private String description;
    private String image_route;
    private int qty;
    
    public Products(){
        
    }
    
    public Products(int id){
        this.id = id;
    }
    
    
    public Products(int id, String activity_name, String city, double price, String description,String image_route){
        this.id = id;
        this.activity_name = activity_name;
        this.city = city;
        this.price = price;
        this.description = description;
        this.image_route = image_route;
    }
    
    public Products(String activity_name, String city, double price, String description,String image_route){
        this.activity_name = activity_name;
        this.city = city;
        this.price = price;
        this.description = description;
        this.image_route = image_route;
    }
    
    public int getId(){
        return id;
    }
    
    public String getActivity_name(){
        return activity_name;
    }
    
    public String getCity(){
        return city;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getDescription(){
        return description;
    }
    

    public String getImage_route(){
        return image_route;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setActivity_name(String activity_name){
        this.activity_name = activity_name;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    
    public void setImage_route(String image_route){
        this.image_route = image_route;
    }
    
    public void setQty(int qty){
        this.qty = qty;
    }
    
    public int getQty(){
        return qty;
    }

    @Override
    public boolean equals(Object o) 
    {
        Products p = (Products) o;
        if (id == p.getId())
            return true;
        else
            return false;
    }    

    @Override
    public int hashCode() 
    {
        return id;
    }    
}
    
