<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name=viewport" content="width=device-width, initial-scale=10">
    <title>Cart Page</title>

<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">--%>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>
    .card {
        background-color: #f8f9fb;
    <!-- -->
    }
</style>


<body>


<div class="container">

<%--    <c:forEach var="itemInCart" items="${cartArrList}">--%>
        <div class="card my-3">
            <div class="m-2 p-2 row">
                <div class="row">
                    <div class="col-2">
                        <img src="/images/items/${itemarr.get(0).getName()}.png" class="p-1 img-thumbnail">
                    </div>
                    <div class="col-10">
<%--                        <h2>${itemInCart.getName()}</h2>--%>
<%--                        <p>${itemInCart.getDescription()}</p>--%>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-2" align="center">
                        <div class="row ">

                            <div class="col text-center">
                                <form id="updateCart" action="Cart" method="post">

<%--                                    <c:forEach var="stockItem" items="${itemarr}">--%>
<%--                                        <c:if test ="${stockItem.getName().equals(itemInCart.getName())}">--%>
<%--                                            <c:set var = "itemInStock" scope = "page" value = "${stockItem}"/>--%>
<%--                                        </c:if>--%>
<%--                                    </c:forEach>--%>

                                    <label>Quantity: </label>
                                    <input type="number" name="quantity" style="width: 50px;" value="${itemInCart.getQuantity()}">
<%--                                    <p>In Stock: ${itemInStock.getQuantity()}</p>--%>
                                    <input type="submit" value="Submit"/>
                                    <input type="hidden" id="itemName" name="itemName" value="${itemInCart.getName()}"/>
                                </form>
                            </div>

                        </div>
                    </div>

                    <div class="col-10">
                        <div class="card-body text-end">


<%--                            <p class="card-text">(<fmt:formatNumber value="${itemInCart.getCost()}" type="currency"/>x) ---%>
<%--                                <fmt:formatNumber value="${itemInCart.getQuantity()*itemInCart.getCost()}" type="currency"/>--%>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%--    </c:forEach>--%>
<%--    <div class="text-end">--%>
<%--        <div class="col pt-1">--%>
<%--            <button class="btn btn-secondary" type="submit">Checkout</button>--%>
<%--        </div>--%>
<%--    </div>--%>



</div>

<%-- ------------------- Navbar for the top ------------------  --%>

<jsp:include page="NavBar.jsp"/>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"--%>
<%--        crossorigin="anonymous"></script>--%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
