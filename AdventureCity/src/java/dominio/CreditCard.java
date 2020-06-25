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
public class CreditCard {
    private int id;
    private String user;
    private String card_number;
    private String card_name;
    private int cryptogram;
    private String month;
    private int year;
    
    public CreditCard(){
        
    }
    public CreditCard(String user, String card_number, String card_name, int cryptogram, String month, int year){
        this.user = user;
        this.card_number = card_number;
        this.card_name = card_name;
        this.cryptogram = cryptogram;
        this.month = month;
        this.year = year;
    }
    
    public CreditCard(int id,String user, String card_number, String card_name, int cryptogram, String month, int year){
        this.id = id;
        this.user = user;
        this.card_number = card_number;
        this.card_name = card_name;
        this.cryptogram = cryptogram;
        this.month = month;
        this.year = year;
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
    
    public String getCardNumber(){
        return card_number;
    }
    
    public void setCardNumber(String card_number){
        this.card_number = card_number;
    }
    
    public String getCardName(){
        return card_name;
    }
    
    public void setCardName(String card_name){
        this.card_name = card_name;
    }
    
    public int getCryptogram(){
        return cryptogram;
    }
    
    public void setCryptogram(int cryptogram){
        this.cryptogram = cryptogram;
    }
    
    public String getMonth(){
        return month;
    }
    
    public void setMonth(String month){
        this.month = month;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
}
