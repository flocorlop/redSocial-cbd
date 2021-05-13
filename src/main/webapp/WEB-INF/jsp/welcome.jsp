<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<div class="container">
<c:forEach items="${results}" var="post" >
<div class="card">
  <h2>David Manfield</h2>
  <div class="title title--epic">Programmer</div>
  <div class="desc">David can develop any kind of software, he started learning to code for about 10 years!</div>
  <c:out value="${post.text}" />
    <div class="actions">
    <button class="actions__like">like &nbsp; <i class="fas fa-heart"></i> </button>
    <button class="actions__trade">trade &nbsp; <i class="fas fa-exchange-alt"></i> </button>
    <button class="actions__cancel">close &nbsp; <i class="fas fa-times"></i> </button>
  </div>
</div>


</c:forEach>
</div>
