
package co.kr.soboat.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.kr.soboat.dao.BoatsDao;
import co.kr.soboat.service.BoatsService;

@Service("BoatsService")
public class BoatsServiceImpl implements BoatsService{
	
	@Resource(name = "BoatsDao")
	private BoatsDao boatsDao;

	// RESULT
	Map<String , String> result;
		
	@Override
	public Map<String , String> insertBoat(Map<String, String> reqParam) {
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		
		if( boatsDao.insertBoat(reqParam) == 1 ) {
			result.put("success", "true");
		} else {
			result.put("success","false");
		}
		
		return result;
	}

	@Override
	public Map<String, String> deleteBoat(int BOATS_PM_KEY) {
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		
		if( boatsDao.deleteBoat(BOATS_PM_KEY) == 1 ) {
			result.put("success", "true");
		} else {
			result.put("success","false");
		}
		
		return result;
	}

	@Override
	public Map<String, String> positionSearchBoat(String position) throws JsonProcessingException {
		// RESULT 
		this.result = new HashMap<String , String>();
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// SEARCH RESULT
		List<Map<String , String>> searchResult = boatsDao.positionSearchBoat(position);
		
		result.put("success","true");
		result.put("boatData", mapper.writeValueAsString(searchResult));
		
		return result;
	}

	@Override
	public Map<String, String> boatDetail(int BOATS_ID) throws JsonProcessingException {
		// RESULT 
		this.result = new HashMap<String , String>();
		// JACKSON
		ObjectMapper mapper = new ObjectMapper();
		// BOAT DATA
		Map<String , String> boatData = boatsDao.boatDetail(BOATS_ID);
		
		if( boatData != null ) {
			result.put("success", "true");
			result.put("boatData", mapper.writeValueAsString(boatData));
		} else {
			result.put("success", "false");
		}
		
		return result;
	}

	
	
	
}
