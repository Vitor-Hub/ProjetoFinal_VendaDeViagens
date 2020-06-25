/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author clement
 */
public class Cart {
    
    private HashMap <Products, Integer> cart;
    
    public Cart(){
        cart = new HashMap <Products, Integer>();
    }
    
    public void addProduct(Products p){
        
        Integer unit = cart.get(p);
        if(unit!=null){
            cart.put(p, unit+1);
        }else{
            cart.put(p,1);
        }
    }
    
    public void removeProduct (Products p){
        Integer unit = cart.get(p);
        if(unit==1){
            cart.remove(p);
        }else{
            cart.put(p, unit - 1);
        }
    }
    
    public int getQuantity(Products p){
        Integer unit = cart.get(p);
        if(unit!=1){
            return unit;
        }else{
            return 0;
        }
    }
    
    public void clear(){
        cart.clear();
    }
    
    public Set<Products> getProducts(){
        return cart.keySet();
    }
   
    public Collection<Integer> getUnit(){
        return cart.values();
    }
    
    
    public HashMap<Products, Integer> getMap(){
        return cart;
    }
    
    public int getSize(){
        return cart.size();
    }
    
    public double getPriceTotal(){
        double priceTotal = 0;
        
        for(Map.Entry<Products, Integer> map : cart.entrySet()){
            priceTotal += map.getKey().getPrice() * map.getValue();
        }
        
        return priceTotal;
    }
    
}
