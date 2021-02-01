package com.function.Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myapp.MybatisFactory.*;
import com.myapp.VO.PortVO;

public class SocketGenerator {

	private ServerSocket serversocket;
	private Socket socket = null;
	private InetAddress userAddress;

	private Logger socketlog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 서버소켓 생성
	 * 
	 * @param portGenerator
	 * @return
	 */
	public String ServerSocketGenerator(int port) {
		String userHostName = "";
		String userIpInfo = "";
		try {

			// 1)공연자가 생성할 포트번호를 입력받은 후,
			serversocket = new ServerSocket(port);
			// 2)클라이언트가 접속할때까지 대기한다.
			socket = serversocket.accept();
			// 만약 일정대기시간을 초과 할 경우 해당 서버소켓을 닫는다.
			socket.setSoTimeout(100);
			if (socket.getSoTimeout() > 100) {
				socketlog.info("=======================");
				socketlog.info("대기시간이 초과되었습니다");
				socketlog.info("=======================");
				socket.close();
			}
			// 3)클라이언트가 들어왔을경우, 그 클라이언트의 IP정보와 호스트를 출력하고 입장했다는 알림을 띄운다.
			userAddress = socket.getInetAddress();
			byte[] ipArr = userAddress.getAddress();
			for (int i = 0; i < ipArr.length; i++) {
				if (String.valueOf(ipArr[i]) != null) {
					userIpInfo = String.valueOf(ipArr[i]);
				}
			}
			// client소켓 inputstream
			InputStream streamreader = socket.getInputStream();
			// client소켓 outputstream
			OutputStream streamwriter = socket.getOutputStream();

			userHostName = userAddress.getHostName();
			socketlog.info("=================================================");
			socketlog.info("socket데이터확인: " + userIpInfo + "," + userHostName);
			socketlog.info("=================================================");

		} catch (Exception e) {
			socketlog.info("socket예외발생: " + e.toString());
		}

		return userIpInfo;
	}

	/**
	 * 서버에서 생성된 프트 db에 저장
	 * 
	 * @param port
	 * @return
	 */
	public int ServerPortNumCheck(PortVO pvo) {
		
		SqlSession session = SessionFactoryGenerator.sessionFactoryInstance().openSession();
		int toClient = session.insert("socketinsert", pvo);
		if (toClient > 0) {
			session.commit();
		}
		return toClient;
	}

	/**
	 * port 중복 체크
	 * 
	 * @param port
	 * @return
	 */
	public boolean socketDuplicateCheck(PortVO pvo) {
		SqlSession session = SessionFactoryGenerator.sessionFactoryInstance().openSession();

		boolean duplicateCheck = false;
		PortVO voSocket = session.selectOne("socketDuplicate", pvo);
		if (voSocket != null) {
			duplicateCheck = true;
		}

		return duplicateCheck;
	}

	/**
	 * 포트삭제
	 * 
	 * @param pvo
	 * @return
	 */
	public int DeletePort(PortVO pvo) {
		SqlSession session = SessionFactoryGenerator.sessionFactoryInstance().openSession();
		int DataFlag = session.delete("portDel", pvo);
		if (DataFlag > 0) {
			session.commit();
		}
		return DataFlag;
	}

	/**
	 * 생성된 전체 포트 가져오기
	 * 
	 * @param pvo
	 * @return
	 */
	public List<PortVO> getPortList(PortVO pvo) {
		SqlSession session = SessionFactoryGenerator.sessionFactoryInstance().openSession();

		List<PortVO> portlist = session.selectList("socketList", pvo);
		return (portlist.size() > 0) ? portlist : null;
	}

}