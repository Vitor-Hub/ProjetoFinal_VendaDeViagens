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
            <div>
        <img id="img" src="image/fundo.jpg">

        <div id="title">
            <p>Welcome to our website</p>
        </div>

        <div id="text">
            Do you like to live new experiences ? Are you boring about city tours ? <br>
            You are in the perfect place ! Adventure city offer you to discover city in unique way with suprising<br> activities around the world !
        </div>

        <div style="background-color: rgba(240,240,240);">
            <p class="title2">BEST SELLERS</p>

            <div id=table_sellers>
                <table>
                    <tr>
                        <c:forEach var="p" items="${bestSellers}">
                            <td>
                                <div class="SELLERS">
                                    <img src="${p.image_route}">
                                    <p>${p.activity_name}</p>
                                    <p>${p.city}</p>
                                    <p>from <span>${p.price} €<span></p>
                                    <form method="POST" action="DescriptionController?id=${p.id}">
                                        <button type="submit" value="Buy">Buy</button>
                                    </form>
                                </div>
                            </td>
                        </c:forEach>
                    </tr>
                </table>
            </div>
        </div>


        <p class="title2">CITIES</p>

        <div id="table1">

            <a href="ProductListController?option=London"><img src="image/london.png"></a>
            <a href="ProductListController?option=Paris"><img src="image/paris.png"></a>

            <a href="ProductListController?option=Madrid"><img src="image/madrid.png"></a>
            <a href="ProductListController?option=Prague"><img src="image/pragues.png"></a>
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
