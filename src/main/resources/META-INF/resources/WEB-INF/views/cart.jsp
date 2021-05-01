<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name=viewport" content="width=device-width, initial-scale=10">
    <title>title test</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>

<style>
    .card {
        background-color: #f8f9fb;
    <!-- -->
    }
</style>


<body>


<div class="container">
    <br>
    <br>
    <br>
    <br>

    <c:forEach var="itemInCart" items="${cartArrList}">


        <div class="card my-3">
            <div class="m-2 p-2 row">
                <div class="row">

                    <div class="col-2">
                        <img src=${itemInCart.getImageLocation()} class="p-1 img-thumbnail">
                    </div>

                    <div class="col-10">
                        <h2>${itemInCart.getName()}</h2>
                        <p>${itemInCart.getDescription()}</p>
                    </div>

                </div>

                <div class="row ">
                    <div class="col-2" align="center">
                        <div class="row ">

                            <div class="col text-center">
                                <form id="updateCart" action="Cart" method="post">

                                    <c:forEach var="stockItem" items="${itemarr}">
                                        <c:if test ="${stockItem.getName().equals(itemInCart.getName())}">
                                            <c:set var = "itemInStock" scope = "page" value = "${stockItem}"/>
                                        </c:if>
                                    </c:forEach>

                                    <label>Quantity: </label>
                                    <input type="number" name="quantity" style="width: 50px;" value="${itemInCart.getQuantity()}">
                                    <p>In Stock: ${itemInStock.getQuantity()}</p>
                                    <input type="submit" value="Submit"/>
                                    <input type="hidden" id="itemName" name="itemName" value="${itemInCart.getName()}"/>


                                </form>
                            </div>

                        </div>
                    </div>

                    <div class="col-10">
                        <div class="card-body text-end">

                            <p class="card-text">(<fmt:formatNumber value="${itemInCart.getCost()}" type="currency"/>x) -
                                <fmt:formatNumber value="${itemInCart.getQuantity()*itemInCart.getCost()}" type="currency"/>
                            </p>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>


    <div class="text-end">
        <div class="col pt-1">
            <button class="btn btn-secondary" type="submit">Checkout</button>
        </div>
    </div>


</div>


<jsp:include page="NavBar.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>
