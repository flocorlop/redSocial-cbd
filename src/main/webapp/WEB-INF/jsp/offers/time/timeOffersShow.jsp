<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cheapy" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<cheapy:layout pageName="timeOffer">
	<script>
		$(document).ready(function(){
		  $('[data-toggle="desplegable"]').popover();   
		});
	</script>

    <h2 class="titulo" style="font-family: 'Lobster'; text-align:left; font-size:200%; padding:10px; margin-bottom:20px;"><fmt:message key="timeOffer"/>
    	<a title="Información" data-toggle="desplegable" data-trigger="hover" data-placement="bottom" data-content="Descuento al consumir en el local durante el intervalo indicado">
    	<span class="glyphicon glyphicon-question-sign" aria-hidden="true" style="padding: 5px"> </span></a>
    </h2>


    <table id="timeOfferTable" class="table table-striped">
        <thead>
        <tr>
            <th><fmt:message key="client"/></th>
            <td><c:out value="${timeOffer.client.name}"/> </td>
        </tr>
        <tr>
            <th><fmt:message key="offerBeginning"/></th>
            <td><c:out value="${localDateTimeFormat.format(timeOffer.start)}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="offerEnding"/></th>
            <td><c:out value="${localDateTimeFormat.format(timeOffer.end)}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="init"/></th>
            <td><c:out value="${timeOffer.init}h"/></td>
        </tr>
        <tr>
            <th><fmt:message key="finishOffer"/></th>
            <td><c:out value="${timeOffer.finish}h"/></td>
        </tr>
        <tr>
            <th><fmt:message key="discount"/></th>
            <td><c:out value="${timeOffer.discount}%"/></td>
        </tr>
        <tr>
            <th><fmt:message key="offerCode"/></th>
            <td><c:out value="${timeOffer.code}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="municipio"/></th>
            <td><c:out value="${timeOffer.client.municipio}"/> </td>
        </tr>
        </thead>
    </table>

	<div class="btn-menu">
	    
	<sec:authorize access="hasAnyAuthority('client')">
	<sec:authentication var="principal" property="principal" />
		<div class="btns-edit">
		<c:if test="${ principal.username eq timeOffer.client.usuar.username}">
			<c:if test="${timeOffer.status eq 'active' || timeOffer.status eq 'hidden' }">
			    <spring:url value="{timeOfferId}/edit" var="editUrl">
			    <spring:param name="timeOfferId" value="${timeOffer.id}"/>
			    </spring:url>
			    <button type="button" role="link" onclick="window.location='${fn:escapeXml(editUrl)}'" style="font-family: 'Lobster'; font-size: 20px;">
	            <span class="glyphicon 	glyphicon glyphicon-edit" aria-hidden="true" style="padding: 5px"> </span>
		        Editar oferta</button>
			</c:if>
			<c:if test="${timeOffer.status eq 'hidden' }">
		        <spring:url value="{timeOfferId}/activate" var="activateUrl">
		        <spring:param name="timeOfferId" value="${timeOffer.id}"/>
		        </spring:url>
		        <button type="button" role="link" onclick="window.location='${fn:escapeXml(activateUrl)}'" style="font-family: 'Lobster'; font-size: 20px;">
		            <span class="glyphicon 	glyphicon glyphicon-edit" aria-hidden="true" style="padding: 5px"> </span>
			        Activar oferta</button>
			</c:if>
			
			<c:if test="${timeOffer.status eq 'active' }">
			   	<spring:url value="{timeOfferId}/disable" var="deactivateUrl">
			    <spring:param name="timeOfferId" value="${timeOffer.id}"/>
			    </spring:url>
			    <button type="button" role="link" onclick="window.location='${fn:escapeXml(deactivateUrl)}'" style="font-family: 'Lobster'; font-size: 20px;">
	            <span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true" style="padding: 5px"> </span>
		        Desactivar oferta</button>
	        </c:if>
	    </c:if>    
	    </div>
	    </sec:authorize>
    </div>
	
  

</cheapy:layout>
