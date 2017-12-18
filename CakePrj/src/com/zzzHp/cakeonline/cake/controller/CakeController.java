package com.zzzHp.cakeonline.cake.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzzHp.cakeonline.entity.Cake;

import com.zzzHp.cakeonline.cake.service.CakeServiceImpl;

@Controller
@RequestMapping("/cake")
public class CakeController {
	@Resource
	private CakeServiceImpl CakeServiceImpl;
	@RequestMapping("/list")
	public String list(@RequestParam("search")String name,Model model){
		List<Cake> list=this.CakeServiceImpl.listAll(name);
		model.addAttribute("list", list);
		return "products";
	}
	@RequestMapping("/listbytype")
	public String listbytype(@RequestParam("search")String name,Model model){
		List<Cake> list=this.CakeServiceImpl.listbytype(name);
		model.addAttribute("list", list);
		return "products";
	}
}
