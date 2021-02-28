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
import com.myapp.ServiceImpl.ChanelServiceImpl;
import com.myapp.VO.ChanelVO;

/**
 * 채널리스트 관련
 * 
 * @author 160109
 *
 */
@Controller
@RequestMapping("/function")
public class FunctionController extends DBDataChecker {

	@Autowired
	private ChanelServiceImpl chanelService;

	private Logger functionLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 채널 생성
	 * 
	 * @param chanelMap
	 * @return
	 */
	@RequestMapping(value = "/Chanel/ChanelCreate.bo", method = RequestMethod.POST)
	public Map<String, Object> chanelCreate(ChanelVO cvo) {
		Map<String, Object> chanelcreateMap = new HashMap<String, Object>();

		int chanelCreate = chanelService.ChanelCreate(cvo);
		if (chanelCreate > -1) {
			chanelcreateMap.put("chanelMap", chanelCreate);
			functionLog.info("====================================");
			functionLog.info("채널 생성 되었습니다:" + cvo.getChanel());
			functionLog.info("====================================");
		}
		return chanelcreateMap;
	}

	/**
	 * 채널리스트데이터 출력
	 * 
	 * @param pvo
	 * @return
	 */
	@RequestMapping(value = "/Chanel/ChanelList.bo", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> PortList() {
		Map<String, Object> portListMap = new HashMap<String, Object>();

		// 저장되어있는 포트들을 클라이언트에서 출력.
		List<ChanelVO> chanelList = chanelService.getChanelList();
		for (ChanelVO list : chanelList) {
			functionLog.info("===================================");
			functionLog.info("채널리스트: " + list.getChanel());
			functionLog.info("===================================");
		}
		portListMap.put("chanelList", chanelList);
		return portListMap;
	}

}