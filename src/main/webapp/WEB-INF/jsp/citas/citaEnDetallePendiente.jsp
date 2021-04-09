<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<petclinic:layout pageName="cita">

	<h2>Detalles de la cita</h2>


	<table class="table table-striped">
		<tr>
			<th>Fecha de la Cita</th>
			<td><c:out value="${cita.fechaCita}" /></td>
		</tr>


		<tr>
			<th>Descripcion</th>
			<td><c:out value="${cita.descripcion}" /></td>
		</tr>
		<tr>
			<th>Tipo de la cita</th>
			<td><c:if test="${cita.tipo == 'revision'}">
					<c:out value="Revision" />
				</c:if> <c:if test="${cita.tipo == 'reparacion'}">
					<c:out value="Reparacion" />
				</c:if> <c:if test="${cita.tipo == 'preparacion_itv'}">
					<c:out value="Preparacion ITV" />
				</c:if> <c:if test="${cita.tipo == 'modificacion'}">
					<c:out value="Modificacion" />
				</c:if></td>
		</tr>
		<tr>
			<th>Tiempo</th>
			<td><c:out value="${cita.tiempo}" /></td>
		</tr>
		<tr>
			<th>Coste</th>
			<td><c:out value="${cita.coste}" /></td>
		</tr>
		<tr>
			<th>Estado cita</th>
			<td><c:out value="${cita.estadoCita}" /></td>
		</tr>
		<tr>
			<th>�Es urgente?</th>
			<td><c:if test="${cita.esUrgente == 'TRUE'}">
					<c:out value="Si" />
				</c:if> <c:if test="${cita.esUrgente == 'FALSE'}">
					<c:out value="No" />
				</c:if></td>
		</tr>
		<sec:authorize access="hasAnyAuthority('mecanico')">
			<tr>
				<th>Vehiculo</th>
				<td><c:out value="${cita.vehiculo.modelo}: ${cita.vehiculo.matricula}" /></td>
			</tr>
		</sec:authorize>
	</table>


	<sec:authorize access="hasAnyAuthority('mecanico')">
		<a class="btn btn-default" href='<spring:url value="/mecanicos/citasPendientes" htmlEscape="true"/>'>Volver</a>
	</sec:authorize>


</petclinic:layout>
