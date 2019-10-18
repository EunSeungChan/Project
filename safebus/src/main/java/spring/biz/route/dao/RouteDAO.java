package spring.biz.route.dao;

import java.util.List;

import spring.biz.driver.vo.DriverVO;
import spring.biz.route.vo.RouteVO;

public interface RouteDAO {

	int addRoute(RouteVO route);
	
	RouteVO getRoute(String station);

	List<RouteVO> getRouteList();
	
	int absent(String station);

	int present(String station);
	
	int addCount(String station);
}
