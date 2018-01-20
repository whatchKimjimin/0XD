package co.kr.soboat.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface BoatsDao {
	// INSERT BOATS
	public int insertBoat(Map<String , String> reqParam);
	// SEARCH BOATS AT POSITION
	public List<Map<String , String>> positionSearchBoat(String position);
	
	// DELETE BOATS
	public int deleteBoat(int BOATS_PM_KEY);


}
