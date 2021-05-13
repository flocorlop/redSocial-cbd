<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>

 <table id="causesTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hobbies}" var="hobby">
            <tr>
                <td>
                    <spring:url value="/hobbies/{hobbyName}" var="hobbyUrl">
                        <spring:param name="hobbyId" value="${hobby.name}"/>
                    </spring:url>
                    <a href=""><c:out value="${hobby.name}"/></a>
                </td>
                <td>
                    <c:out value="${hobby.interested} "/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</body>
</html>