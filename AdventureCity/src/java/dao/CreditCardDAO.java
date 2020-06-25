/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.c;
import dominio.CreditCard;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author clement
 */
public class CreditCardDAO extends DAO {
     private static CreditCardDAO dao;
     private static String QUERY_SELECT = "SELECT * FROM creditcard WHERE user = ?";
     private static String QUERY_INSERT ="INSERT into creditcard (user, card_number, card_name, cryptogram, month, year) VALUES (?, ?, ?, ?, ?, ?)";
     
    public CreditCardDAO() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    public static CreditCardDAO getInstance() throws ClassNotFoundException, SQLException
    {
        if(dao == null || !c.isValid(0))
        {
            dao = new CreditCardDAO();
            System.out.println("Nueva DAO");
        }        
        return (CreditCardDAO) dao;
    }
    public void close() throws SQLException
    {
            c.close();
    }
    
    public void addCreditCard(CreditCard cc) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_INSERT);
        ps.setString(1, cc.getUser());
        ps.setString(2, cc.getCardNumber());
        ps.setString(3, cc.getCardName());
        ps.setInt(4, cc.getCryptogram());
        ps.setString(5, cc.getMonth());
        ps.setInt(6, cc.getYear());
        int i = ps.executeUpdate();
    }
    
    public CreditCard findByUser (String user) throws SQLException
    {
        CreditCard cc = null;
        PreparedStatement ps = c.prepareStatement(QUERY_SELECT);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String user1 = rs.getString("user");
            String card_number = rs.getString("card_number");
            String card_name = rs.getString("card_name");
            int cryptogram = rs.getInt("cryptogram");
            String month = rs.getString("month");
            int year = rs.getInt("year");
            cc = new CreditCard(id,user1, card_number,card_name, cryptogram, month,year);
        }

        rs.close();
        ps.close();
        return cc;
    }
    
    
}
