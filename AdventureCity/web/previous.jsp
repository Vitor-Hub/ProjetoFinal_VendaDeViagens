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
                    <c:set var="date" value="none"></c:set>
                    <c:forEach var="p" items="${previous}">
                            <c:if test="${date!= p.date_purchase}">
                                <div style="background-color: rgb(212,212,212);">
                                    <label>Ordered :</label>
                                    <p>${p.date_purchase}</p>
                                </div>
                                <div style="display: flex;  border: 1px solid rgba(200, 200, 200);">
                                    <img src="${p.image_route}">
                                    <div class="ordered">
                                        <div>
                                            <span>${p.product_name}</span><br>
                                            <span style="color: rgb(126, 126, 126);">${p.city}</span><br>
                                        </div>
                                        <div>
                                            <form method="POST" action="DescriptionController?option=byName&name=${p.product_name}">
                                                <button type="submit">Buy Again</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <c:set var="date" value="${p.date_purchase}"></c:set>
                                 <c:set var="name" value="${p.product_name}"></c:set>
                            </c:if>
                             <c:if test="${name!= p.product_name}">
                            <c:if test="${date == p.date_purchase}">
                                <div style="display: flex;  border: 1px solid rgba(200, 200, 200);">
                                    <img src="${p.image_route}">

                                    <div class="ordered">

                                        <div>
                                            <span>${p.product_name}</span><br>
                                            <span style="color: rgb(126, 126, 126);">${p.city}</span><br>
                                        </div>
                                        <div>
                                            <form method="POST" action="DescriptionController?option=byName&name=${p.product_name}">
                                                <button type="submit">Buy Again</button>
                                            </form>
                                            
                                        </div>
                                    </div>
                                </div>
                                <c:set var="date" value="${p.date_purchase}"></c:set>
                            </c:if>
                        </c:if>
                        <c:if test="${name== p.product_name}">
                        </c:if>

                    </c:forEach>
                </div>
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
