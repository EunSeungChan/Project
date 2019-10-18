package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{

	@Autowired
	SqlSession sqlSession=null;
	
	public UserDAO_MyBatis() {
		//System.out.println("UserDAO_MyBatis 호출");
	}
	
	public UserVO login(String id, String pw) {
        
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		
		return sqlSession.selectOne("user.login",vo);
	}

	public int addUser(UserVO user) {
		return sqlSession.insert("user.add",user);
	}

	public UserVO getUser(String user_id) {
		return sqlSession.selectOne("user.getuser",user_id);
	}

	public List<UserVO> getUserList() {
        System.out.println("UserDAO_MyBatis 연동");

        //return ui.list();
        
        return sqlSession.selectList("user.list");
	}

	public int updateUser(UserVO user) {
		
		return sqlSession.update("user.update",user);
	}

	public int removeUser(String user_id) {
		return sqlSession.delete("user.delete",user_id);
	}

	public List<UserVO> searchUser(String condition, String keyword) {
	    HashMap<String , String> map = new HashMap<String, String>();
	    map.put(condition,keyword);
		return sqlSession.selectList("user.search",map);
	}
	
}
