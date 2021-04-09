<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="vehiculo">
	
	<jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#fechaMatriculacion").datepicker({dateFormat:"yy-mm-dd"});
            });
        </script>
    </jsp:attribute>
	<jsp:body>
	<h2>Nuevo vehiculo</h2>
	<form:form modelAttribute="vehiculo" class="form-horizontal" id="add-vehiculo-form">
		<div class="form-group has-feedback">
			<petclinic:inputField label="Matricula" placeholder="9999XXX" name="matricula" required="true" pattern="^\\d{4}[A-Z]{3}$" title="Una matricula esta compuesta por 4 numeros y 3 letras"/>
			      <petclinic:inputField label="Fecha de matriculacion" name="fechaMatriculacion" required="true" placeholder="yyyy-mm-dd" pattern="^\\d{4}[-]\\d{2}[-]\\d{2}$" title="El formato de fecha es: yyyy-mm-dd"/>
			      <petclinic:inputField label="Modelo" name="modelo" required="true"/>
			      <petclinic:inputField label="Kilometraje" name="kilometraje" required="true" pattern="^\\d{1,6}$" title="Debe ser un numero positivo" />

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<table class="error-title">
						<tr>

							<th>Tipo de veh�culo</th>
							<td><select name="tipoVehiculo">
									<option value="turismo">Turismo</option>
									<option value="deportivo">Deportivo</option>
									<option value="todoterreno">TodoTerreno</option>
									<option value="camion">Camion</option>
									<option value="furgoneta">Furgoneta</option>
							</select></td>
						</tr>
					</table>
				</div>
			</div>
			<input name="activo" type="hidden" value=true></input>
		</div>
		<!-- 		<div class="form-group"> -->
		<!-- 			<div class="col-sm-offset-2 col-sm-10"> -->
		<button class="btn btn-default" type="submit">Crear</button>
		<!-- 			</div> -->
		<!-- 		</div> -->
	</form:form>
	<br>
	<a class="btn btn-default" href='<spring:url value="/cliente/vehiculos" htmlEscape="true"/>'>Volver</a>
	</jsp:body>
</petclinic:layout>
