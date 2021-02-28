package com.myapp.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.Daoimpl.ChanelDAOImpl;
import com.myapp.Service.ChanelService;
import com.myapp.VO.ChanelVO;

public class ChanelServiceImpl implements ChanelService {

	@Autowired
	private ChanelDAOImpl chanelDAO;

	/**
	 * 채널생성
	 */
	@Override
	public int ChanelCreate(ChanelVO cvo) {
		// TODO Auto-generated method stub
		return chanelDAO.ChanelCreate(cvo);
	}

	/**
	 * 채널리스트
	 */
	@Override
	public List<ChanelVO> getChanelList() {
		// TODO Auto-generated method stub
		return chanelDAO.getChanelList();
	}

}