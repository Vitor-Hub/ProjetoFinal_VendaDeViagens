<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="dominio.Products"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>


    <title>AdventureCity</title>
    <meta content="text/html;" http-equiv="content-type" charset="utf-8">
    <link href="css/index.css" type="text/css" rel="stylesheet"/>
    <script src="js/script.js" language="Javascript"></script>
    <script src="https://kit.fontawesome.com/801f610d6e.js" crossorigin="anonymous"></script>

</head>

<body>
    <div id="main">
        <!-- MENU -->
                <div id="menu">
                    <jsp:include page="menu.jsp" />
                </div>
	<!-- FIN-MENU -->

        <div  id="productpage" style="display: flex;">

            <div class="Table_filters">
                <div class="Filters">Filters<br></div>
            <form method="POST" action="FilterController" class="formFilter">
            <div>
                <p>CITIES</p>
                <input type="radio" name="city" value="all" checked>
                <label>All</label><br>
                <input type="radio" name="city" value="madrid">
                <label>Madrid </label><br>
                <input type="radio" name="city" value="london">
                <label>London </label><br>
                <input type="radio" name="city" value="paris">
                <label>Paris </label><br>
                <input type="radio" name="city" value="prague">
                <label>Prague </label><br><br>
            </div>

            <div>
                <p>PRICES</p>
                <input type="radio" name="prices" value="all" checked>
                <label>All</label><br>
                <input type="radio" name="prices" value="range1">
                <label>0€ - 50€ </label><br>
                <input type="radio" name="prices" value="range2">
                <label>50€ - 100€ </label><br>
                <input type="radio" name="prices" value="range3"> 
                <label>100€ - 150€ </label><br>
                <input type="radio" name="prices" value="range4">
                <label>150€ and more </label><br><br>
                <input type="submit" value="Filter"/>
            </div>
                
            </form>
        </div>

            <div id="Product_table">
                <table>
                    <tr>
                        <td>
                            <c:forEach var="p" items="${productList}">
                            <div class="Products">
                                <img src="${p.image_route}">
                                <h2>${p.activity_name}<br><p>${p.city}</p></h2>
                                <div class="Price">
                                    from <label>${p.price} €</label><br>     
                                    <form method="POST" action="DescriptionController?option=byId&id=${p.id}" class="formFilter">
                                        <input class="priceButton" type="submit" value="Buy"/>
                                    </form>
                                </div>
                            </div>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </div>

            <c:if test="${sessionScope.user!= null}">
            <div id="Cart">
                <jsp:include page="cart.jsp" />
            </div>
            </c:if>
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
</body>

</html>