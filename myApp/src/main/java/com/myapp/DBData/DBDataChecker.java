package com.myapp.DBData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myapp.VO.MusicVO;

public class DBDataChecker {

	private static Logger DBlogger = LoggerFactory.getLogger(DBDataChecker.class);

	private static Connection connector;
	private PreparedStatement psmt;
	private ResultSet rs;

	private String sql = "";

	/**
	 * 데이터베이스 커넥션 인스턴스생성
	 * 
	 * @return
	 */
	public static Connection DBConnectorInstance() {
		String url = "jdbc:mysql://localhost:3306/prototype?serverTimezone=UTC";
		String user = "root";
		String password = "sevenn0801";
		if (connector != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connector = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				DBlogger.info("======================================");
				DBlogger.info("DBConnection Exception" + e.toString());
				DBlogger.info("======================================");
			}
		}
		return connector;
	}

	/**
	 * 중복입력된 데이터 체크
	 */
	public boolean DuplicateCheck(String param) {
		boolean flag = false;
		sql = "select count(uploadMusic) from uploadedfile where uploadMusic = ?";
		try {
			connector = DBConnectorInstance();
			psmt = connector.prepareStatement(sql);
			psmt.setString(1, param);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String data = rs.getString("uploadMusic");
				if (data.equals(param)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			DBlogger.info("======================================");
			DBlogger.info("중복데이터체크도중 예외발생: " + e.toString());
			DBlogger.info("======================================");
		} finally {
			if (connector != null) {
				try {
					connector.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}

		return flag;
	}

}//end of class