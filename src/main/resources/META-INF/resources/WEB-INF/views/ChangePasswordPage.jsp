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
    <title>Change Password</title>
    <link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" >
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"  rel="stylesheet"/>
</head>

<body>

<div class="d-flex justify-content-center h-100">
    <div class="user_card">
        <div class="d-flex justify-content-center">
            <H1> Change Password </H1>
        </div>

        <div class="d-flex justify-content-center">
            <div class="brand_logo_container">
                <img src="https://cdn.d1baseball.com/logos/teams/256/sanjosest.png" class="brand_logo" alt="Logo">
            </div>
        </div>
        <div class="d-flex justify-content-center form_container">
            <form:form style="position:fixed;width:25%; top: 200px" action="/ChangePassword" method="post">
                <br>
                <br>

                <br>
                <div class="input-group mb-3">

                    <input type="text" name="password" class="form-control input_user" value="" placeholder="Old password" required>
                </div>
                <div class="input-group mb-2">

                    <input type="password" name="newPassword" class="form-control input_pass" value="" placeholder="New Password" required>
                </div>
                <div class="d-grid gap-2 ">
                    <button type="submit"  class="btn btn-warning rounded-pill" >Change Password</button>
                </div>
            </form:form>

        </div>

    </div>
</div>

</body>
</html>
