package com.zzzHp.cakeonline.cake.service;

import java.util.List;
import javax.annotation.Resource;
import com.zzzHp.cakeonline.cake.dao.CakeDaoImpl;
import com.zzzHp.cakeonline.entity.Cake;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class CakeServiceImpl {
	@Resource
	private CakeDaoImpl CakeDaoImpl;
	public List<Cake> listAll(String name){
		return this.CakeDaoImpl.find(name);
	}
	public List listbytype(String name) {
		return this.CakeDaoImpl.findbytype(name);
	}
}
