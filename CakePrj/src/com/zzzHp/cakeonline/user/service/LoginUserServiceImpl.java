package com.zzzHp.cakeonline.user.service;

import javax.annotation.Resource;

import com.zzzHp.cakeonline.entity.User;
import com.zzzHp.cakeonline.user.dao.LoginUserDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class LoginUserServiceImpl {
	@Resource
	private LoginUserDaoImpl LoginUserDaoImpl;
	public User Login(String username,String password) {
		User u = this.LoginUserDaoImpl.findById(username);
		if(u!= null) {
			if(u.getPassword().equals(password)) {
				return u;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

}
