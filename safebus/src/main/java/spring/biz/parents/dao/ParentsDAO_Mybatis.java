package spring.biz.parents.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.parents.vo.ParentsVO;
import spring.biz.user.vo.UserVO;

@Component("parentsmybatis")
public class ParentsDAO_Mybatis implements ParentsDAO {

	
	@Autowired
	SqlSession sqlSession=null;
	
	public ParentsDAO_Mybatis() {

	}

	public int addParents(ParentsVO parents) {
		System.out.println("mybatis parents add 연동");
		return sqlSession.insert("parents.add",parents);
	}
	
	public List<ParentsVO> getParentsList() {

        return sqlSession.selectList("parents.list");
	}

	@Override
	public ParentsVO getParents(String user_id) {
		
		return sqlSession.selectOne("parents.getparents",user_id);
	}

	
	
	
	
	
}
