<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <div>
        <div class="Filters">CART</div>
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
                <div id="${idNoted}">
                <label class="cartName">${productCart.key.activity_name}</label>
                <a class="cartCross" href="ProductListController?optionCart=remove&id=${productCart.key.id}"><i class="fas fa-times"></i></a><br>
                <label class="cartQty">${productCart.value} persons</label>
                <label class="cartPrice">${euros} €</label>
                <hr/>
                </div>
             </c:forEach>
        </c:if>
        <label>TOTAL: </label>
        <labe id="priceTotal">${sessionScope.cart.priceTotal} €</labe><br><br>
        <form method="POST" action="ConfirmCartController">
        <input type="submit" id="cartButton" value="Validate">
        </form>
    </div>

