package com.myapp.Daoimpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myapp.DAO.ChanelDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.ChanelVO;

public class ChanelDAOImpl implements ChanelDAO {

	private SqlSession session = SessionFactoryGenerator.sessionFactoryInstance().openSession();

	/**
	 * 채널 데이터 생성
	 */
	@Override
	public int ChanelCreate(ChanelVO cvo) {
		// TODO Auto-generated method stub
		int chanelCreate = session.insert("chanelinsert", cvo);
		if (chanelCreate > 0) {
			session.commit();
			return chanelCreate;
		}
		return -1;
	}

	/**
	 * 생성된 전체 포트 가져오기
	 * 
	 * @param pvo
	 * @return
	 */
	@Override
	public List<ChanelVO> getChanelList() {
		List<ChanelVO> portlist = session.selectList("chanelList");
		return portlist;
	}

}
