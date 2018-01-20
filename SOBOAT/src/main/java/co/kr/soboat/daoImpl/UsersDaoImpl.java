package co.kr.soboat.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.soboat.dao.UsersDao;

@Repository("UsersDao")
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int userJoin(Map<String, String> reqParam) {
		return sqlSession.insert("insertUser",reqParam);
	}

	@Override
	public int userIdCheck(String USER_ID) {
		return sqlSession.selectOne("userIdCheck",USER_ID);
	}

	@Override
	public int userPwCheck(Map<String , String> reqParam) {
		return sqlSession.selectOne("userPwCheck", reqParam);
	}

	@Override
	public String getUserPmKey(String USER_EMAIL) {
		return sqlSession.selectOne("getUserPmKey",USER_EMAIL);
	}

	@Override
	public Map<String, String> getUserData(int USER_PM_KEY) {
		return sqlSession.selectOne("getUserData" , USER_PM_KEY);
	}

	
	
}
