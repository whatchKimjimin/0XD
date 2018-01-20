package co.kr.soboat.daoImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.soboat.dao.BoatsDao;

@Repository("BoatsDao")
public class BoatsDaoImpl implements BoatsDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertBoat(Map<String, String> reqParam) {
		return sqlSession.insert("insertBoat" , reqParam);
	}

	@Override
	public int deleteBoat(int BOATS_PM_KEY) {
		return sqlSession.delete("deleteBoat",BOATS_PM_KEY);
	}

	@Override
	public List<Map<String, String>> positionSearchBoat(String position) {
		return sqlSession.selectList("positionSearchBoats",position);
	}
}
