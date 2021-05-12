<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <title>Purchase History Page</title>
</head>

<style>
    .container {
        padding-top: 20px;
    }

    #heading {
        text-align: center;
        padding-top: 100px;
    }

    #back-btn {
        padding-top: 50px;
    }

</style>

<body>

<h1 id="heading">Purchase History</h1>

<c:choose>
    <c:when test="${History.size() > 0}">

        <div class="container">
            <c:forEach var = "i" begin = "0" end = "${History.size() - 1}">
            <a href="#" class="list-group-item list-group-item-action">
                Purchase date: ${History.get(i).getDate()}
<%--                <span style="float:right; color:green;"> ${History.get(i).getTotal()}</span>--%>
                <span style="float:right; color:green;"> $<f:formatNumber type="number" pattern="0.00" value="${History.get(i).getTotal()}"/></span>
                <span style="float:right;">Total: </span>
            </a>
            </c:forEach>
        </div>

        <div id="back-btn" class="text-center">
                <%--    <button type="button" class="btn btn-primary">Go back</button>--%>
            <a class="btn btn-primary" href="./AccountSettings">Go back</a>
        </div>

    </c:when>

    <c:otherwise>
        No Items Here..
        <br>
        Please purchase items first
    </c:otherwise>
</c:choose>


<jsp:include page="NavBar.jsp"/>

<script>
</script>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>