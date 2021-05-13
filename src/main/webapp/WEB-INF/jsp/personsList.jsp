<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h2>Personas</h2>


<table id="ownersTable" class="table table-striped">
	<thead>
		<tr>
			<th style="width: 150px;">Nombre</th>
			<th>Usuario</th>
			<th style="width: 120px">Seguidores</th>
			<th>Seguidos</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td><spring:url value="/person/{personId}" var="personUrl">
						<spring:param name="personId" value="${person.id}" />
					</spring:url> <a href="${fn:escapeXml(personUrl)}"><c:out
							value="${person.firstName} ${person.lastName}" /></a></td>
				<td><c:out value="${person.username}" /></td>
				<td><c:out value="${person.follows}" /></td>
				<td><c:out value="${person.followers}" /></td>

			</tr>
		</c:forEach>
	</tbody>
</table>
