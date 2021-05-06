<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <title>Main Page</title>
</head>


<style>

    .alertmessage{
        margin-top: 100px;
        left: 500px;
        width: 1000px;
    }

    .offset{
        margin-top: 100px;
        width: 1000px;
    }
</style>

<body>

<%-- --------- Display items --------------------   -----------------      --%>

<c:choose>
    <c:when test="${message}">
        <div class="alert alert-warning alert-dismissible fade show alertmessage" role="alert">
            <strong>Item has been put into cart</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:when>
</c:choose>

<div class="card-columns container offset" >

    <c:forEach var = "i" begin = "0" end = "${Item.length() - 1}">


    <input type="hidden" id="buttonName" value="" name="buttonName">

        <div class="card" >
            <img class="card-img-top" src="./images/items/${Item.get(i).getName()}.png" width="200" height="250">
            <div class="card-body text-center">
                <p class="card-text">Item Name: ${Item.get(i).getName()} </p>
                <p class="card-text">Total: $

                    <f:formatNumber type="number" pattern="0.00" value="${Item.get(i).getCost()}"/>

                </p>
                <a href="./ItemPage?ItemNumber=${i}" class="btn btn-primary stretched-link">See Item Details</a>
            </div>
        </div>


    </c:forEach>

</div>

<%-- ------------------- Navbar for the top ------------------  --%>

<jsp:include page="NavBar.jsp"/>

<h1>Welcome "${Username.getUsername()}"</h1>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>