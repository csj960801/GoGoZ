<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />

<div class="container Chanel_container">
	<div class="row Chanel_row">
		<dl class="Chanel_dl">
			<dt class="Chanel_dt">목록</dt>
			<c:forEach var="chanelList" items="${chanelList}">
				<dd class="Chanel_dd">${chanelList.chanel}</dd>
			</c:forEach>
		</dl>
	</div>
</div>