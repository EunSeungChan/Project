package spring.biz.parents.vo;

import java.sql.Date;

public class ParentsVO {
	
	private String user_id;
	private String user_info;
	private String baby_name;
	private String baby_gender;
	private String parent_name;
	private String parent_phone;
	private String address;
	private String rfid;
	private String station;
	private Date reg_date;
	
	
	public ParentsVO() {}


	public ParentsVO(String user_id, String user_info, String baby_name, String baby_gender, String parent_name,
			String parent_phone, String address, String rfid, String station, Date reg_date) {
		super();
		this.user_id = user_id;
		this.user_info = user_info;
		this.baby_name = baby_name;
		this.baby_gender = baby_gender;
		this.parent_name = parent_name;
		this.parent_phone = parent_phone;
		this.address = address;
		this.rfid = rfid;
		this.station = station;
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

	public String getBaby_name() {
		return baby_name;
	}

	public void setBaby_name(String baby_name) {
		this.baby_name = baby_name;
	}

	public String getBaby_gender() {
		return baby_gender;
	}

	public void setBaby_gender(String baby_gender) {
		this.baby_gender = baby_gender;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getParent_phone() {
		return parent_phone;
	}

	public void setParent_phone(String parent_phone) {
		this.parent_phone = parent_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "ParentsVO [user_id=" + user_id + ", user_info=" + user_info + ", baby_name=" + baby_name
				+ ", baby_gender=" + baby_gender + ", parent_name=" + parent_name + ", parent_phone=" + parent_phone
				+ ", address=" + address + ", rfid=" + rfid + ", station=" + station + ", reg_date=" + reg_date + "]";
	}

	
	

}
