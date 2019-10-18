package spring.biz.route.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.driver.vo.DriverVO;
import spring.biz.route.dao.RouteDAO;
import spring.biz.route.vo.RouteVO;

@Service("routeservice")
public class RouteServiceImpl implements RouteService{
	
	@Resource(name = "routemybatis")
	RouteDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public RouteServiceImpl() {
		super();
	}
	
	public RouteDAO getDao() {
		return dao;
	}
	
	public void setDao(RouteDAO dao) {
		this.dao = dao;
	}
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public int addRoute(RouteVO Route) {
		return dao.addRoute(Route);
	}

	@Override
	public RouteVO getRoute(String station) {
		return dao.getRoute(station);
	}

	@Override
	public List<RouteVO> getRouteList() {
		return dao.getRouteList();
	}
	
	@Override
	public String getRouteInfo_gokinder(String state, String station1, String station2) {
		
		return null;
	}
	
	@Override
	public int absent(String station) {

		System.out.println("서비스 station : "+station);
	
		return dao.absent(station);
	}


	@Override
	public int present(String station) {
		// TODO Auto-generated method stub
		return dao.present(station);
	}
	
	
	// 회원가입할때  station 확인하고 해당 station의 count +1 , 
	// 현재 로그인하면 해당 station이 넘어가고 결석 누르면 absent +1 , count -1
	// station 마다 count 몇개인지 check하고 보여준다 
	@Override
	public int addCount(String station) {
		// TODO Auto-generated method stub
		return dao.addCount(station);
	}
	

}
