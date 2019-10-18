package spring.biz.teacher.vo;

import java.sql.Date;

public class TeacherVO {

	private String user_id;
	private String user_info;
	private String teacher_name;
	private String teacher_phone;
	private Date reg_date;
	private String teacher_img;
	
	
	public TeacherVO() {
		super();
	}


	public TeacherVO(String user_id, String user_info, String teacher_name, String teacher_phone, Date reg_date,
			String teacher_img) {
		super();
		this.user_id = user_id;
		this.user_info = user_info;
		this.teacher_name = teacher_name;
		this.teacher_phone = teacher_phone;
		this.reg_date = reg_date;
		this.teacher_img = teacher_img;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_info() {
		return user_info;
	}


	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getTeacher_phone() {
		return teacher_phone;
	}


	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}


	public Date getReg_date() {
		return reg_date;
	}


	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


	public String getTeacher_img() {
		return teacher_img;
	}


	public void setTeacher_img(String teacher_img) {
		this.teacher_img = teacher_img;
	}


	@Override
	public String toString() {
		return "TeacherVO [user_id=" + user_id + ", user_info=" + user_info + ", teacher_name=" + teacher_name
				+ ", teacher_phone=" + teacher_phone + ", reg_date=" + reg_date + ", teacher_img=" + teacher_img + "]";
	}

	
}
