package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoginRepository;
import com.cg.entity.Login;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository repository;

	@Override
	public boolean login(Login login) {
		// TODO Auto-generated method stub
		boolean existedReg = repository.existsById(login.getMobileNum());
		if(existedReg) {
			
			Login reg= repository.getOne(login.getMobileNum());
			
				if (reg.getPassword().equals(login.getPassword())) {
					return true;
				}

				else
					return false;
			} else
				return false;

		}
	

	@Override
	public boolean register(Login login) {
		// TODO Auto-generated method stub
		long phoneNum = login.getMobileNum();
		boolean existedReg = repository.existsById(phoneNum);
		
		if(existedReg == false) {
			repository.save(login);
			return true;
		}else {
			return false;
		}
	}
	

/*	@Override
	public boolean changePassWord(long mobileNum, String curPassWord, String newPassWord) {
		// TODO Auto-generated method stub
		return false;
	}

*/
}
