package co.kr.soboat.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UsersService{
	// USER JOIN
	public Map<String , String> userJoin(Map<String , String> reqParam);
	// USER LOGIN
	public Map<String , String> userLogin(Map<String , String> reqParam);
	// GET USER DATA
	public Map<String , String> getUserData(int USER_PM_KEY) throws JsonProcessingException;
}
