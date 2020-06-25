/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ProductDAO;
import dominio.Products;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author clement
 */
public class CreateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String chemin = this.getServletConfig().getInitParameter("chemin");
            String title = request.getParameter("titleCreate");
            String city = request.getParameter("cityCreate");
            System.out.println(city);
            String description = request.getParameter("descriptionCreate");
            double price = Double.parseDouble(request.getParameter("priceCreate"));
            Part part = request.getPart("fichierCreate");
            String nomFichier = getNomFichier(part);
            String image_route = "image/"+nomFichier;   
            
            if( nomFichier != null && !nomFichier.isEmpty()){
                String nomChamp = part.getName();
                nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 ).substring( nomFichier.lastIndexOf( '\\' ) + 1 );
                writeFile(part, nomFichier,chemin);
            }
            
            Products newProdcut = new Products(title, city,price, description,image_route);
            ProductDAO dao = new ProductDAO();
            dao.createProduct(newProdcut);
            
            
            this.getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);

        }catch (SQLException ex) 
            {
            	ex.printStackTrace();
            }
        catch (ClassNotFoundException ex) 
            {
            	ex.printStackTrace();
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    //this is our function to upload the files in our project
    
    private void writeFile(Part part, String nameFile, String path) throws IOException{
        
        BufferedInputStream entrance = null;
        BufferedOutputStream exit = null;
        
        try{
            entrance = new BufferedInputStream( part.getInputStream(), 10240);
            exit = new BufferedOutputStream( new FileOutputStream(new File(path + nameFile)), 10240);
            
            byte[] tampon = new byte[10240];
            int size;
            while((size = entrance.read( tampon)) > 0){
                exit.write( tampon, 0, size);
            }
        }finally{
            if(null != exit){
                        try{
                exit.close();
            } catch(IOException ignore){
             
            }
   
            }try{
                entrance.close();
            } catch(IOException ignore){
                
            }
            
        }
    }
    
    //We use this function to get the name of the files from the Header.
    private static String getNomFichier(Part part){
        for(String contentDisposition : part.getHeader("content-disposition").split(";")){
            if( contentDisposition.trim().startsWith("filename")){
                return contentDisposition.substring( contentDisposition.indexOf('=') + 1).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
