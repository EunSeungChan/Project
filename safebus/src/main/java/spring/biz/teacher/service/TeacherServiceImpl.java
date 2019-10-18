package spring.biz.teacher.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.teacher.dao.TeacherDAO;
import spring.biz.teacher.vo.TeacherVO;

@Service("teacherservice")
public class TeacherServiceImpl implements TeacherService{

	@Resource(name = "teachermybatis")
	TeacherDAO dao;
	
	@Autowired
	ApplicationContext context;

	
	public TeacherServiceImpl() {
		super();
	}

	public TeacherServiceImpl(TeacherDAO dao) {
		super();
		this.dao = dao;
	}


	public TeacherDAO getDao() {
		return dao;
	}

	public void setDao(TeacherDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addTeacher(TeacherVO teacher) {
		// TODO Auto-generated method stub
		return dao.addTeacher(teacher);
	}

	@Override
	public TeacherVO getTeacher(String user_id) {
		// TODO Auto-generated method stub
		return dao.getTeacher(user_id);
	}

	@Override
	public List<TeacherVO> getTeacherList() {
		// TODO Auto-generated method stub
		return dao.getTeacherList();
	}
	
	
}
