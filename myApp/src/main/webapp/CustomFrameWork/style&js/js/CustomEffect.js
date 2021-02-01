/**
 * Created By CSJ
 */
$(function() {
	// 게시글 초기화
	boardContentReset();
});

// 게시글입력창을 2번 클릭시 value값 초기화
function boardContentReset() {

	$("#b-content").on("dblclick", function() {
		document.getElementById("b-content").value = "";
	});

}// end of boardContentReset()

/**
 * 키보드 CapsLock을 눌렀을 경우, alert발생
 * 
 * @returns
 */
window.onload = keyboardEffect();
function keyboardEffect() {
	var browserInfo = navigator.userAgent.toUpperCase();
	var useBrowser = [ "CHROME", "FIREFOX", "MOZILA" ];

	for (var i = 0; i < useBrowser.length; i++) {
		// 크롬, 파이어폭스, 모질라 브라우저가 포함되어 있을 경우,
		if (browserInfo.indexOf(useBrowser[i]) > -1) {
			window.addEventListener("keydown", function(event) {
				if (event.getModifierState("CapsLock")) {
					alert("CapsLock이 켜졌습니다.");
				} else {
					// alert("CapsLock이 꺼졌습니다.");
				}
			});
		}
		// IE(윈도우 익스플로러)
		window.onkeydown = function(event) {
			var caplock = event.getModifierState("CapsLock");
			if (caplock) {
				alert("CapsLock Switch On");
			} else {
				// alert("CapsLock Switch Off");
			}
		}
	}// end of for()
	// console.log(browserInfo);

};