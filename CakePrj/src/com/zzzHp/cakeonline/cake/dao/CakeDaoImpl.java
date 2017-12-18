package com.zzzHp.cakeonline.cake.dao;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zzzHp.cakeonline.entity.Cake;
import com.zzzHp.cakeonline.entity.Caketype;
import com.zzzHp.cakeonline.entity.Lists;

@Repository
public class CakeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Cake> find(String name){
		if(name.equals("")) {
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake ");
			return q.list();
		}else {
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where cakename=?").setParameter(0, name);
			return q.list();
		}
	}
	public List<Cake> findbytype(String name){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where cakeid=all("
				+ "select cakeid from Caketype where categories=? ) ").setParameter(0, name);
		return q.list();
		
	}
	public List<Lists> findorder(String name){
		Query q= this.sessionFactory.getCurrentSession().createQuery("from Lists");
		return q.list();
	}
	public void order(Lists list) {
				this.sessionFactory.getCurrentSession().save(list);
	}
	public List<Caketype> findct(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Caketype ");
		return q.list();
	}
	public void deletect(int typeid) {
		this.sessionFactory.getCurrentSession().createQuery("delete from Caketype where typeid=?").setParameter(0, typeid);
	}
	public void savect(Caketype ct) {
		this.sessionFactory.getCurrentSession().save(ct);
	}
}
