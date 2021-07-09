package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class Login {
	
	@Id
	@Column(length=15)
	private long mobileNum;
	
	@Column
	private String password;
  
	
	

	
	@Override
	public String toString() {
		return "Login [mobileNum=" + mobileNum + ", password=" + password + "]";
	}



	public long getMobileNum() {
		return mobileNum;
	}



	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}



	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
