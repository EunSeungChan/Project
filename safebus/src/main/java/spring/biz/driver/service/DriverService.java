package spring.biz.driver.service;

import java.util.List;

import spring.biz.driver.vo.DriverVO;

public interface DriverService {

	int addDriver(DriverVO driver);
	
	DriverVO getDriver(String user_id);

	List<DriverVO> getDriverList();
	
}
