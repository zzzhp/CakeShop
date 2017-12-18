package com.zzzHp.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	private String username;
	private String email;
	private String password;
	private Set<Login> loginset = new HashSet<Login>();
	private Set<Lists> listset = new HashSet<Lists>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	public Set<Login> getLoginset() {
		return loginset;
	}
	public void setLoginset(Set<Login> loginset) {
		this.loginset = loginset;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="useranme")
	public Set<Lists> getListset() {
		return listset;
	}
	public void setListset(Set<Lists> listset) {
		this.listset = listset;
	}
	
}
