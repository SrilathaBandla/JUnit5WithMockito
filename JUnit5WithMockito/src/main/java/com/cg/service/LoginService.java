package com.cg.service;

import com.cg.entity.Login;

public interface LoginService {
	
	public boolean login(Login login);
	
	public boolean register(Login login);
	
//	public boolean changePassWord(long mobileNum,String curPassWord,String newPassWord);

}
