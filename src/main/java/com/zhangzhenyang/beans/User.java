package com.zhangzhenyang.beans;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String uname;
	private String sex;
	private String phone;
	private String email;
	private Date birthday;
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, String uname, String sex, String phone, String email, Date birthday) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	} 
}
