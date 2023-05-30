<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>


<br>
<div class="container mt-3">
	<c:if test="${!empty postList }">
		<div class="card">
			<c:forEach var="post" items="${ postList }">
				<div class="card-body">
					<h4 class="card-title">${ post.title }</h4>
					<a href="#" class="btn btn-secondary">상세보기</a>
				</div>
			</c:forEach>
		</div>
	</c:if>
</div>


<%@ include file="./layout/footer.jsp"%>