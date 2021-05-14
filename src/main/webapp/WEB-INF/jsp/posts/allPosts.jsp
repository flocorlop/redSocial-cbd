<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Todos los posts:</h2>

<table id="posts" class="table table-striped">

	<tbody>
		<c:forEach items="${results}" var="p">
			<tr>
				<td>id: <c:out value="${p.id}"></c:out>
				</td>
				<td>likes: <c:out value="${p.likes}"></c:out>
				</td>
				<td>usuario: <c:out value="${p.uploadedBy.username}"></c:out>
				</td>
				<td>texto: <c:out value="${p.text}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


