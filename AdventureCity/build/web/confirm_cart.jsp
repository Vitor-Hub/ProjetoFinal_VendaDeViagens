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
            <h2>Your Cart</h2>
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
                    <a href="ConfirmCartController?optionRemove=buy&id=${productCart.key.id}"><i class="fas fa-cart-plus"></i></a>
                    <a href="ConfirmCartController?optionRemove=remove&id=${productCart.key.id}"><i class="fas fa-times"></i></a>     
                    <label>${euros}€</label>                
                </div>                                              
            </div>
            <hr>
             </c:forEach>
             </c:if>
            <label id="priceTotalConfirm">TOTAL : ${sessionScope.cart.priceTotal} €</label><br><br>
        </div>
        </div>
                <div id="order" style="display: flex;">

            <div id="payment">
                <h1>Payement</h1>
                <img class="imgCB" src="image/mastercard.png">
                <img class="imgCB" src="image/visa.png">
                <form method="POST" action="ConfirmCartController?confirmOrder=validate&user=${sessionScope.user}" onsubmit="javascript:return confirm_cart();">
                <div>
                    <br><label>Card number</label>
                    <input id="card_number" name="card_number" type="text"><br><br>
                </div>

                <div>
                    <label>Name in the card</label>
                    <input id="card_name" name="card_name" type="text"><br><br>
                </div>

                <div id="final_payment">
                    <label>Cryptogram</label>
                    <input id="cryptogramT" name="cryptogram" type="text"><br><br>

                    <select name="month">
                        <option>January</option>
                        <option>February</option>
                        <option>March</option>
                        <option>April</option>
                        <option selected>May</option>
                        <option>June</option>
                        <option>July</option>
                        <option>August</option>
                        <option>September</option>
                        <option>October</option>
                        <option>November</option>
                        <option>December</option>
                    </select> 

                    <select name="year">
                        <option>2030</option>
                        <option>2029</option>
                        <option>2028</option>
                        <option>2027</option>
                        <option>2026</option>
                        <option>2025</option>
                        <option>2024</option>
                        <option>2023</option>
                        <option>2022</option>
                        <option>2021</option>
                        <option selected>2020</option>
                    </select>
                </div>
            </div>

            <div id="Address">
                <h1>Address</h1>

                <div>
                    <label>Address</label><br>
                    <input id="addressT" name="address" type="text"><br><br>
                </div>

                <div>
                    <label>Country</label><br>
                    <input id="countryT" name="country" type="text"><br><br>
                </div>

                <div id="final_address">
                    <label>City</label><br>
                    <input id="cityT" name="city" type="text"><br><br>

                    <label>Code</label><br>
                    <input id="code" name="code" type="text"><br><br>
                </div>
            </div>
        </div>
    </div>

    <div>
        <input type="submit" id="Total_button" value="Confirm order">
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