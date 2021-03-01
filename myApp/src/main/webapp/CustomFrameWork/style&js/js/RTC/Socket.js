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

	// 채널채널 검색 및 리스트
	$(".chanelFindForm").mouseout(function() {
		var chanelNum = document.querySelector(".chanelFindForm").value;
		var check = false;
		if(chanelNum != ""){
			check = confirm(chanelNum + "을 포함한 채널을 찾을까요?");			
		}else{
			check = confirm("채널 목록을 보여드릴까요?");
		}
		
		if(check){
			document.ChanelListFrm.method = "post";
			document.ChanelListFrm.action = "/function/Chanel/ChanelList.bo";
			document.ChanelListFrm.submit();		
		}
		return false;
	});
	$(".chanelFindForm").mouseover(function() {
		document.querySelector(".chanelFindForm").focus();
	});

});