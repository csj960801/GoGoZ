<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String protocolType = request.getProtocol();
	if (protocolType.equals("http/1.1".toLowerCase()) || protocolType.equals("http/1.1".toUpperCase())) {
%>
<meta content="initial-scale=1.0, width=device-width, user-scalable=yes" name="viewport" />

<!-- style -->
<link href="/Picture/x-icon/favicon.png" rel="shortcut icon" type="image/x-icon" />
<link href="/CustomFrameWork/style&js/fontAwesome/font-awesome.min.css"rel="stylesheet" />
<link href="/CustomFrameWork/style&js/bootstrap/bootstrap.min.css" rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/DeskTopCustomStyle.css" rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/MobileCustomStyle.css" rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/Popup.css" rel="stylesheet" />
<link href="/CustomFrameWork/style&js/css/FunctionCss.css" rel="stylesheet" />

<!-- js -->
<script src="/CustomFrameWork/style&js/js/SpeechRecognition/speech.js"></script>
<script src="/CustomFrameWork/style&js/js/jquery-3.2.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/CustomFrameWork/style&js/bootstrap/bootstrap.js"></script>
<script src="/CustomFrameWork/style&js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="/CustomFrameWork/style&js/js/CustomJs.js"></script>
<script src="/CustomFrameWork/style&js/js/IndexAjax.js"></script>
<script src="/CustomFrameWork/style&js/js/Music/MusicJS.js"></script>
<script src="/CustomFrameWork/style&js/js/CustomEffect.js"></script>
<script src="/CustomFrameWork/style&js/js/RTC/Socket.js"></script>
<%
	}
%>