<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 

  
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Mini Red Social</title><!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"><!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container"><a class="navbar-brand" href="#!">Mini Red Social</a><button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a class="nav-link" href="#!">Home<span class="sr-only">(current)</span></a></li>
                    <li class="nav-item"><a class="nav-link" href="about">About</a></li>
                </ul>
            </div>
        </div>
    </nav><!-- Page Content-->
    <div class="container">
        <!-- Jumbotron Header-->
        <header class="jumbotron my-4">
            <h1 class="display-3">Bienvenid@</h1>
            <p class="lead">Aplicación web donde podrás ver posts (publicaciones de texto), dar me gusta (like) y seguir personas.</p><a class="btn btn-primary btn-lg" href="/posts">Ver posts</a>
        </header><!-- Page Features-->
       
    </div><!-- Footer-->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright © 2021</p>
        </div>
    </footer><!-- Bootstrap core JS-->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script><!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>

</html>