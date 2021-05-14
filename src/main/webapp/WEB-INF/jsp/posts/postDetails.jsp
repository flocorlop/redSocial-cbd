
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<h2>Detalles del post</h2>


	<table class="table table-striped">
		<tr>
			<th>usuario</th>
			<td><c:out value="${uploadedBy.username}" /></td>
			<th>texto</th>
			<td><c:out value="${post.text}" /></td>
			<th>likes</th>
			<td><c:out value="${post.likes}" /></td>
			<th>likers</th>
			
			<c:forEach items="${likedBy}" var="l">
			<td>
				<c:out value="${l.username}"></c:out>
				</td>
				</c:forEach>
				
		</tr>
</table>
	