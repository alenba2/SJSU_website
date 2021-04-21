<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<mvc:resources mapping="/resources/**" location="/resources/static/" />

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>

<style>
    *{
        margin:  0;
        padding: 0 ;
        font-family: 'Times New Roman' ;
        font-size: 15.75px;
    }

    #errorlabel
    {
        color: red;
    }
</style>

<head>
    <title>Sign Up</title>

    <link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" >
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"  rel="stylesheet"/>
</head>

<body>

    <div class="d-flex justify-content-center h-100">

        <div class="user_card">
            <div class="d-flex justify-content-center">
                <H1 > SignUp </H1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="brand_logo_container">
                    <img src="https://cdn.d1baseball.com/logos/teams/256/sanjosest.png" class="brand_logo" alt="Logo">
                </div>
            </div>
            <div class="d-flex justify-content-center form_container">
                <form:form style="position:fixed;width:25%; top: 200px" action="/SignUp" method="post" >
<%--                    <div class="input-group mb-3">--%>
<%--                        <input type="text" name="Name" class="form-control input_name" value="" placeholder="name">--%>
<%--                    </div>--%>
                    <br>
                    <br>
                    <a id="errorlabel"> ${message} </a>
                    <br>

                    <div class="input-group mb-3">
                        <input type="text" name="username" class="form-control input_user" value="" placeholder="username" required>
                    </div>
                    <div class="input-group mb-2">
                        <input type="password" name="password" class="form-control input_pass" value="" placeholder="password" required>
                    </div>

                    <div class="d-grid gap-2">
                        <button  id="submit" class="btn btn-warning rounded-pill">Sign Up</button>
                        <div class="d-flex justify-content-center">
                            <button onclick="location.href ='Login'" type="button"  class="btn btn-warning rounded-pill">Login</button>
                        </div>

                    </div>


                </form:form>
            </div>

        </div>
    </div>

</body>
</html>
