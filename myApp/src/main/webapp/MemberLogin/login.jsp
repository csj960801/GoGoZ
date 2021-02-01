<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginForbidden.jsp" />

<c:if test="${sessionScope.loginName != null || sessionScope.adminSession != null}">
	<script>
		alert("로그인이 이미 되어있는 상태입니다.");
		window.location.href = '/';
	</script>
</c:if>

<div class="login-wrapper">
	<div class="content-title">
		<h2 class="content-menu-h2">MemberLogin</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>member</li>
			<li>MemberLogin</li>
		</ol>
	</div>
	<div class="login_wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<form name="loginFrm" id="loginFrm">
						<div class="table-responsive form-group login_responsive">
							<table class="login-table table table-hover">
								<tbody>
									<tr>
										<th><label for="login-name">성함</label></th>
										<td><input type="text" name="name" class="form-control"
											id="name" autocomplete="off"></td>
									</tr>
									<tr>
										<th><label for="login-email">email</label></th>
										<td><input type="email" name="email" class="form-control"
											id="email" autocomplete="off"></td>
									</tr>
									<tr>
										<td colspan="2" align="center">
									        <span class="name_save_span">
									        	이름 저장 <input type="checkbox" value="remember" name="remember" class="remember" checked="checked" />
									        </span>
											<button id="loginBtn" class="btn btn-success">login</button>
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<!-- 네이버아이디로로그인 버튼 노출 영역-->
											<div id="naver_id_login"></div>
											<script type="text/javascript">
												// Client ID, CallBack URL 삽입
												var naver_id_login = new naver_id_login(
														"TKrv0ig5kg0YG8WsH3SA",
														"http://localhost:8080");
												// 단 'localhost'가 포함된 CallBack URL
												var state = naver_id_login.getUniqState();

												naver_id_login.setButton("white", 2, 40);
												naver_id_login.setDomain("http://localhost:8080"); //  URL
												naver_id_login.setState(state);
												naver_id_login.setPopup();
												naver_id_login.init_naver_id_login();
											</script>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/Template/Bottom.jsp" />