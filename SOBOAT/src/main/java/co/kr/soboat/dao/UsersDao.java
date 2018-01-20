package co.kr.soboat.dao;

import java.util.Map;

import co.kr.soboat.VO.UsersVO;

public interface UsersDao {
	// USER JOIN
	public int userJoin(Map<String , String> reqParam);
	// USER ID CHECK
	public int userIdCheck(String USER_ID);
	// USER PASSWORD CHECK
	public int userPwCheck(Map<String , String> reqParam);
	// GET USER PM KEY 
	public String getUserPmKey(String USER_ID);
	
	// GET USER DATA
	public Map<String , String> getUserData(int USER_PM_KEY);
 } 
