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
	<div class="team-boxed">
		<div class="container">
			<div class="intro">
				<h2 class="text-center">Posts</h2>
				<p class="text-center">Resultados de tu búsqueda.</p>
			</div>
			<div class="row people">
				<c:forEach items="${results}" var="p">
					<div class="col-md-6 col-lg-4 item">
						<div class="box">
							<p>
								<a class="btn btn-default" href='/fcl/posts/${p.id}/like'> <button type="button" class="btn btn-primary">Like </button></a>
							</p>

							<h3 class="name">
								@<c:out value="${uploadedBy.username}"></c:out>
							</h3>
							<p class="title">
								likes:
								<c:out value="${p.likes}"></c:out>
							</p>
							<p class="description">
								<c:out value="${p.text}"></c:out>
							</p>
							<a class="btn btn-default" href='/posts/${p.id}/'><button type="button" class="btn btn-outline-info" data-mdb-ripple-color="dark"> Detalles </button></a>
							
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
