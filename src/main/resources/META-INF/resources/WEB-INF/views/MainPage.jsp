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

<%
    //    int[] att = (int[]) request.getAttribute("num");
//    session.setAttribute("change", 5);

%>


<style>
    .offset{
        margin-top: 100px;
        width: 1000px;
    }
</style>

<body>

<%-- --------- Display items --------------------   -----------------      --%>



<div class="card-columns container offset" >

<%--    <c:forEach var = "i" begin = "0" end = "8">--%>
<form:form action="/" method="post">

    <input type="hidden" id="buttonName" value="" name="buttonName">

        <div class="card" >
            <img class="card-img-top" src="..." width="200" height="250">
            <div class="card-body text-center">
                <p class="card-text">Total: ${cost} </p>
                <p class="card-text">Stock: ${stock} </p>
                <button class="btn btn-primary" onclick="decrement_value(0)" type="submit">-</button>


                ${num[0]}



                <button class="btn btn-primary">+</button>
            </div>
        </div>
        <%--    </c:forEach>--%>
</form:form>
<%--    <c:set target="${num}" value="1"/>--%>


</div>

<%-- ------------------- Navbar for the top ------------------  --%>

<jsp:include page="NavBar.jsp"/>

<script language="JavaScript">
    function decrement_value(i){
        document.getElementById("buttonName").value = i;

    }

</script>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
