/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.c;
import dominio.Purchase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author clement
 */
public class PurchaseDAO extends DAO {
     private static PurchaseDAO dao;
     private static String QUERY_INSERT ="INSERT into purchase (user_name, product_name, date_purchase, image_route, city) VALUES (?, ?, CURDATE(), ?, ?)";
     private static String QUERY_SELECT ="SELECT * FROM purchase WHERE user_name= ? ORDER BY date_purchase DESC";
     
    public PurchaseDAO() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    public static PurchaseDAO getInstance() throws ClassNotFoundException, SQLException
    {
        if(dao == null || !c.isValid(0))
        {
            dao = new PurchaseDAO();
            System.out.println("Nueva DAO");
        }        
        return (PurchaseDAO) dao;
    }
    public void close() throws SQLException
    {
            c.close();
    }
    
    public void addPurchase (Purchase p) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_INSERT);
        ps.setString(1, p.getUser_name());
        ps.setString(2, p.getProduct_name());
        ps.setString(3, p.getImage_route());
        ps.setString(4, p.getCity());
        ps.executeUpdate();
    }
    
    public Collection<Purchase> selectPurchase(String user) throws SQLException
    {
        ArrayList<Purchase> list = new ArrayList<Purchase>();
        PreparedStatement ps = c.prepareStatement(QUERY_SELECT);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String user_name = rs.getString("user_name");
            String product_name = rs.getString("product_name");
            Date date_purchase = rs.getDate("date_purchase");
            String image_route = rs.getString("image_route");
            String city = rs.getString("city");
            list.add(new Purchase(id, user_name, product_name, date_purchase, image_route, city));
        }

        rs.close();
        ps.close();
        return list;
    }

}
