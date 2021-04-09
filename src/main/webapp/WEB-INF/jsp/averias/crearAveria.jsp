<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="averia">
    
    <jsp:body>
    <h2>
        Nueva Aver�a
    </h2>
  
    <form:form modelAttribute="averia" class="form-horizontal" id="add-cita-form">
        <div class="form-group has-feedback">
			 <a href="citas" class="btn btn-default">Primero elija la cita correspondiente</a>
			<br>
	        <petclinic:inputField label="Nombre" name="nombre"/>     
            <petclinic:inputField label="Descripci�n" name="descripcion"/>
            <petclinic:inputField label="Coste" name="coste" pattern="^\d{0,9}(\.\d{1,2})$" title="Introduce un coste positivo. Por ejemplo 5.00"/>
            <petclinic:inputField label="Tiempo" name="tiempo" pattern="^[1-9]+[0-9]*$" title="Introduce un tiempo positivo (horas). Por ejemplo 2 "/>
            <petclinic:inputField label="Piezas Necesarias" name="piezasNecesarias" pattern="^[1-9]+[0-9]*$" title="Introduce un numero positivo. Por ejemplo 4"/>
            
			<input name="estaReparada" type="hidden" value="False"></input>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<table class="error-title">
						<tr>
							<th>Complejidad</th>
							<td><select name="complejidad">
									<option value="BAJA">Baja</option>
									<option value="MEDIA">Media</option>
									<option value="ALTA">Alta</option>
									
							</select></td>
						</tr>
					</table>
				</div>
			</div>

			
			
        </div>
        <div class="form-group">
             <div class="col-sm-offset-2 col-sm-10"> 
                   <button class="btn btn-default" type="submit">Crear Aver�a</button>
            </div> 
        </div> 
    </form:form>
    <br>
   <spring:url value="/mecanicos/vehiculos/{vehiculoId}/averia" var="vehiculoId">
			<spring:param name="vehiculoId" value="${vehiculoId}" />
			</spring:url> <a href="${fn:escapeXml(vehiculoId)}" class="btn btn-default">Volver</a>
    </jsp:body>
</petclinic:layout>
