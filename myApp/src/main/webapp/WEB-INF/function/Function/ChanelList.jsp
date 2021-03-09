<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/Template/Top.jsp" />
<div class="main">
	<div class="container Chanel_container">
		<div class="row Chanel_row">
			<dl class="Chanel_dl">
				<dt class="Chanel_dt">채널 목록</dt>
				<c:forEach var="chanelList" varStatus="status" items="${chanelList}">
					<dd class="Chanel_dd">
						${status.count}.<a href="#" class="chanellist_tab">${chanelList.chanel}</a>
					</dd>
				</c:forEach>
			</dl>
		</div>
	</div>
</div>
<jsp:include page="/Template/Bottom.jsp" />