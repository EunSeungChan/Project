package spring.biz.parents.dao;

import java.util.List;

import spring.biz.parents.vo.ParentsVO;
import spring.biz.user.vo.UserVO;

public interface ParentsDAO {
	
	int addParents(ParentsVO parents);
	
	ParentsVO getParents(String user_id);

	List<ParentsVO> getParentsList();
	
}
