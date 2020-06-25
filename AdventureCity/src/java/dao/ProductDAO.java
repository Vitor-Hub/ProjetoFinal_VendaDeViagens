/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author clement
 */
public class ProductDAO extends DAO {
    private static String QUERY_BEST_SELLERS = "SELECT * FROM product ORDER BY qty DESC LIMIT 5";
    private static String QUERY_ALL_PRODUCTS = "SELECT * FROM product";
    private static String QUERY_PRODUCTS_BY_CITY = "SELECT * FROM product WHERE city = ?";
    private static String QUERY_PRODUCT_BY_NAME = "SELECT * FROM product WHERE activity_name LIKE ?";
    private static String QUERY_PRODUCT_BY_NAME_1 = "SELECT * FROM product WHERE activity_name = ?";
    private static String QUERY_PRODUCT_BY_NAME_CITY = "SELECT * FROM product WHERE activity_name LIKE ? AND city = ?";
    private static String QUERY_PRODUCT_BY_CITY_RANGE = "SELECT * FROM product WHERE city = ? AND price BETWEEN ? AND ?";
    private static String QUERY_PRODUCT_BY_RANGE = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
    private static String QUERY_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static String QUERY_UPDATE_QTY = "UPDATE product set qty = qty+? where activity_name = ?";
    private static String QUERY_INSERT ="INSERT into product (activity_name, city, price, description, qty, image_route1) VALUES (?, ?, ?, ?, ?, ?)";
    private static String QUERY_DELETE = "DELETE FROM product WHERE id = ?";
    
    
    private static ProductDAO dao;
    
    public ProductDAO() throws ClassNotFoundException, SQLException
    {
        super();
    }
    public static ProductDAO getInstance() throws ClassNotFoundException, SQLException
    {
        if(dao == null || !c.isValid(0))
        {
            dao = new ProductDAO();
            System.out.println("Nueva DAO");
        }        
        return (ProductDAO) dao;
    }
    public void updateQty(int qty, String activity_name) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_UPDATE_QTY);
        ps.setInt(1, qty);
        ps.setString(2, activity_name);
        int i = ps.executeUpdate();
    }
    
    public void deleteById(int id) throws SQLException{
        PreparedStatement ps = c.prepareStatement(QUERY_DELETE);
        ps.setInt(1, id);
        int i = ps.executeUpdate();
        
    }
    public Collection<Products> findBestSellers() throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_BEST_SELLERS);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }
    
    public Collection<Products> findAllProducts() throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_ALL_PRODUCTS);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }
    public Collection<Products> findByCity(String city) throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCTS_BY_CITY);
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city1, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }
    
        public Products findById(int unit) throws SQLException
    {
        Products p = null;
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_ID);
        ps.setInt(1, unit);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            p = new Products(id, activity_name, city1, price, description, image_route);
        }

        rs.close();
        ps.close();
        return p;
    }
        
    public Products findByNameDescription(String name) throws SQLException
    {
        Products p = null;
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_NAME_1);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            p = new Products(id, activity_name, city1, price, description, image_route);
        }

        rs.close();
        ps.close();
        return p;
    }
        
    public Collection<Products> findByName(String productSearch) throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_NAME);
        ps.setString(1,"%"+productSearch+"%");
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city1, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }
        
    public Collection<Products> findByNameCity(String productSearch,String citySearch) throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_NAME_CITY);
        ps.setString(1,"%"+productSearch+"%");
        ps.setString(2, citySearch);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city1, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }

    public Collection<Products> findByCityRANGE(String city,double min, double max) throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_CITY_RANGE);
        ps.setString(1,city);
        ps.setDouble(2, min);
        ps.setDouble(3, max);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city1, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    }
    public Collection<Products> findByRANGE(double min, double max) throws SQLException
    {
        ArrayList<Products> list = new ArrayList<Products>();
        PreparedStatement ps = c.prepareStatement(QUERY_PRODUCT_BY_RANGE);
        ps.setDouble(1, min);
        ps.setDouble(2, max);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            int id = rs.getInt("id");
            String activity_name = rs.getString("activity_name");
            String city1 = rs.getString("city");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String image_route = rs.getString("image_route1");
            list.add(new Products(id, activity_name, city1, price, description, image_route));
        }

        rs.close();
        ps.close();
        return list;
    } 
    
    public void createProduct(Products p) throws SQLException{
        PreparedStatement ps  = c.prepareStatement(QUERY_INSERT);
        ps.setString(1, p.getActivity_name());
        ps.setString(2, p.getCity());
        ps.setDouble(3, p.getPrice());
        ps.setString(4, p.getDescription());
        ps.setInt(5, 0);
        ps.setString(6, p.getImage_route());
        ps.executeUpdate();
    }
}
