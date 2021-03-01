<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GoGoZ</title>
<jsp:include page="/CustomFrameWork/FrameWork/FrameWork.jsp" />
</head>
<body>
<div class="nav navbar-inverse main-menu">
	<div class="container-fluid menu_container">
		<div class="row menu_row">
			<div class="col-md-2 col-xs-6">
				<div class="navbar-header">
					<a href="/" class="navbar-brand">GoGoZ</a>
				</div>
			</div>

			<div class="collapse-wrapper">
				<button type="button" class="mobile-collapse-btn navbar-toggle collapsed" data-toggle="collapse" data-target="#Menu">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>

			<div class="col-md-10 col-xs-6">
				<div class="navbar-body collapse navbar-collapse" id="Menu">
					<ul class="navbar-ul nav navbar-nav navbar-right">
						<c:if test="${sessionScope.loginName == null && sessionScope.adminSession == null}">
							<li><a href="#" id="MemberRegister">MemberReg</a></li>
							<li><a href="#" id="MemberLogin">Login</a></li>
						</c:if>
						<c:choose>
							<c:when test="${sessionScope.loginName != null}">
								<li><a href="#" id="MemberLogOut">로그아웃</a></li>
								<li><a href="#" id="MemberDelete">회원탈퇴</a></li>
								<li><a href="#" id="MemberUpdate">개인정보수정</a></li>
								<!-- <li><a href="#" id="ClientPort">포트접속</a></li> -->
								<li><a href="#" id="InquiryBoard">게시판</a></li>
								
							</c:when>
							<c:when test="${sessionScope.adminSession != null}">
								<li><a href="#" id="MemberLogOut">관리자 로그아웃</a></li>
								<li><a href="#" id="MemberAdmin">관리자</a></li>
							</c:when>
						</c:choose>	
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>