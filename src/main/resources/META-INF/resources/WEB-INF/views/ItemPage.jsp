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
<img src="./images/items/${Item.getName()}.png" width="200" height="250" id="ItemPic">
<%-- Description--%>
<div id="TextBox">
    <a>
        Item Name: ${Item.getName()}
    </a>
    <br>
    <br>
    <a>
        Cost: <a style="color:red">$<f:formatNumber type="number" pattern="0.00" value="${Item.getCost()}"/></a>
    </a>
    <br>
    <br>
    <a>
        Description: ${Item.getDescription()}
    </a>
</div>

<%-- Inventory Box --%>

<div id="InventoryBox" style="text-align: center">
    <form:form>
        <a>Item Availability:
            <a >
                <c:choose>
                    <c:when test="${Item.getStock()}">
                        <a style="color:Green">
                            In Stock
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a style="color:Red">
                            Out of Stock
                        </a>
                    </c:otherwise>
                </c:choose>
            </a>
        </a>
        <br>
        <br>
        <a>
            <label for="Stock">Stock: </label>
            <select name="Stock" id="Stock">
                <option default value="0">0</option>

                <c:forEach var = "i" begin = "1" end = "${Item.getQuantity()}">
                    <option value="${i}">${i}</option>
                </c:forEach>
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
