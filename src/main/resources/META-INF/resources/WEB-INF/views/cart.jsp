<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name=viewport" content="width=device-width, initial-scale=10">
    <title>Cart Page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>
    .card {
        background-color: #f8f9fb;
    <!-- -->
    }
    .offset {
        margin-top: 100px;
    }
    .Checkout{
        float: right;
        right: 30px;
        width: 300px;
        position: fixed;

    }
</style>


<body>



<div class="container offset">

    <c:choose>
        <c:when test="${message}">
            <div class="alert alert-danger alert-dismissible fade show alertmessage" role="alert">
                <strong>${messageString}</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:when>
    </c:choose>

    <c:choose>


        <%--    Checks if Cart has more than one item   --%>
    <c:when test="${cartArrList.length() > 0}">

        <form action="Cart" method="post">
        <div class="card Checkout offset">
            <p class="card-body">
                Items Cost:
                <a style="float: right">
                    $<f:formatNumber type="number" pattern="0.00" value="${cartArrList.getCost()}"/>
                </a>

                <br>
                <br>
                Tax:
                <a style="float: right">
                    $<f:formatNumber type="number" pattern="0.00" value="${cartArrList.getCost()-cartArrList.getCost() * .9}"/>
                </a>
                <br>
                <br>
                Grand Total:
                <a style="float: right">
                    $<f:formatNumber type="number" pattern="0.00" value="${cartArrList.getCost()-cartArrList.getCost() * .9 + cartArrList.getCost()}"/>
                </a>
                <br>
                <br>


                    <%--       Checkout Button   --%>
                    <%--        <a class="btn btn-secondary" type="submit" name="checkout" style="color:white">Checkout</a>--%>

                <button type="submit" class="btn btn-secondary" name="Checkout"> Checkout </button>

            </p>
        </div>
        </form>

            <c:forEach var = "i" begin = "0" end = "${cartArrList.length()-1}">
                <div class="card my-3">
                    <div class="m-2 p-2 row">
                        <div class="row">
                            <div class="col-2">
                                <img src="/images/items/${cartArrList.get(i).getName()}.png" class="p-1 img-thumbnail">
                            </div>
                            <div class="col-10">
                                <h2>${cartArrList.get(i).getName()}</h2>
                                <p>${cartArrList.get(i).getDescription()}</p>
                            </div>
                        </div>
                        <div class="row ">
                            <div class="col-2" >
                                <div class="row ">
                                    <div class="col ">
                                        <form id="updateCart" action="Cart" method="post">

                                            <div style="width: 100px">Stock:

                                                    <c:forEach var = "j" begin = "0" end="${itemarr.length()-1}">

                                                        <c:if test="${itemarr.get(j).getName().equals(cartArrList.get(i).getName())}">

                                                            ${itemarr.get(j).getQuantity()}

                                                        </c:if>

                                                    </c:forEach>




                                            </div>

                                            <div style="width: 100px">Current: ${cartArrList.get(i).getQuantity()}
                                            </div>

                                            <label>Quantity:
                                                <input type="number" name="quantity" style="width: 50px;" value="${cartArrList.get(i).getQuantity()}">
                                            </label>
                                            <div style="width: 200px">
                                                <button type="submit" class="btn btn-primary" name="Submit" > Submit </button>

                                                <button type="submit" class="btn btn-danger" name="Delete"> Delete </button>
                                            </div>




                                            <input type="hidden" id="itemNumber" name="itemNumber" value="${i}"/>
                                        </form>
                                    </div>



                                </div>
                            </div>

                            <div class="col-10">
                                <div class="card-body text-end">


                                    <p class="card-text">
                                        Cost:
                                        <fmt:formatNumber value="${cartArrList.get(i).getCost()}" type="currency"/>
                                    </p>

                                    <p class="card-text">
                                        Total:
                                        <fmt:formatNumber value="${cartArrList.get(i).getQuantity()*cartArrList.get(i).getCost()}" type="currency"/>
                                    </p>

                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>



        </c:when>


<%--Prints this when there are none in cart--%>
    <c:otherwise>
        No Items Here..
        <br>
        Please Checkout an Item
    </c:otherwise>


    </c:choose>

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
