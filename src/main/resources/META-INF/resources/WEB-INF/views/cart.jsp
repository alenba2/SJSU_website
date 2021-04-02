<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name=viewport" content="width=device-width, initial-scale=10">
    <title>title test</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>

<style>
    .card{
        background-color: #F8F9FB;
    <!-- -->
    }
</style>


<body>



<div class="container">

    <%! int loopCount; %>
    <%for (loopCount = 0; loopCount < 4; loopCount++) { %>
    <div class="card my-3">
        <div class="m-2 p-2 row">
            <div class="row">

                <div class="col-2">
                    <img src="https://i5.walmartimages.com/asr/229226f5-c5a9-425b-b411-9484aa23e845_1.06a852888d9c1b507db92f8a013b466b.jpeg"
                         class="p-1 img-thumbnail">
                </div>

                <div class="col-10">
                    <h2>Item Name</h2>
                </div>

            </div>

            <div class="row ">
                <div class="col-2">
                    <div class="row">
                        <div class="col text-center">
                            <button class="btn btn-primary" type="submit">-</button>
                        </div>
                        <div class="col text-center">
                            <h3>#</h3>
                        </div>
                        <div class="col text-center">
                            <button class="btn btn-primary" type="submit">+</button>
                        </div>
                    </div>
                </div>

                <div class="col-10">
                    <div class="card-body text-end">
                        <p class="card-text">price</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>

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
