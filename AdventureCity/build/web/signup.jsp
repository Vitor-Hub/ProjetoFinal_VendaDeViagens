<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AdventureCity</title>
        <link href="css/index.css" type="text/css" rel="stylesheet"/>
        <script language= "javascript" src="js/script.js"></script>       
    </head>
    <body>
        <a href="/AdventureCity/"><img src="image/logo.png" id="logo2"></a>


<div id="signin2">

    <h1>Create Account</h1><br><br>
    <form method="POST" action="SignupController" class="formSignup" name="formSignup" onsubmit="javascript:return signup();">
        <label>Choose Username<span style="color: red;" class="requis">*</span></label><br>
        <input type="text" id="username" name="username"><br>
        <p style="color: red" id="pUser"></p>
        <label>Email<span style="color: red;" class="requis">*</span></label><br>
        <input type="text" id="email" name="email"><br>
        <p style="color: red" id="pEmail"></p>
        <label>Password<span style="color: red;" class="requis">*</span></label><br>
        <input type="password" id="password" name="password" ><br>
        <p style="color: red" id="pPassword"></p>
        <label>Repeat password<span style="color: red;" class="requis">*</span></label><br>
        <input type="password" id="pwd-repeat"><br>
        <p style="color: red" id="pRepeat"></p>
        <input type="submit" value="Sign-in" class="button_Sign"/>	
    </form>
    </body>
</html>
