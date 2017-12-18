package com.zzzHp.cakeonline.cake.service;

import java.util.List;
import javax.annotation.Resource;
import com.zzzHp.cakeonline.cake.dao.CakeDaoImpl;
import com.zzzHp.cakeonline.entity.Cake;
import com.zzzHp.cakeonline.entity.Caketype;
import com.zzzHp.cakeonline.entity.Lists;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=false)
public class CakeServiceImpl {
	@Resource
	private CakeDaoImpl CakeDaoImpl;
	public List<Cake> listAll(String name){
		return this.CakeDaoImpl.find(name);
	}
	public List<Cake> listbytype(String name) {
		return this.CakeDaoImpl.findbytype(name);
	}
	public List<Lists> findorder(String name){
		return this.CakeDaoImpl.findorder(name);
	}
	public void order(String username,int cakeid,int size,int count,double unitprice,String imgsrc) {
		Lists list = new Lists();
		list.setUsername(username);
		list.setCakeid(cakeid);
		list.setCount(count);
		list.setSize(size);
		list.setImgsrc(imgsrc);
		double total = count*unitprice;
		list.setTotal(total);
		this.CakeDaoImpl.order(list);
	}
	public List<Caketype> findct(){
		return this.CakeDaoImpl.findct();
	}
	public void deletect(int typeid) {
		this.CakeDaoImpl.deletect(typeid);
	}
	public void savect(int typeid,int cakeid,String color,int size,String flavour,String discounts,String categories,double unitprice) {
		Caketype ct= new Caketype();
		ct.setCakeid(typeid);
		ct.setCakeid(cakeid);
		ct.setColor(color);
		ct.setSize(size);
		ct.setFlavour(flavour);
		ct.setDiscounts(discounts);
		ct.setDiscounts(discounts);
		ct.setCategories(categories);
		this.CakeDaoImpl.savect(ct);
	}
}
