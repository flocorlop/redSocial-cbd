<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link href="<c:url value="/resources/css/style2.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mini red social</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<body>
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
					<li class="nav-item active"><a class="nav-link" href="/">Home<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="/about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="team-boxed">
		<div class="container">
			<div class="intro">
				<h2 class="text-center">Hobbies</h2>
				<p class="text-center">Aquí encontrarás todos los hobbies.</p>
				<a class="btn btn-primary btn-lg btn-block" href="/hobbies/new">Crear
					hobby</a> <br>
			</div>
			<div class="row people">
				<c:forEach items="${hobbies}" var="h">
					<div class="col-md-6 col-lg-4 item">
						<div class="box">
							<h3 class="firstName">
								<c:out value="${h.name}"></c:out>
							</h3>
<!-- 							<p class="title"> -->
<!-- 								Personas: -->
<%-- 								<c:out value="${h.name}"></c:out> --%>
<!-- 							</p> -->
							<a class="btn btn-default" href='/hobbies/${h.name}/'><button
									type="button" class="btn btn-outline-info"
									data-mdb-ripple-color="dark">Detalles</button></a>
							<a class="btn btn-default" href='/hobbies/admin/join/${h.name}/'><button
									type="button" class="btn btn-outline-success"
									data-mdb-ripple-color="dark">Unirse</button></a> 
							<a	class="btn btn-default" href='/hobbies/${h.id}/edit'><button
									type="button" class="btn btn-outline-info"
									data-mdb-ripple-color="dark">Editar</button></a> 
							<a	class="btn btn-default" href='/hobbies/${h.id}/delete'><button
									type="button" class="btn btn-outline-danger"
									data-mdb-ripple-color="dark">Eliminar</button></a>

						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>