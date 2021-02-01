/**
 * WEB RTC & MusicDownload 전용 by CSJ
 */
$(function() {
  // ie8외 브라우저에서 지원되게끔.
  if(window.addEventListener){
	
	$("#perform").click(function() {
	    window.location.href="/Function/function.bo";
	});
	$("#AdminUploader").click(function() {
	    window.location.href="/FileUpload/FileUpload.jsp";
	});
	$("#downloader").click(function() {
	    window.location.href="/Function/Music/MusicDownload.bo";
	});
	$("#downloader-blocked").click(function() {
        alert("회원만 사용가능한 서비스입니다. 로그인을 해주세요.");
	    window.location.href="/MemberLogin/login.jsp";
	});
    $("#functionBtn").on("click",function(){
    	var portNum = document.getElementById("portNum").value;
    	if(portNum == null || portNum == "" || isNaN(portNum) || portNum.length != 4){
    		alert("잘못된 포트방식입니다");
    		document.getElementById("portNum").focus();
    		return false;
    	}
    	document.getElementById("functionFrm").setAttribute("action", "/Function/PortNum.bo");
		document.getElementById("functionFrm").setAttribute("method", "post");
    });
    
    clientSocket();
    MusicUploader();
	
	}
    // ie8이하의 브라우저일 경우
    else{
		document.getElementsByTagName("body")[0].innerHTML = "<h1>지원되지않는 브라우저환경입니다.</h1>";
	}

});

/**
 * 클라이언트 전용 소켓페이지 이동
 * @returns
 */
function clientSocket(){
	$("#clientfunctionBtn").on("click",function(){
	    var portNum = document.getElementById("clientportNum").value;
	    if(portNum == null || portNum == "" || isNaN(portNum) || portNum.length != 4){
	    	alert("잘못된 포트방식입니다");
	    	document.getElementById("clientportNum").focus();
	    	return false;
	    }
	    document.getElementById("TestfunctionFrm").setAttribute("action", "/Function/clientPort.bo");
		document.getElementById("TestfunctionFrm").setAttribute("method", "post");
	});
};

/**
 * 파일업로더 전용(FileUpload.jsp)
 * @returns
 */
function MusicUploader(){
	$("#uploadBtn").on("click",function(){
		var uploader = document.getElementById("uploader").value;
		var uploadDate = document.getElementById("uploadDate").value;
		var uploadMusic = document.getElementById("uploadMusic").value;
	
	    var fileArray = new Array();
	    fileArray[0] = uploader;
	    fileArray[1] = uploadDate;
	    fileArray[2] = uploadMusic;
		
	    for(var i=0; i<fileArray.length; i++){
	    	if(fileArray[i] == null || fileArray[i].length <= 0){
	    		alert("입력된 정보들을 다시 확인해주세요");
	    		document.getElementById("uploader").focus();
	    		return false;
	    	}
		 }
	    document.getElementById("FileUploadFrm").setAttribute("method","post");
	    document.getElementById("FileUploadFrm").setAttribute("action","/Function/Music/MusicDownload.bo");
		document.getElementById("FileUploadFrm").setAttribute("enctype","multipart/form-data");
		});
	
	$("#DownloadBtn").on("click",function(){
	    document.getElementById("FileUploadFrm").setAttribute("method","get");
	    document.getElementById("FileUploadFrm").setAttribute("action","/Function/Music/MusicDownload.bo");	    	
	});
};

/**
 * MusicDownload.jsp에서 선택한 음악을 다운로드 해줄 데이터와 form생성
 * @returns
 */
function multiPartForm(music){
	var formMark = "";
	$("#musicTitle").on("click",function(){
		document.getElementById("musicFrm").setAttribute("action","/Function/Music/MusicDownloadActivate.bo");
		document.getElementById("musicFrm").setAttribute("enctype","multipart/form-data");
		document.getElementById("musicFrm").setAttribute("method","post");
	
		formMark = "<input type='hidden' name='selectedMusic' value='" + music + "'/>"	
		document.getElementById("form_parent_td").innerHTML = formMark;
	
	    document.musicFrm.submit();
	});
};