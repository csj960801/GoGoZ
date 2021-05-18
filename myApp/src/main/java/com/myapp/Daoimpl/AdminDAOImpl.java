package com.myapp.Daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.DAO.AdminDAO;
import com.myapp.MybatisFactory.SessionFactoryGenerator;
import com.myapp.VO.BoardVO;
import com.myapp.VO.MemberVO;

@Repository("com.myapp.DAO.AdminDAO")
public class AdminDAOImpl implements AdminDAO {

	private Logger adminLogger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SqlSession session;

	/**
	 * 관리자 전용 게시판 데이터 출력
	 */
	@Override
	public List<BoardVO> InquiryList(BoardVO vo) {
		List<BoardVO> adminInquiry = session.selectList("adminInquiry", vo);
		adminLogger.info("-----------------------------------------------");
		adminLogger.info("질문 게시판에 데이터 존재합니다. 관리자페이지에서 확인 가능합니다.");
		adminLogger.info("-----------------------------------------------");
		return adminInquiry;
	}

	/**
	 * 관리자 전용 게시판 데이터 삭제
	 */
	@Override
	public int InquiryDel(String param) {
		int inquirydel = session.delete("adminDel", param);
		if (inquirydel > 0) {
			adminLogger.info("============================================");
			adminLogger.info("삭제완료");
			adminLogger.info("============================================");
			// session.commit();
		}
		return inquirydel;
	}

	/**
	 * 관리자 전용 회원 정보 출력
	 */
	@Override
	public List<MemberVO> memberList(MemberVO mvo) {
		List<MemberVO> memberlist = session.selectList("memberList", mvo);
		adminLogger.info("===================================================");
		adminLogger.info("회원 정보들을 출력했습니다.");
		adminLogger.info("===================================================");
		return memberlist;
	}

	/**
	 * 관리자 전용 회원 삭제
	 */
	@Override
	public int memberDel(String param) {
		int memberDel = session.delete("memberDel", param);
		if (memberDel > 0) {
			// session.commit();
			adminLogger.info("===================================================");
			adminLogger.info("회원 '" + param + "'님 이 삭제되었습니다.");
			adminLogger.info("===================================================");
		}
		return memberDel;
	}

	/**
	 * 관리자 전용 회원 정보 수정
	 */
	@Override
	public int memberUpdate(MemberVO mvo) {
		int memberUpdate = session.update("memberUpdate", mvo);
		if (memberUpdate > 0) {
			// session.commit();
			adminLogger.info("===================================================");
			adminLogger.info("회원 '" + mvo.getName() + "'님의 정보가 수정 되었습니다.");
			adminLogger.info("===================================================");
		}
		return memberUpdate;
	}
}