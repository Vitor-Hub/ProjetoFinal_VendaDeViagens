/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.c;
import dominio.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author clement
 */
public class AddressDAO extends DAO {
    private static AddressDAO dao;
     private static String QUERY_SELECT = "SELECT * FROM address WHERE user = ?";
     private static String QUERY_INSERT ="INSERT into address (address, country, city, code, user) VALUES (?, ?, ?, ?, ?)";
     
    public AddressDAO() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    public static AddressDAO getInstance() throws ClassNotFoundException, SQLException
    {
        if(dao == null || !c.isValid(0))
        {
            dao = new AddressDAO();
            System.out.println("Nueva DAO");
        }        
        return (AddressDAO) dao;
    }
    public void close() throws SQLException
    {
            c.close();
    }
    
    public void addAddress (Address a) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_INSERT);
        ps.setString(1, a.getAddress());
        ps.setString(2, a.getCountry());
        ps.setString(3, a.getCity());
        ps.setInt(4, a.getCode());
        ps.setString(5, a.getUser());
        ps.executeUpdate();
    }
    
    public Address findByUser (String user) throws SQLException
    {
        Address a = null;
        PreparedStatement ps = c.prepareStatement(QUERY_SELECT);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String user1 = rs.getString("user");
            String address = rs.getString("address");
            String country = rs.getString("country");
            String city = rs.getString("city");
            int code = rs.getInt("code");
            a = new Address(id,user1, address, country, city, code);
        }

        rs.close();
        ps.close();
        return a;
    }
}
