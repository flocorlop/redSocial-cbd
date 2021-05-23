<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Mini Red Social</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#!">Mini Red Social</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#!">Home<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container">
		<!-- Jumbotron Header-->
		<header class="jumbotron my-4">
			<h1 class="display-3">Bienvenid@</h1>
			<p class="lead">Aplicación web donde podrás ver posts
				(publicaciones de texto), dar me gusta (like) y seguir personas.</p>
			<a class="btn btn-primary btn-lg" href="/posts">Ver posts</a> <a
				class="btn btn-primary btn-lg" href="/persons/">Ver personas</a> <a
				class="btn btn-primary btn-lg" href="/hobbies/all">Ver hobbies</a>
		</header>
		<!-- Page Features-->
		<a class="btn btn-primary btn-lg btn-block" href="/admin/posts/new">Crear
			un post</a> <br> <a class="btn btn-primary btn-lg btn-block"
			href="/admin/posts/new">Crear una persona</a> <br> <a
			class="btn btn-primary btn-lg btn-block" href="/admin/posts/new">Crear
			un hobby</a> <br>
		<div class="row text-center">

			<div class="col-lg-4 col-md-6 mb-4">

				<div class="card h-100">

					<div class="card-body">
						<h4 class="card-title">Filtro por número de likes</h4>
						<p class="card-text">Aparecerán los posts que tengan mayor
							igual a ese número de likes.</p>
					</div>
					<div class="card-footer">
						<form action="/posts/filters/likes/${num}" method="get">
							<label for="num">Número de likes:</label><br> <input
								type="number" id="num" name="num"><br>

							<button class="btn btn-default" type="submit">Filtrar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">

					<div class="card-body">
						<h4 class="card-title">Búsqueda por texto</h4>
						<p class="card-text">Aparecerán los posts que coincidan el
							texto con la descripción del post.</p>
					</div>
					<div class="card-footer">
						<form action="/posts/searchByText/" method="get">
							<label for="text">Texto:</label><br> <input type="text"
								id="text" name="text"><br>

							<button class="btn btn-default" type="submit">Buscar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="card h-100">

					<div class="card-body">
						<h4 class="card-title">Búsqueda que contenga alguna palabra</h4>
						<p class="card-text">Aparecerán los posts que contengan alguna
							palabra en la descripción de los posts.</p>
					</div>
					<div class="card-footer">
						<form action="/posts/containsText/" method="get">
							<label for="text">Texto:</label><br> <input type="text"
								id="text" name="text"><br>

							<button class="btn btn-default" type="submit">Buscar</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright © 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>

</html>