/**
 * WebRtC관련 기능 스크립트
 */
$(function() {

	$("#perform").click(function() {
		window.location.href = "/Function/function.bo";
	});

	/**
	 * 클라이언트전용 기능
	 */
	$("#ClientPort").click(function(){
		window.location.href='/Function/TestClient/TestClient.bo';
	});
	
	/**
	 * 서버전용 기능
	 */
	$("#functionBtn").on("click",function() {
		// 서버포트 활성화 유무
		var ServerPortActivate = -1;
		var portNum = document.getElementById("portNum").value;
				if (portNum == null || portNum == "" || isNaN(portNum) || portNum.length != 4) {
					alert("잘못된 포트방식입니다");
					document.getElementById("portNum").focus();

					ServerPortActivate = 0;
					return false;
				}
				ServerPortActivate = 1;
		    		
				document.getElementById("functionFrm").setAttribute("action","/Function/PortNum.bo");
				document.getElementById("functionFrm").setAttribute("method","post");
				
		        // 서버 포트가 활성화 될 경우
	        	ServerPortAlert(ServerPortActivate, portNum);
		});
});

/**
 * 클라이언트에서 생성된 포트로 접속할 때
 * 
 * @returns
 */
function clientSocket() {
	$("#clientfunctionBtn").on("click",function() {
				var portNum = document.getElementById("clientportNum").value;
				if (portNum == null || portNum == "" || isNaN(portNum) || portNum.length != 4) {
					alert("잘못된 포트방식입니다");
					document.getElementById("clientportNum").focus();
					return false;
				}
				document.getElementById("TestfunctionFrm").setAttribute("action", "/Function/clientPort.bo");
				document.getElementById("TestfunctionFrm").setAttribute("method", "post");
			});
};

/**
 * 서버에서 포트번호를 만들면 클라이언트에 공지하는 식으로 나오도록
 * 
 * @returns
 */
function ServerPortAlert(accessNum, portNum) {
	console.log(accessNum);
	if (accessNum == 1) {

		$.ajax({
			url : "/Function/ServerPortActivate.bo",
			data : {"portNum" : portNum},
			dataType : "html",
			type : "post",
			success : function(ServerPort) {
			},
			error : function(e) {
				alert("서버에서 생성된포트가 없거나 오류가 발생했습니다!");
			}

		});
	}

};