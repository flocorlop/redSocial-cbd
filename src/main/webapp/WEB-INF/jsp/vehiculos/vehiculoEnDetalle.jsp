<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<petclinic:layout pageName="vehiculo">

	<h2>Detalles de su veh�culo</h2>


	<table class="table table-striped">
		<tr>
			<th>Tipo de veh�culo</th>
			<td>
				<!-- REVISION,REPARACION,PREPARACION_ITV,MODIFICACION --> <c:if
					test="${vehiculo.tipoVehiculo == 'turismo'}">
					<c:out value="Turismo" />
				</c:if> <c:if test="${vehiculo.tipoVehiculo == 'deportivo'}">
					<c:out value="Deportivo" />
				</c:if> <c:if test="${vehiculo.tipoVehiculo == 'todoterreno'}">
					<c:out value="Todoterreno" />
				</c:if> <c:if test="${vehiculo.tipoVehiculo == 'camion'}">
					<c:out value="Cami�n" />
				</c:if> <c:if test="${vehiculo.tipoVehiculo == 'furgoneta'}">
					<c:out value="Furgoneta" />
				</c:if>
			</td>
		</tr>
		<tr>
			<th>Modelo</th>
			<td><c:out value="${vehiculo.modelo}" /></td>
		</tr>
		<tr>
			<th>Matr�cula</th>
			<td><c:out value="${vehiculo.matricula}" /></td>
		</tr>
		<tr>
			<th>Fecha de matriculaci�n</th>
			<td><c:out value="${vehiculo.fechaMatriculacion}" /></td>
		</tr>
		<tr>
			<th>Kilometraje</th>
			<td><c:out value="${vehiculo.kilometraje}" /></td>
		</tr>
	</table>

	<sec:authorize access="hasAnyAuthority('cliente')">

		<td><spring:url value="/cliente/vehiculos/{vehiculoId}/averias"
				var="averiasUrl">
				<spring:param name="vehiculoId" value="${vehiculo.id}" />
			</spring:url> <a href="${fn:escapeXml(averiasUrl)}" class="btn btn-default">Listar
				Aver�as</a></td>

		<spring:url value="/cliente/vehiculos/{vehiculoId}/disable"
			var="disableUrl">
			<spring:param name="vehiculoId" value="${vehiculo.id}" />
		</spring:url>
		<a href="${fn:escapeXml(disableUrl)}" class="btn btn-default">Dar
			de baja vehiculo</a>

		<a class="btn btn-default"
			href='<spring:url value="/cliente/vehiculos" htmlEscape="true"/>'>Volver</a>

	</sec:authorize>

	<sec:authorize access="hasAnyAuthority('mecanico')">

		<a class="btn btn-default"
			href='<spring:url value="/mecanicos/citas" htmlEscape="true"/>'>Volver</a>

	</sec:authorize>

</petclinic:layout>
