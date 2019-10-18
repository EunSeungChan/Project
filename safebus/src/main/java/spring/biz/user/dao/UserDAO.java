package spring.biz.user.dao;

import java.util.List;
import spring.biz.user.vo.UserVO;

public interface UserDAO {
	
	   UserVO login(String id,String pw);
	   
	   int addUser(UserVO user);
	   
	   UserVO getUser(String user_id);
	   
	   List<UserVO> getUserList();
	   
	   int updateUser(UserVO user);
	   
	   int removeUser(String user_id);
	   
	   List<UserVO> searchUser(String condition,String keyword);
}
