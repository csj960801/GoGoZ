<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${inquiry > 0}">
	<script type="text/javascript">
		alert("문의해주셔서감사합니다! 빠른 시일내에 답변하겠습니다 ");
		window.location.href = "/";
	</script>
</c:if>
<c:choose>
	<c:when test="${inquiry <= 0}">
		<script type="text/javascript">
			alert("문의실패");
			history.back();
		</script>
	</c:when>
</c:choose>

<div class="success_wrapper">${Data}</div>