package spring.biz.teacher.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.parents.vo.ParentsVO;
import spring.biz.teacher.vo.TeacherVO;

@Component("teachermybatis")
public class TeacherDAO_Mybatis implements TeacherDAO {

	@Autowired
	SqlSession sqlSession = null;

	public TeacherDAO_Mybatis() {
		super();
	}
	
	
	public TeacherDAO_Mybatis(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}


	@Override
	public int addTeacher(TeacherVO teacher) {
		System.out.println("mybatis parents add 연동");
		return sqlSession.insert("teacher.add",teacher);
	}
	
	@Override
	public List<TeacherVO> getTeacherList() {

        return sqlSession.selectList("teacher.list");
	}

	@Override
	public TeacherVO getTeacher(String user_id) {
		
		return sqlSession.selectOne("teacher.getteacher",user_id);
	}
	
	
}
