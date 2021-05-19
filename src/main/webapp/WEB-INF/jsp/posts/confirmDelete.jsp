<%-- <%@ page session="false" trimDirectiveWhitespaces="true"%> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%> --%>

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
	<h2>¿Está seguro de borrar el post?</h2>

	<form:form>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<form action="/fcl/posts/${p.id}/delete" method="post">
					<button type="submit" class="btn btn-primary">Borrar post
					</button>
				</form>
			</div>
		</div>
	</form:form>
	<a class="btn btn-default"
		href='<spring:url value="/posts" htmlEscape="true"/>'>Volver</a>

</body>
</html>
