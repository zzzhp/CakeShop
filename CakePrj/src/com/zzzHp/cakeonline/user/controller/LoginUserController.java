package com.zzzHp.cakeonline.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzzHp.cakeonline.entity.User;
import com.zzzHp.cakeonline.user.service.LoginUserServiceImpl;

@Controller
@RequestMapping("/loginuser")
public class LoginUserController {
	@Resource
	private LoginUserServiceImpl LoginUserServiceImpl;
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String name,
						@RequestParam("password") String pwd,
						HttpSession session,Model model){
		User u=this.LoginUserServiceImpl.Login(name, pwd);
		if(u!=null){
			session.setAttribute("u", u);
			return "index";
		}else{
			model.addAttribute("erroinfo", "您的账号密码不正确！");
			return "index";
		}
						}

}
