package co.kr.soboat.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.kr.soboat.dao.UsersDao;
import co.kr.soboat.service.UsersService;

@Service("UsersService")
public class UsersServiceImpl implements UsersService{
	
	@Resource(name = "UsersDao")
	private UsersDao usersDao;
	
	// RESULT
	Map<String , String> result;
	
	@Override
	public Map<String, String> userJoin(Map<String, String> reqParam) {
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		
		// ID CHECK
		if( usersDao.userIdCheck(reqParam.get("user_email")) == 0) {
			// INSERT USER
			if( usersDao.userJoin(reqParam) == 1 ) {
				result.put("success", "true");
			} else {
				result.put("success", "false");
				result.put("message", "JOIN FAIL");
			}
		} else {
			result.put("success", "false");
			result.put("message", "THIS ID USED");
		}
		
		return result;
	}

	@Override
	public Map<String, String> userLogin(Map<String, String> reqParam) {
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		String userId = reqParam.get("user_email");
		String userPw = reqParam.get("user_password");
		String userPmKey;
		
		// SET USER DATA
		Map<String , String> userData = new HashMap<String , String>();
		userData.put("USER_PWD", userPw);
		
		// LOGIN ----------------------------------------
		// ID CHECK
		if( usersDao.userIdCheck(userId) == 1 ) {
			// GET USER PM KEY
			userPmKey = usersDao.getUserPmKey(userId);
			userData.put("USER_PM_KEY", userPmKey);
			// PASSWORD CHECK
			if( usersDao.userPwCheck(userData) == 1 ) {
				result.put("success", "true");
				result.put("user_pm_key", userPmKey);
			} else {
				result.put("success", "false");
				result.put("message", "PASSWORD FAIL");
			}
		} else {
			result.put("success", "false");
			result.put("message", "EMAIL FAIL");
		}
		
		
		return result;
	}

	@Override
	public Map<String, String> getUserData(int USER_PM_KEY) throws JsonProcessingException{
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String , String> userData = usersDao.getUserData(USER_PM_KEY);
		if( userData != null) {
			result.put("success", "true");
			result.put("userData", mapper.writeValueAsString(userData) );
		} else {
			result.put("success", "false");
			result.put("message", "USER NOT FOUND");
		}
		
		return result;
	}
	
}
