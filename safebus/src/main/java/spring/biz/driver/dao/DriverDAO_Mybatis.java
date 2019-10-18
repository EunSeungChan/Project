package spring.biz.driver.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.driver.vo.DriverVO;

@Component("drivermybatis")
public class DriverDAO_Mybatis implements DriverDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	@Override
	public int addDriver(DriverVO driver) {

		return sqlSession.insert("driver.add",driver);
	}

	@Override
	public DriverVO getDriver(String user_id) {

		return sqlSession.selectOne("driver.getdriver",user_id);
	}

	@Override
	public List<DriverVO> getDriverList() {

		return sqlSession.selectList("driver.list");
	}

	
	
}
