<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<petclinic:layout pageName="posts">
	<h2>Posts</h2>

	<table id="postsTable" class="table table-striped">
			
		<tbody>
			<c:forEach items="${results}" var="p" >
				
				
				<tr>
					
					<td><c:out value="${p.likes}" /></td>

				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
</petclinic:layout>
