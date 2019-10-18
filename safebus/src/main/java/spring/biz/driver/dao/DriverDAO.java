package spring.biz.driver.dao;

import java.util.List;

import spring.biz.driver.vo.DriverVO;

public interface DriverDAO {

	int addDriver(DriverVO driver);
	
	DriverVO getDriver(String user_id);

	List<DriverVO> getDriverList();
	
}
