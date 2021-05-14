
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Mis posts</h2>

<table id="misPosts" class="table table-striped">

	<tbody>
		<c:forEach items="${results}" var="p">
			<tr>
				<td>id: <c:out value="${p.id}"></c:out>
				</td>
				<td>likes: <c:out value="${p.likes}"></c:out>
				</td>
				<td>likers: <c:forEach items="${likers}" var="l">
						<c:out value="${l.username}"></c:out>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

