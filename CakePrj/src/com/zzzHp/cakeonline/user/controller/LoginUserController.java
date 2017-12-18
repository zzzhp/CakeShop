package com.zzzHp.cakeonline.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzzHp.cakeonline.cake.service.CakeServiceImpl;
import com.zzzHp.cakeonline.entity.Cake;
import com.zzzHp.cakeonline.entity.Caketype;
import com.zzzHp.cakeonline.entity.Lists;
import com.zzzHp.cakeonline.entity.User;
import com.zzzHp.cakeonline.user.service.LoginUserServiceImpl;

@Controller
@RequestMapping("/loginuser")
public class LoginUserController {
	@Resource
	private LoginUserServiceImpl LoginUserServiceImpl;
	@Resource
	private CakeServiceImpl CakeServiceImpl;
	@RequestMapping("/login")
	public String login(@RequestParam("email") String name,
						@RequestParam("password") String pwd,
						HttpSession session){
		User u=this.LoginUserServiceImpl.Login(name, pwd);
		if(u!=null){
			session.setAttribute("u", u);
			return "index";
		}else{
			return "account";
		}
						}
	@RequestMapping("/adminlogin")
	public String adminlogin(@RequestParam("loginname") String name,
						@RequestParam("password") String pwd,
						HttpSession session,Model model){
		User su=this.LoginUserServiceImpl.Login(name, pwd);
		if(su!=null){
			session.setAttribute("su",su);
			return "backmage";
		}else{
			model.addAttribute("erroinfo", "您的账号密码不正确！");
			return "admin";
		}
						}
	@RequestMapping("/list")
	public String list(@RequestParam("search")String name,
			@RequestParam(value="pageIndex", required=false)String pageIndex,Model model){
		List<Cake> list=this.CakeServiceImpl.listAll(name);
		model.addAttribute("list", list);
		/*int pageCount = (int) Math.ceil(list.size()/9);
		model.addAttribute("pageCount",pageCount);
		int pageindex = 0; 
		if(pageIndex.equals("") ||
				Integer.parseInt(pageIndex)<0) {
			pageindex = 1;
		} else {
			pageindex = Integer.parseInt(pageIndex);
		}
		model.addAttribute("pageIndex",pageindex);*/
		return "products";
	}
	@RequestMapping("/listbytype")
	public String listbytype(@RequestParam("search")String name,Model model){
		List<Cake> list=this.CakeServiceImpl.listbytype(name);
		model.addAttribute("list", list);
		return "products";
		}
	@RequestMapping("/order")
	public String order(HttpSession session,
			@RequestParam("cakeid")int cakeid,
			@RequestParam("size")int size,
			@RequestParam("item_quantity")int count,
			@RequestParam("unitprice")double unitprice,
			@RequestParam("imgsrc")String imgsrc) {
		User u = (User) session.getAttribute("u");
		String username = u.getUsername();
		this.CakeServiceImpl.order(username, cakeid, size, count, unitprice,imgsrc);
		return "products";
	}
	@RequestMapping("/checkout")
	public String checkout(HttpSession session,Model model) {
		User u = (User) session.getAttribute("u");
		String username = u.getUsername();
		List<Lists> orders=this.CakeServiceImpl.findorder(username);
		model.addAttribute("orders",orders);
		return "checkout";
	}
	@RequestMapping("/updatept")
	public String findct(Model model) {
		List<Caketype> list = this.CakeServiceImpl.findct();
		model.addAttribute("list", list);
		return "updatept";
	}
	@RequestMapping("/updateptpt")
	public String deletect(@RequestParam("typeid")int typeid) {
		this.CakeServiceImpl.deletect(typeid);
		return "updatept";
	}
	@RequestMapping("/updateptptpt")
	public String savect(
			@RequestParam("typeid")int typeid,
			@RequestParam("cakeid")int cakeid,
			@RequestParam("color")String color,
			@RequestParam("size")int size,
			@RequestParam("flavour")String flavour,
			@RequestParam("discounts")String discounts,
			@RequestParam("categories")String categories,
			@RequestParam("unitprice")double unitprice,
			@RequestParam("imgsrc")String imgsrc) {
		this.CakeServiceImpl.savect(typeid, cakeid, color, size, flavour, discounts, categories, unitprice);
		return "products";
	}
}
