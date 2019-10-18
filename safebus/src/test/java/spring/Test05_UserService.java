package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test05_UserService {
	
	@Autowired
	UserService service;

	@Test
	public void login() {
		System.out.println(service.login("admin", "a1234"));
	}
	
	//@Test
	public void list() {
		for(UserVO vo : service.getUserList()) {
        	System.out.println(vo);
        }
	}
	
	//@Test
	public void add() {
		UserVO user  = new UserVO();
		user.setUserid("java09");
		//user.setUsername("홍길동");
		user.setUserpwd("1234");
		//user.setPhone("010-2222-1234");
		//user.setEmail("hong@naver.com");
		//user.setAddress("멜티캠퍼스");
		int row = service.addUser(user);
		System.out.println("insert => "+row);
	}
	//@Test
	public void update() {
		UserVO user = service.getUser("java09");
		user.setUserpwd("9999");
		//user.setPhone("010-2234-0909");
		int row = service.updateUser(user);
		System.out.println("update   "+row);
	}
	//@Test
	public void getUser() {
	    System.out.println(service.getUser("java09"));
	}
	@Test
	public void searchUser() {
		for(UserVO vo : service.searchUser("username", "홍")) {
        	System.out.println(vo);
        }
	}
	//@Test
	public void removeUser() {
	  int row = service.removeUser("java09");
	  System.out.println("removeUser   "+row);
	}
}


