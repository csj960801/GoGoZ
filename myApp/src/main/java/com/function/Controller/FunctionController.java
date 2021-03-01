package com.function.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myapp.ServiceImpl.ChanelServiceImpl;
import com.myapp.VO.ChanelVO;

/**
 * 채널리스트 관련
 * 
 * @author 160109
 *
 */
@Controller
@RequestMapping(value = "/function/Chanel/")
public class FunctionController {

	@Autowired
	private ChanelServiceImpl chanelService;

	private Logger functionLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 채널 생성
	 * 
	 * @param chanelMap
	 * @return
	 */
	@RequestMapping(value = "ChanelCreate.bo", method = RequestMethod.POST)
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
	 * 채널 리스트 검색 데이터 출력
	 * 
	 * @param pvo
	 * @return
	 */
	@RequestMapping(value = "ChanelList.bo", method = RequestMethod.POST)
	public List<ChanelVO> PortList(ChanelVO cvo) {
		Map<String, Object> portListMap = new HashMap<String, Object>();

		// 저장되어있는 포트들을 클라이언트에서 출력.
		List<ChanelVO> chanelList = chanelService.getChanelList(cvo);
		for (ChanelVO list : chanelList) {
			functionLog.info("===================================");
			functionLog.info("채널리스트: " + list.getChanel());
			functionLog.info("===================================");
		}
		portListMap.put("chanelList", chanelList);
		return chanelList;
	}

}