<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="cita">

 	<jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#fechaCita").datepicker({dateFormat:"dd/mm/yy 'hh:mm'"});
            });
        </script>
    </jsp:attribute>
    
    
    <jsp:body>
    <h2>
        Nueva Cita
    </h2>
  
    <form:form modelAttribute="cita" class="form-horizontal" id="add-cita-form">
        <div class="form-group has-feedback">

          <a href="vehiculo" class="btn btn-default">Primero escoge tu veh�culo</a>
			<br>
			
			<input name="estadoCita" type="hidden" value="pendiente"></input>
            <petclinic:inputField label="Fecha cita" name="fechaCita"
             pattern="^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}(\s)([0-2][0-9])(:)([0-5][0-9])$"
	             required="true"  title="Introduce una fecha en futuro: Ejemplo: 12/12/2021 10:30 "
	             placeholder="dd/MM/yyyy HH:mm"  />
	             
            <petclinic:inputField label="Descripci�n" name="descripcion"/>
            <input name="coste" type="hidden" value=0.0></input>
            <input name="tiempo" type="hidden" value=0></input>
            
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<table class="error-title">
						<tr>
							<th>�Es urgente?</th>
							<td><select name="esUrgente">
									<option value="TRUE">S�</option>
									<option value="FALSE">No</option>
							</select></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<table class="error-title">
						<tr>
							<th>Tipo de cita</th>
							<td><select name="tipo">
									<option value="revision">Revisi�n</option>
									<option value="reparacion">Reparaci�n</option>
									<option value="preparacion_itv">Preparaci�n ITV	</option>
									<option value="modificacion">Modificaci�n</option>
							</select></td>
						</tr>
					</table>
				</div>
			</div>

			
			
        </div>
        <div class="form-group">
             <div class="col-sm-offset-2 col-sm-10"> 
                   <button class="btn btn-default" type="submit">Pedir Cita</button>
            </div> 
        </div> 
    </form:form>
    <br>
    <a class="btn btn-default" href='<spring:url value="/cliente/citas" htmlEscape="true"/>'>Volver</a>
    </jsp:body>
</petclinic:layout>
