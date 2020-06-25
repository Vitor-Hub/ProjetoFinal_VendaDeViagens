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
            <div id="your_cart">
            <h2>Your order is confirmed</h2>
            <hr>
            <c:set var="total" value="0"></c:set>
            <c:if test="${not empty sessionScope.cart.map}">
            <c:forEach var="productCart" items="${sessionScope.cart.map}">
                <c:set var="euros" value="${productCart.value * productCart.key.price}"></c:set>
                <c:if test="${id==productCart.key.id}">
                <c:set var="idNoted" value="refresh" />
                </c:if>
                <c:if test="${id!=productCart.key.id}">
                    <c:set var="idNoted" value="" />
                </c:if>
                <div class="Products_cart" id="${idNoted}">
                <img src="${productCart.key.image_route}">   
                <div class="Name_City">
                    <div style="width: 10vw;">${productCart.key.activity_name}<br><br>${productCart.key.city}<br><br>${productCart.value} persons</div>
                </div>

                <div class="Price_cart" style="margin-left: 30%;"> 
                    <label>${euros}€</label>                
                </div>                                              
            </div>
            <hr>
             </c:forEach>
             </c:if>
            <label id="priceTotalConfirm">TOTAL : ${sessionScope.cart.priceTotal} €</label><br><br>
        </div>
        </div>
    <div>
        <form method="POST" action="FinalController">
        <input type="submit" id="Total_button" value="Return to Homepage">
        </form>
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