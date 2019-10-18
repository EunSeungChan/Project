package spring.biz.driver.vo;

import java.sql.Date;

public class DriverVO {

	private String user_id;
	private String user_info;
	private String dirver_name;
	private String driver_phone;
	private String driver_license;
	private String car_number;
	private String driver_img;
	private Date reg_date;
	
	public DriverVO() {
		super();
	}

	public DriverVO(String user_id, String user_info, String dirver_name, String driver_phone, String driver_license,
			String car_number, String driver_img, Date reg_date) {
		super();
		this.user_id = user_id;
		this.user_info = user_info;
		this.dirver_name = dirver_name;
		this.driver_phone = driver_phone;
		this.driver_license = driver_license;
		this.car_number = car_number;
		this.driver_img = driver_img;
		this.reg_date = reg_date;
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

	public String getDirver_name() {
		return dirver_name;
	}

	public void setDirver_name(String dirver_name) {
		this.dirver_name = dirver_name;
	}

	public String getDriver_phone() {
		return driver_phone;
	}

	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}

	public String getDriver_license() {
		return driver_license;
	}

	public void setDriver_license(String driver_license) {
		this.driver_license = driver_license;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getDriver_img() {
		return driver_img;
	}

	public void setDriver_img(String driver_img) {
		this.driver_img = driver_img;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "DriverVO [user_id=" + user_id + ", user_info=" + user_info + ", dirver_name=" + dirver_name
				+ ", driver_phone=" + driver_phone + ", driver_license=" + driver_license + ", car_number=" + car_number
				+ ", driver_img=" + driver_img + ", reg_date=" + reg_date + "]";
	}
	
	
	
}
