<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="dominio.Products"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AdventureCity</title>
        <link href="css/index.css" type="text/css" rel="stylesheet"/>
        <script language= "javascript" src="js/script.js"></script>       
    </head>
    <body>
        <div id="main">
            
            <!-- MENU -->
                <div id="menu">
                    <jsp:include page="menu.jsp" />
                </div>
            <!-- FIN-MENU -->
            <div style="display: flex;">
                <img src="${description.image_route}" id="description">
                <h2 id="descriptionTitle">${description.activity_name}</h2>
                <label id="descriptionLabel">${description.description}</label>
                <div class="text-block">
                <h3><span style="color: red; font-size:40px " >${description.price} € </span>/person</h3>
                <hr/>
                <form method="POST" action="ProductListController?optionCart=buy&id=${description.id}">
                <label>Number of place</label>
                <select name="number">                   
                <option selected>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                </select><br><br>
                <c:choose>
                <c:when test="${sessionScope.user!= null}">
                    <input type="submit" id="cartButton" value="Add to cart">
                </c:when>
                <c:when test="${sessionScope.user== null}">
                    <label>You need to be connected to add in cart</label>
                </c:when>
                </c:choose>
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