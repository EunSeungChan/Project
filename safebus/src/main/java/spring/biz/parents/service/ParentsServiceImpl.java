package spring.biz.parents.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.parents.dao.ParentsDAO;
import spring.biz.parents.vo.ParentsVO;


@Service("parentsservice")
public class ParentsServiceImpl implements ParentsService{

	
	@Resource(name = "parentsmybatis")
	ParentsDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public ParentsServiceImpl() {
		super();
	}

	public ParentsServiceImpl(ParentsDAO dao) {
		super();
		this.dao = dao;
	}

	public ParentsDAO getDao() {
		return dao;
	}

	public void setDao(ParentsDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<ParentsVO> getParentsList() {
		return dao.getParentsList();
	}

	@Override
	public int addParents(ParentsVO parents) {
		return dao.addParents(parents);
	}

	@Override
	public ParentsVO getParents(String user_id) {
		return dao.getParents(user_id);
	}

	
}
