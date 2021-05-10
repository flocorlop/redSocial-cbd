<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cheapy" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet'>

 

<cheapy:layout pageName="home"> 
    <h2 class="titulo" style="font-family: 'Lobster'; font-size: 300%;  padding:30px"><fmt:message key="welcome"/></h2>
    <div class="row">
        <div class="col-md-12">
            <div class="img-home">
                <spring:url value="/resources/images/Logo Cheapy.png" htmlEscape="true" var="cheapyImage"/>
                <img class="img-responsive" src="${fn:escapeXml(cheapyImage)}"/>
            </div>
            <div class="btn-home-max">
	            <div class="btn-home">
	                <button  class="btn-block" type="button" role="link" onclick="window.location='/offers'" style="font-family: 'Lobster'; font-size: 20px;margin:5px;" >
	                <span class="glyphicon glyphicon-cutlery" aria-hidden="true" style="padding: 5px"> </span>
	                <fmt:message key="listOffers"/> </button>
	            </div>
	            
              <sec:authorize access="hasAnyAuthority('client')">
              <div class="btn-home">
                      <button class="btn-block" type="button" role="link" onclick="window.location='/myOffers'" style="font-family: 'Lobster'; font-size: 20px;margin:5px;" class="btn-block">
                      <span class="glyphicon glyphicon-cutlery" aria-hidden="true" style="padding: 5px"> </span>
                      <fmt:message key="myOffers"/> </button>
                  </div>
                <div class="btn-home">
                      <button class="btn-block" type="button" role="link" onclick="window.location='/offersCreate'" style="font-family: 'Lobster'; font-size: 20px;margin:5px;" >
                      <span class="glyphicon glyphicon-cutlery" aria-hidden="true" style="padding: 5px"> </span>
                      <fmt:message key="createOffers"/> </button>
                  </div>
                    
              </sec:authorize>
            </div>
	        

        </div>
    </div>
</cheapy:layout>		        	 	        