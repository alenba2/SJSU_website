<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <title>Main Page</title>
</head>
<style>

    #header{
        background-color: #0055A2 ;
    }
    .navbar{
        /*overflow: hidden;*/
        /*border-radius: 0px;*/
        /*position: fixed;*/
        /*top: 0; !* Position the navbar at the top of the page *!*/
        /*width: 100%; !* Full width *!*/
    }


</style>
<body>

<%-- ------------------- Navbar for the top ------------------  --%>
<nav  class="navbar navbar-light" id="header">
    <a class="navbar-brand" href="#">
        <img src="/images/logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo">
    </a>

    <a class="navbar-brand">
        <img src="/images/cog-8x.png" width="30" height="30" class="d-inline-block align-top" alt="cog">
        <img src="/images/cart-8x.png" width="30" height="30" class="d-inline-block align-top" alt="cart">
    </a>
</nav>


<%-- ---------  items --------------------   -----------------      --%>


<div class="card-columns">

    <c:forEach var = "i" begin = "1" end = "20">
        <div class="card" >
            <img class="card-img-top" src="..." width="200" height="250">
            <div class="card-body text-center">
                <p class="card-text">Total: ${cost} </p>
                <p class="card-text">Stock: ${stock} </p>
                <button class="btn btn-primary">-</button> 6 <button class="btn btn-primary">+</button>
            </div>
        </div>
        <br>
    </c:forEach>

</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
