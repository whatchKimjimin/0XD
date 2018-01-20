package co.kr.soboat.service;

import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface BoatsService {
	// INSERT BOATS
	public Map<String , String> insertBoat(Map<String , String> reqParam);
	// DELETE BOATS
	public Map<String , String> deleteBoat(int BOATS_PM_KEY);
	// POSITION SEARCH BOATS
	public Map<String , String> positionSearchBoat(String position) throws JsonProcessingException;
	// DETAIL BOAT
	public Map<String , String> boatDetail(int BOATS_ID) throws JsonProcessingException;
}
