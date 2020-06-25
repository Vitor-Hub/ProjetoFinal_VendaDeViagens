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
public class Address {
    private int id;
    private String user;
    private String address;
    private String country;
    private String city;
    private int code;
    
    public Address(){
        
    }
    
    public Address(String user,String address, String country, String city,int code){
        this.user = user;
        this.address = address;
        this.country = country;
        this.city = city;
        this.code = code;
    }
    
    public Address(int id,String user, String address, String country, String city,int code){
        this.id = id;
        this.user = user;
        this.address = address;
        this.country = country;
        this.city = city;
        this.code = code;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    public int getCode(){
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
}
