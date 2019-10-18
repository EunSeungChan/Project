package spring.biz.teacher.dao;

import java.util.List;

import spring.biz.teacher.vo.TeacherVO;

public interface TeacherDAO {

	
	int addTeacher(TeacherVO teacher);
	
	TeacherVO getTeacher(String user_id);

	List<TeacherVO> getTeacherList();
}
