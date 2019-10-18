package spring.biz.user.vo;

public class UserVO {

	private String user_id;
	private String user_pw;
	private String user_info;
	
	
	public UserVO() {
		super();
	}


	public UserVO(String user_id, String user_pw, String user_info) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_info = user_info;
	}


	public String getUserid() {
		return user_id;
	}


	public void setUserid(String user_id) {
		this.user_id = user_id;
	}


	public String getUserpwd() {
		return user_pw;
	}


	public void setUserpwd(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUserinfo() {
		return user_info;
	}


	public void setUserinfo(String user_info) {
		this.user_info = user_info;
	}


	@Override
	public String toString() {
		return "UserVO [userid=" + user_id + ", userpwd=" + user_pw + ", userinfo=" + user_info + "]";
	}
	
	
	
}