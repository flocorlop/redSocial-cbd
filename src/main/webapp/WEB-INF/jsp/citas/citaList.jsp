<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<petclinic:layout pageName="citas">
	<h2>Mis Citas</h2>

	<table id="citasTable" class="table table-striped">
		<c:if test="${cita.estadoCita!='cancelada' }">
		<thead>
			<tr>
				<th></th>
				<th>Fecha cita</th>
				<th>�Urgente?</th>
				<th>Tipo cita</th>
				<th>Veh�culo</th>
			</tr>
		</thead>
		</c:if>
	
		<tbody>
			<c:forEach items="${results}" var="cita" >
				
				<c:if test="${cita.estadoCita!= 'cancelada' }">
				<tr>
					<td><spring:url value="/cliente/citas/{citaId}" var="citaUrl">
							<spring:param name="citaId" value="${cita.id}" />
						</spring:url> <a href="${fn:escapeXml(citaUrl)}" class="btn btn-default">Ver cita</a></td>
					<td><c:out value="${cita.fechaCita}" /></td>
					<td><c:if test="${cita.esUrgente == 'TRUE'}">
							<c:out value="Si" />
						</c:if> <c:if test="${cita.esUrgente == 'FALSE'}">
							<c:out value="No" />
						</c:if></td>
					<td>
						<!-- REVISION,REPARACION,PREPARACION_ITV,MODIFICACION --> <c:if test="${cita.tipo == 'revision'}">
							<c:out value="Revisi�n" />
						</c:if> <c:if test="${cita.tipo == 'reparacion'}">
							<c:out value="Reparaci�n" />
						</c:if> <c:if test="${cita.tipo == 'preparacion_itv'}">
							<c:out value="Preparaci�n ITV" />
						</c:if> <c:if test="${cita.tipo == 'modificacion'}">
							<c:out value="Modificaci�n" />
						</c:if>
					</td>
					<td><c:out value="${cita.vehiculo.matricula}" /></td>

				</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-default" href='<spring:url value="/cliente/citas/pedir" htmlEscape="true"/>'>Pedir Cita</a>
	<table class="table-buttons">
	</table>
</petclinic:layout>
