
<style>

    #header{
        background-color: #0055A2 ;
    }
    .navbar{
        overflow: hidden;
        position: fixed;
        top: 0; /* Position the navbar at the top of the page */
        width: 100%; /* Full width */
    }



</style>
<body>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<nav  class="navbar navbar-light" id="header">
    <a class="navbar-brand" href="./MainPage">
        <img src="/images/logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo">
    </a>

    <form class="form-inline" >
        <a class="btn btn-primary" style="height: 44px" >
            Logout
        </a>

        <a class="btn btn-primary" >
            <img src="/images/cog-8x.png" width="30" height="30" class="d-inline-block align-top" alt="cog">
        </a>

        <a href = './Cart' >
            <img src="/images/cart-8x.png" width="30" height="30" class="d-inline-block align-top" alt="cart">
        </a>
    </form>
</nav>



</body>