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
                <div class="previous">
                     <c:forEach var="p" items="${productList}">
                    <div id="previous2">
                       
                        <div>
                            <label>Option :</label>
                            <p>Choose one option</p>
			</div>
                        <div><form method="POST" action="ChangeController?option=delete&id=${p.id}">
                                <button type="submit">Delete</button>
                                </form>
                            </div>

                            <div>
                                <button onclick="indisponible()">Change price</button>
                                
                            </div>

                            <div>
                                <button onclick="indisponible()">Modify info</button>
                            </div>
                        
                    </div>
		    <div class= "previous2_set">
                        <img src="${p.image_route}">
                        <div class="ordered">
                            <div>
                                <span >${p.activity_name}</span><br>
                                <span style="color: rgb(126, 126, 126);">${p.city}</span><br><br>
                            </div>
                            <div>
                                <span class="set_price">${p.price} €</span>
                            </div>
                        </div>
                    </div>
                   </c:forEach>
                </div>
            </div>
        </div>
        <footer id="footer">
            <div id="enlaces">
                <h4>Enlaces rápidos</h4>
                <p>Bienvenido</p>
                <p>¿Quiénes somos?</p>
                <p>Viajes</p>
                <p>Programas</p>
                <p>alojamiento</p>
            </div>

            <div id="apoyo">
                <h4>Apoyo</h4>
                <p>Contactar</p>
                <p>Pro Space</p>
                <p>Créditos fotográficos</p>
            </div>
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
