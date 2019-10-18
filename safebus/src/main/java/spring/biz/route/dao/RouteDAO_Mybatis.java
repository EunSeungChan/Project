package spring.biz.route.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.driver.vo.DriverVO;
import spring.biz.route.vo.RouteVO;

@Component("routemybatis")
public class RouteDAO_Mybatis implements RouteDAO{
	
	@Autowired
	SqlSession sqlSession = null;

	public RouteDAO_Mybatis() {
		super();
	}

	public RouteDAO_Mybatis(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public int addRoute(RouteVO route) {
		return sqlSession.insert("route.add",route);
	}

	@Override
	public RouteVO getRoute(String station) {
		return sqlSession.selectOne("route.getroute",station);
	}

	@Override
	public List<RouteVO> getRouteList() {
		return sqlSession.selectList("route.list");
	}
	
	@Override
	public int absent(String station) {
				
		
		int result_num = sqlSession.update("route.absent", station);
		System.out.println("결석 : " + result_num);
		return result_num; 
	}
	
	@Override
	public int present(String station) {
		return sqlSession.update("route.present", station);
	}

	// 회원가입시 해당 station count 올리기 위한 함수 
	@Override
	public int addCount(String station) {
		return sqlSession.update("route.addcount", station);
	}

}
