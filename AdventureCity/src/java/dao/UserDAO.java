/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Products;
import dominio.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class UserDAO extends DAO {
     private static UserDAO dao;
     private static String QUERY_USER = "SELECT * FROM user WHERE user_name = ? AND password = ?";
     private static String QUERY_USER_1 = "SELECT * FROM user WHERE user_name = ?";
     private static String QUERY_REGISTER ="INSERT into user (user_name, email, password) VALUES (?, ?, ?)";
     private static String QUERY_UPDATE_EMAIL ="UPDATE user SET email= ? WHERE user_name= ?";
     private static String QUERY_UPDATE_USER ="UPDATE user SET user_name= ? WHERE user_name= ?";
     private static String QUERY_UPDATE_PASSWORD ="UPDATE user SET password= ? WHERE user_name= ?";
     
    
    public UserDAO() throws ClassNotFoundException, SQLException
    {
        super();
    }
    public static UserDAO getInstance() throws ClassNotFoundException, SQLException
    {
        if(dao == null || !c.isValid(0))
        {
            dao = new UserDAO();
            System.out.println("Nueva DAO");
        }        
        return (UserDAO) dao;
    }
    public void close() throws SQLException
    {
            c.close();
    }
    
    public void updateUsername(String user, String username) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_UPDATE_USER);
        ps.setString(1, user);
        ps.setString(2, username);
        int i = ps.executeUpdate();
    }
    
    public void updateEmail(String email, String username) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_UPDATE_EMAIL);
        ps.setString(1, email);
        ps.setString(2, username);
        int i = ps.executeUpdate();
    }
    
    public void updatePassword(String password, String username) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_UPDATE_PASSWORD);
        ps.setString(1, password);
        ps.setString(2, username);
        int i = ps.executeUpdate();
    }
    public boolean findByUser(User u) throws SQLException
    {
        PreparedStatement ps = c.prepareStatement(QUERY_USER);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ResultSet rs = ps.executeQuery();

        if (rs.next())
            return true;
        else
            return false;

    }
    
    public User findInfoUser (String user) throws SQLException
    {
        User a = null;
        PreparedStatement ps = c.prepareStatement(QUERY_USER_1);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            String user1 = rs.getString("user_name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            a = new User(user1, email, password);
        }

        rs.close();
        ps.close();
        return a;
    }
    
    
    public void addUser(User u) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_REGISTER);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getPassword());
        int i = ps.executeUpdate();
    }
    
    
    
}
