<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	

            
            <div id="container">
                <header id="header" style="position:fixed; z-index: 2;">
                    <div id="menu" >				
			<div id= "bar">
                            <a href="/AdventureCity/"><img src="image/logo.png" id="logo"></a>
                            <form method="POST" action="ProductListController" class="formSearch" name="formSearch" onsubmit="javascript:return validar();">
                                <select name="citySearch" size="1">
                                    <option selected>Cities</option>
                                    <option>London</option>
                                    <option>Paris</option>
                                    <option>Madrid</option>
                                    <option>Prague</option>
                                </select>
                                <input type="text" placeholder="Search.." name="product">
                                <input type="submit" value="Search" />
                            </form>
			<div class="dropdown">
                            <c:choose>
                                <c:when test="${sessionScope.user== 'admin'}">
                                    <a onclick="myFunctionAdmin()" class="dropbtn">Admin </a>
                                </c:when>
                                <c:when test="${sessionScope.user!= null}">
                                    <a onclick="myFunctionUser()" class="dropbtn">Hello ${sessionScope.user} </a>
                                </c:when>
                                <c:when test="${sessionScope.user== null}">
                                    <a onclick="myFunction()" class="dropbtn">Sign in</a>
                                </c:when>
                            </c:choose>
				<!--       DropDown Sign-in        -->
				<div id="myDropdown" class="dropdown-content">
                                    <div id="signin">
                                        <h1>Sign-in</h1><br><br>
                                        <form method="POST" action="LoginController" class="formLogin" name="formLogin">
                                        <div>
                                            <label>Username</label><br>
                                            <input type="text" name="username"><br>
                                        </div>
                                        <div>
                                            <label>Password</label><br>
                                            <input type="password" name="password"><br>
                                        </div>
                                        <input type="submit" value="Sign-in" id="divSignButton" />
                                        </form>
                                        <hr style="width: 76%; margin-left: 15px;">
                                        <h2>New Customer?</h2>
                                        <a href="signup.jsp" id="divSignButton">Sign-up</a>																			
                                    </div>
				</div>
                                
                                <!--       DropDown User        -->
				<div id="myDropdownUser" class="dropdown-content">
                                    <div id="signin">
                                        <h1>Menu</h1>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="SettingsController?user=${sessionScope.user}" id="divSignButton">Settings and informations</a>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="PreviousController?user=${sessionScope.user}" id="divSignButton">Previous Order</a>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="LogoutController" id="divSignButton">Logout</a>																			
                                    </div>
				</div>
                                <!--       DropDown Admin        -->
				<div id="myDropdownAdmin" class="dropdown-content">
                                    <div id="signin">
                                        <h1>Menu</h1>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="ChangeController" id="divSignButton">Product settings</a>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="create.jsp" id="divSignButton">Create Product</a>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a onclick="indisponible()" id="divSignButton">Statistics</a>
                                        <hr style="width: 85%; margin-left: 15px;">
                                        <a href="LogoutController" id="divSignButton">Logout</a>																			
                                    </div>
				</div>
                                
			</div>
			</div>
                        <div id="All_products">
					
			<a href="ProductListController">All products</a>

                            <img src="image/london.jpg">
                            <a href="ProductListController?option=London">London</a>

                            <img src="image/paris.jpg">
                            <a href="ProductListController?option=Paris">Paris</a>

                            <img src="image/madrid.jpg">
                            <a href="ProductListController?option=Madrid">Madrid</a>

                            <img src="image/pragues.jpg">
                            <a href="ProductListController?option=Prague">Pragues</a>				
			</div>
                    </div>
                </header>
            </div>
            
