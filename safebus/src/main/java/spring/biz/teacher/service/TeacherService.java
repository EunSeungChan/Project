package spring.biz.teacher.service;

import java.util.List;

import spring.biz.teacher.vo.TeacherVO;

public interface TeacherService {

int addTeacher(TeacherVO teacher);
	
	TeacherVO getTeacher(String user_id);

	List<TeacherVO> getTeacherList();
	
}
