<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="page-content page-container" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-xl-10">
					<div class="card user-card-full">
						<div class="row m-l-0 m-r-0">
							<div class="col-sm-4 bg-c-lite-green user-profile">
								<div class="card-block text-center text-white">
									<div class="m-b-25">
										<img src="https://img-premium.flaticon.com/png/512/747/747376.png?token=exp=1621188987~hmac=a69c01f739764f88be3b7e75a2482fe3"
											class="img-radius" alt="User-Profile-Image" width=60%>
									</div>
									<h3 class="f-w-600">
										@<c:out value="${uploadedBy.username}"></c:out>
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
											<p class="m-b-10 f-w-600"><c:out value="${post.text}"></c:out></p>
											
										</div>

									</div>
									<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">
										N�mero de likes:
										<c:out value="${post.likes}" />
									</h6>
									<div class="row">
										<div class="col-sm-10">
											<p class="m-b-10 f-w-600">"Likers":</p>
											<h6 class="text-muted f-w-400">

												<c:forEach items="${likedBy}" var="l">
													<p>
														@<c:out value="${l.username}"></c:out>
													</p>
												</c:forEach>

											</h6>
										</div>
										
									</div>
									<!-- <ul class="social-link list-unstyled m-t-40 m-b-10">
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="facebook" data-abc="true"><i
												class="mdi mdi-facebook feather icon-facebook facebook"
												aria-hidden="true"></i></a></li>
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="twitter" data-abc="true"><i
												class="mdi mdi-twitter feather icon-twitter twitter"
												aria-hidden="true"></i></a></li>
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="instagram" data-abc="true"><i
												class="mdi mdi-instagram feather icon-instagram instagram"
												aria-hidden="true"></i></a></li>
									</ul> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>