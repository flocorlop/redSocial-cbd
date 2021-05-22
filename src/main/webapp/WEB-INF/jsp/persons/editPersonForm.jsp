<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link href="<c:url value="/resources/css/style3.css" />"
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
	<h2>Nuevo usuario</h2>
	<div class="page-content page-container" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-xl-10">
					<div class="card user-card-full">
						<div class="row m-l-0 m-r-0">
							<div class="col-sm-4 bg-c-lite-green user-profile">
								<div class="card-block text-center text-white">
									<div class="m-b-25">
										<img src="https://cdn.onlinewebfonts.com/svg/img_227642.png"
											class="img-radius" alt="User-Profile-Image" width=60%>
									</div>
									<h3 class="f-w-600">
										@
										<c:out value="${myself}"></c:out>
									</h3>
									<!-- 									<p>Web Designer</p> -->
									<i
										class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="card-block">
									<h4 class="m-b-20 p-b-5 b-b-default f-w-600">Contenido</h4>
									<div class="row">
										<div class="col-sm-10">
											<div class="m-b-10 f-w-600">
												<form action="/persons/${p.id}/edit" method="POST">
													<label for="fname">First name:</label><br> <input
														type="text" id="firstName" name="firstName" value="${p.firstName}"><br>
													<label for="lname">Last name:</label><br> <input
														type="text" id="lastName" name="lastName" value="${p.lastName}"><br>
													<label for="lname">Username:</label><br> <input
														type="text" id="username" name="username" value="${p.username}"><br>
													<br> <input type="submit" value="Submit">
												</form>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<a class="btn btn-primary" href='/persons/all'>Cancelar, ver todos los
				usuarios</a>
		</div>
	</div>


</body>
</html>