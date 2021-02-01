<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginNeed.jsp" />

<div class="container">
	<div class="row">
		<div class="col-md-12 col-xs-12">
			<form id="functionFrm" name="functionFrm" class="form-group">
				<div class="portNum_wrapper">
					<dl class="port_dl">
						<dt class="port_dt">서버에서 생성할 접속포트를 입력해주세요</dt>
						<dd class="port_dd">
							<input type="password" name="portNum" id="portNum"
								class="form-control portNum" placeholder="숫자 4자리">
						</dd>
						<dd class="port_dd">
							<button id="functionBtn" class="btn btn-primary">생성</button>
						</dd>
					</dl>
				</div>
			</form>
			<div id="serverPortGenerator_div">
				<ul class="portList">
					<c:forEach var="port" items="${requestScope.serverport}">
						<c:forEach var="getPort" items="${port}">
							<li>${getPort.portNum}</li>
						</c:forEach>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/Template/Bottom.jsp" />