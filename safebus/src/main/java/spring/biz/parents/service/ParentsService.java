package spring.biz.parents.service;

import java.util.List;

import spring.biz.parents.vo.ParentsVO;



public interface ParentsService {

	int addParents(ParentsVO parents);
	
	ParentsVO getParents(String user_id);

	List<ParentsVO> getParentsList();
	   
	   
}
