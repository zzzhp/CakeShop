package com.zzzHp.cakeonline.cake.dao;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.zzzHp.cakeonline.entity.Cake;

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
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Cake where cakeid=("
				+ "select cakeid from Caketype where categories=? ) ").setParameter(0, name);
		return q.list();
		
	}
}
