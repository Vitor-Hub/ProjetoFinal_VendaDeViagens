<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="dominio.Products"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>AdventureCity</title>
    <link href="css/index.css" type="text/css" rel="stylesheet" />
    <script language="javascript" src="js/script.js"></script>
    <script src="https://kit.fontawesome.com/801f610d6e.js" crossorigin="anonymous"></script>
</head>

<body>
    <div id="main">

        <!-- MENU -->
        <div id="menu">
            <jsp:include page="menu.jsp" />
        </div>
        <!-- FIN-MENU -->
<div style="display: flex;">
    <div class="settings">
        <form action="CreateController" method="post" enctype="multipart/form-data" onsubmit="javascript:return confirm_create();">
                    <fieldset>
                        <legend>Create Product file</legend>

                        <label for="create">Title</label>
                        <input type="text" id="titleCreate" name="titleCreate" value="" />                   
                        <br />
                        
                        <label for="create">City</label>
                        <input type="text" id="cityCreate" name="cityCreate" value="" />                  
                        <br />
                        
                        <label for="create">Description</label>
                        <textarea rows = "10" cols = "60" id="descriptionCreate" name="descriptionCreate">
                        
                        </textarea>
               
                        <br />
                        
                        <label for="create">Price</label>
                        <input type="text" id="priceCreate" name="priceCreate" value="" /> 
                        <label>${price}</label>                   
                        <br />
                        

                        <label for="fichier">Upload image <span class="requis">*</span></label>
                        <input type="file" id="fichierCreate" name="fichierCreate" />
                        <br />

                        <input type="submit" value="Envoyer" class="sansLabel" />
                        <br />                
                    </fieldset>
                </form>
    </div>  
</div>

        <footer id="footer">

            <div id="direccion">
                <h4>Dirección</h4>
                <p>Calle de Alberto Aguilera, 25</p>
                <p>28015 Madrid</p>
                <p>Espanha</p>
            </div>
            <img id="img5" src="image/maps.png">

        </footer>
    </div>
    </div>
</body>

</html>