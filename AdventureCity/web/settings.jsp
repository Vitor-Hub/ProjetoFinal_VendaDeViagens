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

            <div style="display: flex;">
                <div>
                    <div class="settings_inside">
                        <h2>UserName :</h2>
                        <label>${userInfo.username}</label><br><br>
                        <form method="POST" action="SettingsController?option=Username&user=${sessionScope.user}" class="infoForm" onsubmit="javascript:return username();">
                            <input name="usernameS" id="usernameS" type="text">
                            <button>Modify</button>
                        </form>
                    </div>

                    <div class="settings_inside">
                        <div>
                            <h2>Email :</h2>
                            <label>${userInfo.email}</label><br><br>
                        </div>
                        <form method="POST" action="SettingsController?option=Email&user=${sessionScope.user}" class="infoForm"  onsubmit="javascript:return email();">
                            <input name="email" id="emailS" type="text">
                            <button>Modify</button>
                        </form>
                    </div>

                    <div class="settings_inside">
                        <div>
                            <h2>Password :</h2>
                            <label>****************</label><br><br>
                        </div>

                        <form method="POST" action="SettingsController?option=Password&user=${sessionScope.user}" class="infoForm" onsubmit="javascript:return password();">
                            <input id="passwordS" name="password" type="password" placeholder="Password">
                            <input id="reapeatS" type="password" placeholder="Repeat Password">
                            <button>Modify</button>
                        </form>
                    </div>
                </div>
            </div>
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
