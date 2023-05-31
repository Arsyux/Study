<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="continer mt-3">
	<form>
		<input type="hidden" id="id" value="${ post.id }">
		<div class="mb-3">
			<label for="title">Title:</label> <input type="text" class="form-control" id="title" value="${ post.title }"></input>
		</div>
		<div class="mb-3">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="content">${ post.content }</textarea>
		</div>
	</form>

	<button id="btn-update" class="btn btn-secondary">포스트 수정</button>

</div>

<script>
	$(document).ready(function() {
		$("#content").summernote({
			height : 300
		});
	});
</script>

<script src="/js/post.js"></script>
<%@ include file="../layout/footer.jsp"%>