/**
 * 채널 기능 스크립트
 */
$(function() {
	// 채널 생성 페이지
	$("#chanel").click(function() {
		// window.location.href = "/Chanel/ChanelCreate.jsp";
		document.mainFrm.method = "post";
		document.mainFrm.action = "/Chanel/ChanelCreateView.jsp";
		document.mainFrm.submit();
	});

	// 채널 생성 데이터 저장
	$(".chanelCreateForm").mouseout(function() {
		var chanelNum = document.querySelector(".chanelCreateForm");
		if (chanelNum.value.length == 4) {
			document.chanelFrm.method = "post";
			document.chanelFrm.action = "/function/Chanel/ChanelCreate.bo";
			document.chanelFrm.submit();
		} else {
			alert("채널 번호 형식에 옳지않습니다.");
			chanelNum.value = "";
			chanelNum.focus();
			return false;
		}
	});
	$(".chanelCreateForm").mouseover(function() {
		document.querySelector(".chanelCreateForm").focus();
	});

	/*
	 * $.ajax({ url : "/function/Chanel/ChanelList.bo", type : "post",
	 * dataType:"json", contentType:"application/json", success :
	 * function(result) { $(".chanelList").html(result); }, error : function(e) {
	 * alert("채널리스트를 가져오는데 실패하였습니다."); } });
	 */});