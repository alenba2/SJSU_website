<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="iso-8859-1"%>
<mvc:resources mapping="/resources/**" location="/resources/static/" />
<html>

<head>
    <title>Login And Registration Form</title>
    <link href="/css/style.css" rel="stylesheet"/>

</head>

<body>
<div class="hero">
    <div class="form-box">
        <div class="button-box">
            <div id="btn"></div>
            <button type="button" class="toggle-btn" onclick="login()">Log In</button>
            <button type="button" class="toggle-btn" onclick="register()">Register</button>
        </div>
        <form id = "login" class="input-group">
            <input id="userID-login" type="text" class="input-field" placeholder="User Id"
                   required>
            <input id="pass-login" type="password" class="input-field"
                   placeholder="Enter password" required>
            <input type="checkbox" class="check-box"><span>Remember
                    Password</span>
            <button id="login-btn" type="submit" class="submit-btn">Log in</button>
        </form>
        <form id = "register" class="input-group">
            <input type="text" class="input-field" placeholder="User Id"
                   required>
            <input type="email" class="input-field" placeholder="Email Id"
                   required>
            <input type="password" class="input-field"
                   placeholder="Enter password" required>
            <input type="checkbox" class="check-box"><span>I agree to the terms and conditions</span>
            <button type="submit" class="submit-btn">Register</button>
        </form>
    </div>

</div>

<script type="text/javascript">

    document.getElementById("login-btn").onclick = function() {
        window.location.href = "HomePage.html"
        // if(document.getElementById("userID-login").nodevalue === "hello"){
        //     if(document.getElementById("pass-login").nodevalue === "1234"){
        //         window.location.href = "HomePage.html"
        //     }
        // }
    }

    document.getElementsByClassName("submit-btn").hover= function(){
        alert("you have login!")

    }


    var x = document.getElementById("login")
    var y = document.getElementById("register")
    var z = document.getElementById("btn")

    function register(){
        x.style.left = "-400px";
        y.style.left = "50px"
        z.style.left = "110px"
    }

    function login(){
        x.style.left = "50px";
        y.style.left = "450px"
        z.style.left = "0px"
    }

</script>




</body>

</html>