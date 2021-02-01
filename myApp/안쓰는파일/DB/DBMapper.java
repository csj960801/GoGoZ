package com.myapp.DB;

import java.util.HashMap;

public class DBMapper {

	// DBMapper
	protected String sqlMapper(HashMap<String, Object> sql) {
		String sqlOrder = "";
		// sql 오브젝트안에 DCL이나 관련 값이 있을 경우
		if (!sql.isEmpty()) {

			// 회원가입(MemberRegister)
			if (String.valueOf(sql.get("sql")).equals("memberReg")) {

				sqlOrder = "insert into User(name,email) values('%s','%s')";

			}

			// 로그인(login)
			if (String.valueOf(sql.get("sql")).equals("MemberLogin")) {

				sqlOrder = "select name from User where email='%s' and name='%s'";

			}

			// board insert
			if (String.valueOf(sql.get("sql")).equals("insert")) {

				sqlOrder = "insert into Board(BoardTitle, BoardWriter, BoardDate, BoardContent) values('%s','%s','%s','%s')";

			}
			// board 조회(select)
			if (String.valueOf(sql.get("sql")).equals("selectList")) {

				sqlOrder = "select * from Board";

			}

			// Music 업로드(MusicInsert)
			if (String.valueOf(sql.get("sql")).equals("MusicInsert")) {

				sqlOrder = "insert into MusicManage(MusicName, author) values('%s', '%s')";

			}

			// Music 파일 중복(searchDuplicateFileName)
			if (String.valueOf(sql.get("sql")).equals("searchDuplicateFileName")) {

				sqlOrder = "select MusicName from musicmanage where author='%s'";

			}

		}

		return sqlOrder;
	}// end of HashMap<>

}