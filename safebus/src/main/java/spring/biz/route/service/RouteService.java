package spring.biz.route.service;

import java.util.List;

import spring.biz.driver.vo.DriverVO;
import spring.biz.route.vo.RouteVO;

public interface RouteService {
	
	int addRoute(RouteVO route);
	
	RouteVO getRoute(String station);

	List<RouteVO> getRouteList();
	
	String getRouteInfo_gokinder (String state, String station1, String station2);
	
	int absent(String station);

	int present(String station);

	int addCount(String station);
}
