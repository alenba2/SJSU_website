<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <title>Item Page</title>
</head>




<style>
    #ItemPic{
        margin-top: 100px;
        margin-left: 100px;
    }
    #TextBox{
        position: relative;
        top: -250px;
        left: 350px;
        width: 500px;
    }
    #InventoryBox{
        position:relative;
        float:right;
        right:50px;
        top: -400px;

        width: 350px;
        padding: 20px;
        border-radius: 25px;
        background-color: #e9ecef;


    }
</style>

<body>

<%-- --------- Display item --------------------   -----------------      --%>

<%-- Image --%>
<img src="..." width="200" height="250" id="ItemPic">
<%-- Description--%>
<div id="TextBox">
    <a>
        Item Name: Banana
    </a>
    <br>
    <br>
    <a>
        Cost: <a style="color:red">$13.01</a>
    </a>
    <br>
    <br>
    <a>
        Description: This is a godly Banana from the Bahamas, which tells no tales of blood and glory. This banana should be in a museum instead of the market
    </a>
</div>

<%-- Inventory Box --%>

<div id="InventoryBox" style="text-align: center">
    <form:form>
        <a>Item Availability: <a style="color: green">Yes</a></a>
        <br>
        <br>
        <a>
            <label for="Stock">Stock: </label>
            <select name="Stock" id="Stock">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
        </a>
        <br>
        <br>
        <button type="submit" class="btn btn-warning" > Checkout </button>
    </form:form>
</div>

<%-- ------------------- Navbar for the top ------------------  --%>

<jsp:include page="NavBar.jsp"/>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>