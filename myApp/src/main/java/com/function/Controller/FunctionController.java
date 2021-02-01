package com.function.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.DBData.DBDataChecker;
import com.myapp.VO.PortVO;

/**
 * 소켓통신(RTC)관련
 * 
 * @author 160109
 *
 */
@Controller
@RequestMapping("/Function")
public class FunctionController extends DBDataChecker {

	// 서버
	@Autowired
	private SocketGenerator socketgenerator;

	// 클라이언트
	@Autowired
	private ClientSocket clientsocket;

	private Logger functionLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 포트생성 페이지
	@RequestMapping(value = "/function.bo", method = RequestMethod.GET)
	public String WebRtc() {
		return "/Function/function";
	} */
	

	/**
	 * 입력된 포트로 서버 소켓생성
	 * 
	 * @param pvo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/PortNum.bo", method = RequestMethod.POST)
	public String PortNum(@ModelAttribute("functionvo") PortVO pvo, Model model, HttpServletRequest req) {
		String socketOperation = socketgenerator.ServerSocketGenerator(Integer.parseInt(pvo.getPortNum()));
		model.addAttribute("server", socketOperation);

		// 서버 세션 생성
		HttpSession session = req.getSession();
		session.setAttribute("serversession", socketOperation);
		return "/Function/CustomRTC";
	}

	/**
	 * 생성된 서버포트를 클라이언트 소켓기능 담당 뷰에 전달해준다.
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/ServerPortActivate.bo", method = RequestMethod.POST)
	public void ServerPortActivate(@RequestParam("portNum") String PortNum, PortVO pvo, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {

		// 서버에서 입력한 포트데이터를 입력하고,
		pvo.setPortNum(PortNum);

		int portData = 0;
		// 중복검사를 실행 후,
		if (!socketgenerator.socketDuplicateCheck(pvo)) {
			portData = socketgenerator.ServerPortNumCheck(pvo);
			// 생성된 포트를 저장하도록한다.
			if (portData > 0) {
				functionLog.info("-----------------------------------");
				functionLog.info("서버에서 생성된 포트 저장되었습니다.");
				functionLog.info("-----------------------------------");
			}
		} else {
			functionLog.info("-----------------------------------");
			functionLog.info("생성된 포트가 중복되었습니다.");
			functionLog.info("-----------------------------------");
		}
	}

	/**
	 * 클라이언트
	 * 
	 * @param clientportNum
	 * @return
	 */
	@RequestMapping("/clientPort.bo")
	public ModelAndView clientPort(@RequestParam(value = "portNum") String clientportNum) {
		ModelAndView clientport = new ModelAndView();

		if (clientportNum.length() == 4) {
			String client = clientsocket.clientAddress(Integer.parseInt(clientportNum));
			clientport.addObject("client", client);
			clientport.setViewName("/Function/CustomRTC");
		} else {
			functionLog.info("서버접속 실패.");
		}

		return clientport;
	}

	/**
	 * 서버에서 생성된 포트데이터들을 TestClient.jsp로 가지고 오도록하고, 포트데이터의 수가 10개이상일경우 0으로 초기화
	 * 
	 * @param pvo
	 * @return
	 */
	@RequestMapping("/TestClient/TestClient.bo")
	public Map<String, Object> PortList(PortVO pvo) {
		Map<String, Object> portListMap = new HashMap<String, Object>();
		// 저장되어있는 포트들을 클라이언트에서 출력.
		List<PortVO> SocketList = socketgenerator.getPortList(pvo);
		if (SocketList.size() >= 10) {
			// 만약 포트데이터의 수가 10개 이상일경우 포트데이터 초기화 진행
			int portDel = socketgenerator.DeletePort(pvo);
			if (portDel > 0) {
				functionLog.info("==================================");
				functionLog.info("수용할 수 있는 포트들의 수가 초과되었습니다. 포트데이터 초기화 진행.");
				functionLog.info("==================================");
			}
		}
		portListMap.put("serverList", SocketList);

		return portListMap;
	}

}