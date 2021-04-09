<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<petclinic:layout pageName="persons">
	<h2>Persons</h2>

	<table id="personsTable" class="table table-striped">
			
		<tbody>
			<c:forEach items="${results}" var="p" >
				
				
				<tr>
					
					<td><c:out value="${p.firstName}" /></td>

				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</petclinic:layout>
