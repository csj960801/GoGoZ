<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<jsp:include page="/CustomFrameWork/FrameWork/loginForbidden.jsp" />

<div class="Chanel-main">
	<div class="content-title">
		<h2 class="content-menu-h2">ChanelCreate</h2>
		<ol class="breadcrumb content-title-breadcrumb">
			<li>Chanel</li>
			<li>ChanelCreate</li>
		</ol>
	</div>
	<div class="container chanel_container">
		<div class="row chanel_container">
			<div class="col-md-12- col-xs-12 form-group">
				<form id="ChanelFrm" name="chanelFrm">
					<div class="ChenalCreate_wrapper">
						<label class="chanel_label" for="chanel_label">채널생성</label>
						<input type="password" class="form-control chanelCreateForm" name="chanel" />
						<p class="chanel_p">
							<span class="chanel_span">* 생성하실 4자리의 채널번호를 입력해주세요.</span>
						</p>
					</div>
				</form>
				
				<div class="clearfix"></div>
				
				<form id="chanelListFrm" name="chanelListFrm">
				   <div class="chanelList"></div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/Template/Bottom.jsp" />