package com.zzzHp.cakeonline.user.dao;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zzzHp.cakeonline.entity.User;

@Repository
public class LoginUserDaoImpl {
	@Resource
	private SessionFactory SessionFactory;
	public User findById(String username) {
		return SessionFactory.getCurrentSession().get(User.class, username);
	}
}
