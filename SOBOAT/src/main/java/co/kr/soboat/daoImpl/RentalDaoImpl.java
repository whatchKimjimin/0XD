package co.kr.soboat.daoImpl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.soboat.dao.RentalDao;

@Repository("RentalDao")
public class RentalDaoImpl implements RentalDao{

	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int boatRental(Map<String, String> reqParam) {
		return sqlSession.insert("boatRental" , reqParam);
	}

	@Override
	public int boatRentalCheck(Map<String, String> reqParam) {
		return sqlSession.selectOne("boatRentalCheck" , reqParam);
	}
	
}
