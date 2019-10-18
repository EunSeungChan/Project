package spring.biz.driver.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.driver.dao.DriverDAO;
import spring.biz.driver.vo.DriverVO;


@Service("driverservice")
public class DriverServiceImpl implements DriverService{
	
	@Resource(name = "drivermybatis")
	DriverDAO dao;
	
	@Autowired
	ApplicationContext context;

	public DriverServiceImpl() {
		super();
	}

	public DriverDAO getDao() {
		return dao;
	}

	public void setDao(DriverDAO dao) {
		this.dao = dao;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	

	@Override
	public int addDriver(DriverVO driver) {
		
		return dao.addDriver(driver);
	}


	@Override
	public List<DriverVO> getDriverList() {

		return dao.getDriverList();
	}

	@Override
	public DriverVO getDriver(String user_id) {

		return dao.getDriver(user_id);
	}

	

	
	
	
	

}
