<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<mvc:resources mapping="/resources/**" location="/resources/static/" />

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>

<head>
    <title>Login </title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<%--    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">--%>
    <link href="/css/login_reg.css" rel="stylesheet"/>
    <link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" >
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"  rel="stylesheet"/>
</head>

<body>
<div class="container h-100">
    <div class="d-flex justify-content-center h-100">
        <div class="user_card">
            <div class="d-flex justify-content-center">
                <div class="brand_logo_container">
                    <img src="https://cdn.d1baseball.com/logos/teams/256/sanjosest.png" class="brand_logo" alt="Logo">
                </div>
            </div>
            <div class="d-flex justify-content-center form_container">
                <form>
                    <div class="input-group mb-3">
<%--                        <div class="input-group-append">--%>
<%--                            <span class="input-group-text"><i class="fas fa-user"></i></span>--%>
<%--                        </div>--%>
                        <input type="text" name="" class="form-control input_user" value="" placeholder="username">
                    </div>
                    <div class="input-group mb-2">
<%--                        <div class="input-group-append">--%>
<%--                            <span class="input-group-text"><i class="fas fa-key"></i></span>--%>
<%--                        </div>--%>
                        <input type="password" name="" class="form-control input_pass" value="" placeholder="password">
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customControlInline">
                            <label class="custom-control-label" for="customControlInline">Remember me</label>
                        </div>
                    </div>
                    <div class="d-grid gap-2 ">
                        <button type="button" name="button" class="btn btn-warning rounded-pill" >Login</button>
                        <div class="d-flex justify-content-center">
                            <button type="button" name="button" class="btn btn-warning rounded-pill">Sign Up</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
