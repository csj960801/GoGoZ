<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/Template/Top.jsp" />
<c:if test="${sessionScope.adminSession == null}">
	<script>
		alert("관리자 로그인 후 이용가능합니다.");
		window.location.href = "/MemberLogin/login.jsp";
	</script>
</c:if>
		<div class="FileUpload_wrapper">
			<div class="content-title">
				<h2 class="content-menu-h2">MusicUploader</h2>
				<ol class="breadcrumb content-title-breadcrumb">
					<li>Music</li>
					<li>MusicUploader</li>
				</ol>
			</div>
			<div class="container">
				<div class="row fileUpload_row">
					<form class="form-group" name="FileUploadFrm" id="FileUploadFrm">
						<div class="col-md-12 col-xs-12 table-responsive">
							<table class="table fileUploadTbl">
								<thead class="fileUploadHead">
									<tr>
										<th>작성자</th>
										<th>날짜</th>
										<th>음악파일</th>
									</tr>
								</thead>
								<tbody class="fileUploadBody">
									<tr>
										<td><input type="text" name="uploader" id="uploader" placeholder="아이디" class="form-control uploadForm" /></td>
										<td><input type="date" name="uploadDate" id="uploadDate" placeholder="날짜" class="form-control uploadForm" /></td>
										<td><input type="file" name="uploadMusic" id="uploadMusic" placeholder="업로드할 음악" class="form-control uploadForm" /></td>
									</tr>
								</tbody>
								<tfoot class="fileUploadFoot">
									<tr>
										<td colspan="3">
											<button id="uploadBtn" class="btn btn-primary">업로드하기</button>
											<button id="DownloadBtn" class="btn btn-primary">음악리스트보기</button>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>


<jsp:include page="/Template/Bottom.jsp" />